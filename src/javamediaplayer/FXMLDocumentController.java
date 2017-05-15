/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamediaplayer;

import java.io.File;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author Paul
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane wndScreen;
    @FXML
    private StackPane movieArea;

    @FXML
    private HBox controlBox;

    @FXML
    private Button playBtn;
    @FXML 
    private MediaView mv;
    
    private MediaPlayer mp;
    
    
    public void playMovie(ActionEvent e)
    {
     
        System.out.println("playMovie Method entered!");
      
        mp.play();
    
    }
            
    public void pauseMovie(ActionEvent e)
    {
    
      mp.pause();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File file=new File("c:/users/paul/videos/trailer.mp4");

        String source=file.toURI().toString();

        Media media = new Media(source);
        mp = new MediaPlayer(media);   
  
       mv = new MediaView (mp);
       DoubleProperty mvw = mv.fitWidthProperty();
        DoubleProperty mvh = mv.fitHeightProperty();
        mvw.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
        mvh.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
        mv.setPreserveRatio(true);
        movieArea.getChildren().addAll(mv);
    }    
    
}
