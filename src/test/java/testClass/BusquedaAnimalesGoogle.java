package testClass;

import org.openqa.selenium.WebDriver;
import page.Google;

public class BusquedaAnimalesGoogle {


    private Google google;
    //cada caso de prueba seria un metodo void especifico de la clase busqueda en google:

    //1 config para buscar perro
    public void busquedaPerro(WebDriver webDriver){
        google= new Google(webDriver);
        google.ingresarBusqueda("perro");
        google.clicBtnBuscar();
    }
    //segunda config para buscar gato
    public void busquedaGato(WebDriver webDriver){
        google= new Google(webDriver);
        google.ingresarBusqueda("gato");
        google.clicBtnBuscar();
    }
}
