package com.mycompany.proyectoarrayruben;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


/**
 *
 * @author Ruben Mejias
 */

public class ColorAleatorio extends StackPane {
    
    Colores colores;
    CreacionTablero coloresTablero;
    
    
    // Metodo para ver el color que ha tocado en la secuencia de partida
    public ColorAleatorio(int nuevoNumSecuencia){
        
        
        // Rectangulo que muestra el color
        Circle circleColor = new Circle();
        circleColor.setRadius(45); 
        circleColor.setCenterX(15);
        circleColor.setCenterY(10);
                      
        Label labelColor = new Label();
        
               
        // Color de la ficha aleatoria
        switch(nuevoNumSecuencia){
            case 1:
                circleColor.setFill(Color.RED);
                break;
            case 2:
                circleColor.setFill(Color.BLUE);
                break;
            case 3:
                circleColor.setFill(Color.GREEN);
                break;
            case 4:
                circleColor.setFill(Color.YELLOW);
                break;
            case 6:
                circleColor.setFill(Color.CYAN);
                break;
            case 7:
                circleColor.setFill(Color.PURPLE);
                break;
            case 8:
                circleColor.setFill(Color.PINK);
                break;
            case 9:
                circleColor.setFill(Color.GRAY);
                break;
        }
        labelColor.setText(Integer.toString(nuevoNumSecuencia));       
        this.getChildren().add(labelColor);
        this.getChildren().add(circleColor);
    }
}
