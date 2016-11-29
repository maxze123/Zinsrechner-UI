/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zinsrechner;

import javafx.application.Application;
import static javafx.beans.property.IntegerProperty.integerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author mzeus
 */
public class Zinsrechner extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Zinsrechner");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text text1 = new Text ("Zinsrechner");
        text1.setFont(new Font("Arial", 30));
        grid.add(text1, 0, 0, 2, 1);
        
        Label startkapital = new Label("Startkapital:");
        startkapital.setFont(new Font("Arial", 14));
        grid.add(startkapital, 0, 1);
        
        TextField kapitaleingabe = new TextField();
        grid.add(kapitaleingabe, 1, 1);
        
        Label euro = new Label("€");
        euro.setFont(new Font("Arial", 14));
        grid.add(euro, 2, 1);
        
        Label ausgabe = new Label();
        grid.add(ausgabe, 0, 3);
        
        Button submit = new Button("Bestätigen");
        grid.add(submit, 0, 2);
        submit.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                if () {
                int x = Integer.parseInt(kapitaleingabe.getText());
                ausgabe.textProperty().bind(new SimpleIntegerProperty(x).asString());
                }
            }
        });
        
        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
