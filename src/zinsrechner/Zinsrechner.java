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
import javafx.scene.paint.Color;
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
        primaryStage.setResizable(false);
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text heading = new Text ("Zinsrechner");
        heading.setFont(new Font("Arial", 30));
        grid.add(heading, 0, 0, 2, 1);
        
        Label starting = new Label("Startkapital:");
        starting.setFont(new Font("Arial", 14));
        grid.add(starting, 0, 1);
        
        TextField startingInput = new TextField();
        grid.add(startingInput, 1, 1);
        
        Label euro = new Label("€");
        euro.setFont(new Font("Arial", 14));
        grid.add(euro, 2, 1);
        
        Label output = new Label();
        grid.add(output, 0, 3);
        output.setVisible(false);
        
        Label error = new Label();
        error.setText("Nur Zahlen erlaubt!");
        error.setTextFill(Color.FIREBRICK);
        grid.add(error, 3, 1);
        error.setVisible(false);
        
        Label percent = new Label("Zinssatz");
        percent.setFont(new Font("Arial", 14));
        grid.add(percent, 0, 2);
        
        TextField percentInput = new TextField();
        grid.add(percentInput, 1, 2);
        
        Button submit = new Button("Bestätigen");
        grid.add(submit, 0, 4);
        submit.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                error.setVisible(false);
                output.setVisible(false);
                if(startingInput.getText().matches("\\d*")){
                int x = Integer.parseInt(startingInput.getText());
                output.textProperty().bind(new SimpleIntegerProperty(x).asString());
                output.setVisible(true);
                } else {
                    error.setVisible(true);
                }
            }
        });
        
        Scene scene = new Scene(grid, 500, 250);
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
