package com.mycompany.proyectoarrayruben;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {  
    
    BorderPane paneRoot = new BorderPane();
    ImageView fondo1;
    
    @Override
    
    public void start(Stage stage) {        
        
        
        var scene = new Scene (paneRoot,800,650);
        stage.setScene(scene);
        stage.setTitle("ColorMemory");
        stage.show();   
                
        Image fondoImg = new Image(getClass().getResourceAsStream("/images/fondo.png")); // RUTA DEL RECURSO QUE VAMOS A USAR
        fondo1 = new ImageView(fondoImg); // ASIGNAMOS LA IMAGEN AL OBJETO
        paneRoot.getChildren().add(fondo1); //AÑADE EL OBJETO O IMAGEN A LA PANTALLA DEL JUEGO 
        
        //Creo objeto colores que es la clase del funcionamiento del juego
        Colores colores = new Colores(paneRoot);
        
        //Creo puntuacion donde se guarda la puntuación del juego
        Puntos puntuacion = new Puntos(paneRoot,colores);
        puntuacion.ActualizarPuntuacion();            
        
        //Genero el tablero de la partida
        colores.generarTablero();
        

        //Genero el primer numero de la secuencia de la partida
        colores.getSecuenciaNumeros();
              
        //Creo CreacionTablero que es el tablero con sus formas y colores
        CreacionTablero coloresTablero = new CreacionTablero(colores,puntuacion);
        paneRoot.setCenter(coloresTablero);
        
        //Creo el colorAleatorio que es el color que tienes que memorizar
        ColorAleatorio colorjuego = new ColorAleatorio(colores.nuevoNumSecuencia);
        paneRoot.setTop(colorjuego);
        
        //Reinicio
        scene.setOnKeyPressed((KeyEvent event) -> {
                            switch (event.getCode()) {
                                case ESCAPE:
                                    System.out.println("Reinicio");
                                    
                                    //Reinicio HBox
                                    HBox paneReinicio = new HBox();
                                    paneReinicio.setAlignment(Pos.TOP_CENTER);
                                    paneReinicio.setMinHeight(70);
                                    paneRoot.setBottom(paneReinicio);
                                    paneReinicio.setSpacing(20);
                                    

                                    Text textoPuntuacion = new Text ("Has Reiniciado! Suerte!");
                                    textoPuntuacion.setLayoutX(30);

                                    textoPuntuacion.setFont(Font.font(25));
                                    textoPuntuacion.setFill(Color.BLACK);

                                    paneReinicio.getChildren().add(textoPuntuacion);
                                    //Reinicio variables y llamamos a nuevos métodos
                                    colores.puntuacion=0;
                                    colores.nuevoNumSecuencia=0;
                                    colores.secuencia="";
                                    colores.secuenciaJugador="";
                                    colores.contadorNumPartida=0;
                                    colores.generarTablero();
                                    puntuacion.ActualizarPuntuacion();
                                    colores.getSecuenciaNumeros();
                                    ColorAleatorio colorJuegoReinicio = new ColorAleatorio(colores.nuevoNumSecuencia);
                                    paneRoot.setTop(colorJuegoReinicio);
                                    CreacionTablero coloresViewReinicio = new CreacionTablero(colores,puntuacion);                                  
                                    paneRoot.setCenter(coloresViewReinicio);
                                    
                                                                   
                            }
        });
        
    }
       

    public static void main(String[] args) {
        launch();
    }

}