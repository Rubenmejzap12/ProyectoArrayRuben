package com.mycompany.proyectoarrayruben;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class CreacionTablero extends GridPane{
    
    Colores colores;
    final int TAM_X=150;
    final int TAM_Y=150;
    Puntos objPuntuacion;
    
    
    /*
    *Metodo para ver el tablero del juego con sus colores.Cada numero del array
    *tiene su color.
    */
      
    public CreacionTablero(Colores colores, Puntos objPuntuacion){
        this.colores = colores;
        this.objPuntuacion = objPuntuacion;
        //this.setStyle("-fx-grid-lines-visible:false"); //Crea las lineas del tablero
        for(int y=0; y<colores.numFilas; y++) {
            for(int x=0; x<colores.numColumnas; x++) {
                
                int num = colores.getNumPos(x, y);
                String strNum = String.valueOf(num);
                Label label = new Label(strNum);
                Rectangle r = new Rectangle();
                r.setWidth(150);
                r.setHeight(150);
                label.setPrefWidth(150);
                label.setPrefHeight(150);
                label.setAlignment(Pos.CENTER);
                
                switch(num){
                    case 1:                                         
                        r.setFill(Color.RED);
                        break;
                    case 2:
                        r.setFill(Color.BLUE);
                        break;
                    case 3:
                        r.setFill(Color.GREEN);
                        break;
                    case 4:
                        r.setFill(Color.YELLOW);
                        break;
                    case 5:
                        r.setFill(Color.TRANSPARENT);
                        break;
                    case 6:
                        r.setFill(Color.CYAN);
                        break;
                    case 7:
                        r.setFill(Color.PURPLE);
                        break;
                    case 8:
                        r.setFill(Color.PINK);
                        break;
                    case 9:
                        r.setFill(Color.GRAY);
                        break;
                }
                this.add(r, x, y); //Para que aparezcan los elementos en la pantalla
//                this.add(label, x, y); //Poner numeros de rectangulos en el tablero
            }
        }       
        this.setMaxHeight(TAM_Y * colores.numFilas);
        this.setMaxWidth(TAM_X * colores.numColumnas);
        this.controlRaton();
    }
    
    //Metodo para cliclear en el tablero el color elegido
    
    public void controlRaton() {
        this.setOnMouseClicked((MouseEvent mouseEvent) -> {
            
            int colClic = (int)(mouseEvent.getX() / TAM_X);
            int filClic = (int)(mouseEvent.getY() / TAM_Y);
            
            int numElegido = colores.getNumPos(colClic, filClic);
            colores.contadorClicJugador++;
            System.out.println("Contador Clic Jugador:"+ colores.contadorClicJugador);
            colores.getSecuenciaJugador(numElegido);
            
            
            if(colores.contadorClicJugador == colores.contadorNumPartida ){
                
                colores.comparacionSecuencia();
                this.objPuntuacion.ActualizarPuntuacion();

            }
        });      
    }
     
}
