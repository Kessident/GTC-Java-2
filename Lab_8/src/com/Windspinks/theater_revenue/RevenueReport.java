package com.Windspinks.theater_revenue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RevenueReport extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid);
        primaryStage.setTitle("Theater Revenue");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
