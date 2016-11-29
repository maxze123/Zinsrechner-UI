/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zinsrechner;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        grid.add(output, 0, 4);
        output.setVisible(false);
        
        Label error = new Label();
        error.setText("Nur Zahlen erlaubt!");
        error.setTextFill(Color.FIREBRICK);
        grid.add(error, 3, 1);
        error.setVisible(false);
        
        Label percent = new Label("Zinssatz:");
        percent.setFont(new Font("Arial", 14));
        grid.add(percent, 0, 2);
        
        TextField percentInput = new TextField();
        grid.add(percentInput, 1, 2);
        
        Label percent1 = new Label("%");
        percent1.setFont(new Font("Arial", 14));
        grid.add(percent1, 2, 2);
        
        Label time = new Label("Laufzeit");
        time.setFont(new Font("Arial", 14));
        grid.add(time, 0, 3);
        
        TextField timeInput = new TextField();
        grid.add(timeInput, 1, 3);
        
        Label years = new Label("Jahre:");
        years.setFont(new Font("Arial", 14));
        grid.add(years, 2, 3);
        
        Button submit = new Button("Bestätigen");
        grid.add(submit, 0, 5);
        submit.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                error.setVisible(false);
                output.setVisible(false);
                if(startingInput.getText().matches("\\d*") && percentInput.getText().matches("\\d*")  && timeInput.getText().matches("\\d*")){
                double k = Double.valueOf(startingInput.getText());
                double zinssatz = Double.valueOf(percentInput.getText());
                zinssatz = (zinssatz / 100) + 1;
                int n = Integer.parseInt(timeInput.getText());
                
                for (int i = 0; i < n; i++) {
                    k = k * zinssatz;
                }
                k = round(k, 2);
                String erg = Double.toString(k);
                
                output.setText(erg);
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
    
    public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
