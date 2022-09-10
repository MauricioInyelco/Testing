package testClass;
import org.openqa.selenium.WebDriver;
import page.Login;
import page.CargaInformacion;

import java.io.IOException;
import java.text.ParseException;

public class Logeo {

    WebDriver webDriver;
    private Login login;
    private CargaInformacion cargaInformacion;
//Se agrega constructor
    public Logeo(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void CasoLogin1(String usuario, String clave){
        login = new Login(webDriver);
        cargaInformacion = new CargaInformacion(webDriver);
        login.ingresarUsuario(usuario);
        login.ingresarClave(clave);
        login.clickBtnIngresar();
        cargaInformacion.recuperarTitulo();
        cargaInformacion.rellenarLista("valor 3");
        cargaInformacion.seleccionMultiple("2,3");
        cargaInformacion.seleccionRadioButton(3);
        //cargaInformacion.seleccionarFechaCalendario("2022-03-29");
        cargaInformacion.clickBtnEnviar();
    }
}
