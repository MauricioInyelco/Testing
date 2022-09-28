package testClass;
import org.openqa.selenium.WebDriver;
import page.*;
import utils.ReadProperties;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;
import utils.Utils;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

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
          cargarArchivos = new CargarArchivos();
          matrizInformacion = new MatrizInformacion();
          login.validarTextoUsuario("Nombre del usuario:");
          login.ingresarUsuario(usuario);
          login.ingresarClave(clave);
          login.clickBtnIngresar();
          cargaInformacion.recuperarTitulo();
          matrizInformacion.abrirMatrizInformacion();
          matrizInformacion.validarDespliegue();
          matrizInformacion.escribirFiltro("prueba");
          matrizInformacion.clickBtnFiltrar();
          List<String> datosWeb = matrizInformacion.recuperarDatosFiltradosBd();
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
        //matrizInformacion.recuperarDatosFiltrados();
        //descargarArchivos = new DescargarArchivos();
        //descargarArchivos.validarDespliegue();
        //descargarArchivos.ingresarDescargarArchivos();
        //descargarArchivos.descargarPorImagen();
        //cargarArchivos.validarDespliegue();
        //cargarArchivos.ingresarCargarArchivos();
        //cargarArchivos.validarTextoTitulo();
        //cargarArchivos.cargarArchivo();
        //cargarArchivos.clickBtnEnviar();
        //PdfQaNovaReports.addWebReportImage("Archivo de carga", "Archivo cargado exitosamente", EstadoPrueba.PASSED, false);
        /** Conexion a base de datos */
//        Utils.getConnection();
        /** Consulta SQL a base de datos */
//        String ip = ReadProperties.readFromConfig("Propiedades.properties").getProperty("ipBaseDeDatos");
//        String bd = ReadProperties.readFromConfig("Propiedades.properties").getProperty("baseDeDatos");
//        String usuarioBd = ReadProperties.readFromConfig("Propiedades.properties").getProperty("usuarioBaseDeDatos");
//        String claveBd = ReadProperties.readFromConfig("Propiedades.properties").getProperty("claveBaseDeDatos");
//        String query = "select * from form where id = 1;";
//        Utils.consultaBaseDeDatos(ip, bd, usuarioBd, claveBd, query);
        /**Comparacion lista tabla web con base de datos*/
        String ip = ReadProperties.readFromConfig("Propiedades.properties").getProperty("ipBaseDeDatos");
        String bd = ReadProperties.readFromConfig("Propiedades.properties").getProperty("baseDeDatos");
        String usuarioBd = ReadProperties.readFromConfig("Propiedades.properties").getProperty("usuarioBaseDeDatos");
        String claveBd = ReadProperties.readFromConfig("Propiedades.properties").getProperty("claveBaseDeDatos");
        String query = "select * from form where Campo_Texto like '%prueba%' or Campo_Mail like '%prueba%' or Campo_Area_de_Texto like '%prueba%';";
        List<String> datosBd = Utils.consultaBaseDeDatos(ip, bd, usuarioBd, claveBd, query);
        System.out.println("Datos recuperados desde la base de datos: " + datosBd);
        System.out.println("Datos recuperados desde la web: " + datosWeb);
        if(datosBd.equals(datosWeb)){
            PdfQaNovaReports.addReport("Comparacion datos web vs base de datos", "la comparacion de los datos recuperados desde la web contra los datos recuperados desde la base de datos ha sido exitosa, todos los datos recuperados son iguales", EstadoPrueba.PASSED, false);
        }else{
            PdfQaNovaReports.addReport("Comparacion datos web vs base de datos", "la comparacion de los datos recuperados desde la web contra los datos recuperados desde la base de datos ha fallado, los datos son distintos", EstadoPrueba.FAILED, true);
        }


    }

    public void json() throws IOException {
        LeeJson leerJson = new LeeJson();
        leerJson.generarReporte();
    }
}
