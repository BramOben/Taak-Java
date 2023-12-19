package be.inf1.tellerapp;

import be.inf1.tellerapp.model.Botsingen;
import javafx.animation.AnimationTimer;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import be.inf1.tellerapp.model.Pong;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.shape.Circle;

public class FXMLController implements Initializable {

    private BooleanProperty zPressed = new SimpleBooleanProperty();
    private BooleanProperty sPressed = new SimpleBooleanProperty();

    private BooleanBinding keyPressed = zPressed.or(sPressed);

    private int movementVariable = 3;

    @FXML
    private Rectangle shape1;
    
    @FXML
    private Circle bal;

    @FXML
    private AnchorPane scene;
    
    private Pong pong = new Pong();
    private Botsingen botsing;
    @FXML
    void start(ActionEvent event) {
        shape1.setLayoutY(200);
        shape1.setLayoutX(20);
        bal.setLayoutX(200);
        bal.setLayoutY(200);
        pong.restart();
    }

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long timestamp) {
            pong.checkBotsing(bal.getLayoutX(), bal.getLayoutY(), shape1.getLayoutX(), shape1.getLayoutY());
            pong.checkCoordinaat(bal.getLayoutX(), bal.getLayoutY());
            
            balMovement();
            blokjeMovement();
            
            
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        movementSetup();
        
        keyPressed.addListener(((observableValue, aBoolean, t1) -> {
           timer.start();
        }));
    }
    
    
    //beweging bal
    public void balMovement() {
        bal.setLayoutX(bal.getLayoutX() + pong.getXmovement());
        bal.setLayoutY(bal.getLayoutY() + pong.getYmovement());
    }
    
    public void blokjeMovement() {
        if(zPressed.get()) {
                shape1.setLayoutY(shape1.getLayoutY() - movementVariable);
            }

            if(sPressed.get()){
                shape1.setLayoutY(shape1.getLayoutY() + movementVariable);
            }
    }
    
    
    //setup voor bewegendblokje
    public void movementSetup(){
        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.Z) {
                zPressed.set(true);
            }

            if(e.getCode() == KeyCode.S) {
                sPressed.set(true);
            }

        });

        scene.setOnKeyReleased(e ->{
            if(e.getCode() == KeyCode.Z) {
                zPressed.set(false);
            }

            if(e.getCode() == KeyCode.S) {
                sPressed.set(false);
            }
        });
    }
}