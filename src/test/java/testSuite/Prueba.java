package testSuite;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClass.Logeo;


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
        System.setProperty("webdriver.chrome.driver", "driverNavegador/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(url);

    }

    @AfterTest

    public void closeDriver(){
      //webDriver.close();

    }

    @Test
    public void pruebaLogin(){
        Logeo logeo = new Logeo(webDriver);
        logeo.CasoLogin1("nvivas","qanova");


    }
}
