package testClass;
import org.openqa.selenium.WebDriver;
import page.*;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;

import java.io.IOException;
import java.text.ParseException;

public class Logeo {


    private Login login;
    private CargaInformacion cargaInformacion;
    private DescargarArchivos descargarArchivos;
    private MatrizInformacion matrizInformacion;
    private CargarArchivos cargarArchivos;


//Se agrega constructor
    public Logeo() {

    }
    public void CasoLogin1(String usuario, String clave) throws ParseException, IOException{
        login = new Login();
        cargaInformacion = new CargaInformacion();
        matrizInformacion = new MatrizInformacion();
        descargarArchivos = new DescargarArchivos();
        cargarArchivos = new CargarArchivos();
        login.validarTextoUsuario("Nombre del usuario:");
        login.ingresarUsuario(usuario);
        login.ingresarClave(clave);
        login.clickBtnIngresar();
        //cargaInformacion.recuperarTitulo();
        //cargaInformacion.rellenarCampoTexto("hola");
        //cargaInformacion.rellenarCampoMail("lvenegas@qanova.cl");
        //cargaInformacion.rellenarCampoAreaTexto("Esto es un texto muy largo");
        //cargaInformacion.seleccionarFechaCalendario("2022-03-19");
        //cargaInformacion.rellenarFecha("01/01/2020");
        //cargaInformacion.rellenarLista("valor 3");
        //cargaInformacion.seleccionMultiple("2,3");
        //cargaInformacion.seleccionRadioButton(2);
        //cargaInformacion.clickBtnEnviar();
        //matrizInformacion.validarDespliegue();
        //matrizInformacion.validarTextoTitulo("Matriz de información");
        //matrizInformacion.escribirFiltro("prueba");
        //matrizInformacion.clickBtnFiltrar();
        //matrizInformacion.recuperarDatosFiltrados();
        //descargarArchivos.validarDespliegue();
        //descargarArchivos.ingresarDescargarArchivos();
        //descargarArchivos.descargarPorImagen();
        //cargarArchivos.validarDespliegue();
        //cargarArchivos.ingresarCargarArchivos();
        //cargarArchivos.validarTextoTitulo();
        //cargarArchivos.cargarArchivo();
        //matrizInformacion.validarDespliegue();
        //cargarArchivos.clickBtnEnviar();
        //PdfQaNovaReports.addWebReportImage("Archivo de carga", "Archivo cargado exitosamente", EstadoPrueba.PASSED, false);

    }

    public void json() throws IOException {
        LeeJson leerJson = new LeeJson();
        leerJson.generarReporte();
    }
}
