package testSuite;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClass.Logeo;
import utils.Constants.Navegador;
import utils.DriverContext;
import utils.ReadProperties;
import utils.Reporte.PdfQaNovaReports;


import java.io.IOException;
import java.text.ParseException;

public class Prueba {
    ChromeDriver webDriver;
    //esta es la direccion del caso de buscar animales:
   // String urlGoogle = "https://www.google.cl/";
    //esta es la de qanova
    String url = "http://www.qanovagroup.com/piloto/";

    @BeforeTest
    public void setup(){
        DriverContext.setUp(Navegador.Chrome, url);
        PdfQaNovaReports.createPDF();
    }

    @AfterTest

    public void closeDriver(){
        //DriverContext.closeDriver();
        PdfQaNovaReports.closePDF();
    }

    @Test
    public void pruebaLogin()throws ParseException{
        Logeo logeo = new Logeo();
        String usuario = ReadProperties.readFromConfig("Propiedades.properties").getProperty("usuario");
        String clave = ReadProperties.readFromConfig("Propiedades.properties").getProperty("clave");
        logeo.CasoLogin1(usuario, clave);
        PdfQaNovaReports.closePDF();


    }
}
