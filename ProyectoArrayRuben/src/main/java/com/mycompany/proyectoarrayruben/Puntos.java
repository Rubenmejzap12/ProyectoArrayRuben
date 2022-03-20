package com.mycompany.proyectoarrayruben;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Puntos extends VBox {
        
        Colores colores;
        BorderPane paneroot;
        Text textoPuntuacionActual = new Text ("0");
        Text textoPuntuacionMaxima = new Text ("0");
        
        
        //Metodo en el que creamos la puntuacion actual de partida y la puntuacion maxima
        public Puntos(BorderPane paneRoot,Colores colores){
            
            this.paneroot = paneRoot;
            this.colores = colores;

            //Layout  puntuacion principal
            HBox panePuntuacion = new HBox();        
            panePuntuacion.setTranslateY(12);
            panePuntuacion.setTranslateX(185);
            panePuntuacion.setSpacing(10);
            paneroot.getChildren().add(panePuntuacion);
             

            //Layout puntuacion actual
            HBox panePuntuacionActual = new HBox();
            panePuntuacionActual.setTranslateX(50);
            panePuntuacionActual.setTranslateY(12);
            panePuntuacionActual.setSpacing(10);
            
            //Texto puntuacion actual
            Text textoPuntuacion = new Text ("Puntuación:");
            textoPuntuacion.setLayoutX(30);
            textoPuntuacion.setFont(Font.font(25));
            textoPuntuacion.setFill(Color.BLACK);

            panePuntuacionActual.getChildren().add(textoPuntuacion);

            paneroot.getChildren().add(panePuntuacionActual);


            //Texto Puntuacion        
            textoPuntuacionActual.setFont(Font.font(25));
            textoPuntuacionActual.setFill(Color.BLACK);
            
            panePuntuacion.getChildren().add(textoPuntuacionActual);
            
             //Puntuacion Maxima
             //PUNTUACION MAXIMA
            HBox paneMaxima = new HBox();        
            paneMaxima.setTranslateY(60);
            paneMaxima.setTranslateX(50);
            paneMaxima.setSpacing(10);
            paneroot.getChildren().add(paneMaxima);

            Text textoMaxima = new Text ("Puntuación Máxima:");
            textoMaxima.setLayoutX(15);
            textoMaxima.setFont(Font.font(25));
            textoMaxima.setFill(Color.BLACK);

            paneMaxima.getChildren().add(textoMaxima);

            HBox panePuntuacionMaxima = new HBox();        
            panePuntuacionMaxima.setTranslateY(40);
            panePuntuacionMaxima.setTranslateX(40);
            panePuntuacionMaxima.setSpacing(0);
            paneroot.getChildren().add(panePuntuacionMaxima);

            
            textoPuntuacionMaxima.setLayoutX(20);
            textoPuntuacionMaxima.setFont(Font.font(30));
            textoPuntuacionMaxima.setFill(Color.BLACK);

            paneMaxima.getChildren().add(textoPuntuacionMaxima);
            
             
        }
      
        public void ActualizarPuntuacion(){
            
            textoPuntuacionActual.setText(String.valueOf(colores.puntuacion));
            
            if (colores.puntuacion > colores.puntuacionMaxima){
                    colores.puntuacionMaxima = colores.puntuacion;
                    
            }
            textoPuntuacionMaxima.setText(String.valueOf(colores.puntuacionMaxima));
        }
        
}

