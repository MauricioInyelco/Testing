package testClass;
import org.openqa.selenium.WebDriver;
import page.Login;
import page.CargaInformacion;

import java.io.IOException;
import java.text.ParseException;

public class Logeo {


    private Login login;
    private CargaInformacion cargaInformacion;

//Se agrega constructor
    public Logeo() {

    }
    public void CasoLogin1(String usuario, String clave) throws ParseException{
        login = new Login();
        cargaInformacion = new CargaInformacion();
        login.validarTextoUsuario("Nombre del usuario:");
        login.ingresarUsuario(usuario);
        login.ingresarClave(clave);
        login.clickBtnIngresar();
        cargaInformacion.recuperarTitulo();
        cargaInformacion.rellenarCampoTexto("hola");
        cargaInformacion.rellenarCampoMail("lvenegas@qanova.cl");
        cargaInformacion.rellenarCampoAreaTexto("Esto es un texto muy largo");
        cargaInformacion.seleccionarFechaCalendario("2022-03-19");
        cargaInformacion.rellenarFecha("01/01/2020");
        cargaInformacion.rellenarLista("valor 3");
        cargaInformacion.seleccionMultiple("2,3");
        cargaInformacion.seleccionRadioButton(2);
        cargaInformacion.clickBtnEnviar();
    }
}
