package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverContext;
import utils.Validaciones;

import java.util.ArrayList;
import java.util.List;

public class MatrizInformacion {

    @FindBy(xpath = "//span[@class='imMnMnTextLabel' and text()='Matriz de información']")
    private WebElement btnMatrizInformacion;

    @FindBy(id = "imPgTitle")
    private WebElement titulo;

    @FindBy(id = "pluginAppObj_4_01_filter_field")
    private WebElement txtFiltro;

    @FindBy(id = "pluginAppObj_4_01_filter_button")
    private WebElement btnFiltrar;

    @FindBy(xpath = "//span[@class='jtable-page-number-next']")
    private WebElement btnPaginaSiguiente;

    @FindBy(xpath = "//span[@class='jtable-page-info']")
    private WebElement spanCantidad;

    @FindBy(xpath = "//table[@class='jtable']")
    private WebElement tabla;

    public MatrizInformacion() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void abrirMatrizInformacion(){
        btnMatrizInformacion.click();
    }

    public void validarDespliegue() {
        Validaciones.validarObjeto(titulo, "Titulo pagina");
    }

    public void validarTextoTitulo(String texto) {
        Validaciones.validarTexto(titulo, texto);
    }

    public void escribirFiltro(String filtro) {
        txtFiltro.sendKeys(filtro);
    }

    public void clickBtnFiltrar() {
        btnFiltrar.click();
    }

    public List<String> recuperarDatosFiltrados() {
        WebElement cuerpo = tabla.findElement(By.tagName("tbody"));
        WebElement fila;
        List<String> datosFila = new ArrayList<String>();
        String datosColumna = "";
        for (int x = 0; x < cuerpo.findElements(By.tagName("tr")).size(); x++) {
            fila = cuerpo.findElements(By.tagName("tr")).get(x);
            for (int y = 0; y < fila.findElements(By.tagName("td")).size(); y++) {
                datosColumna = datosColumna + fila.findElements(By.tagName("td")).get(y).getText() + ";";
            }
            datosColumna = datosColumna.substring(0, datosColumna.length() - 1);
            System.out.println("Se recupera la fila nro "+(x+1)+", con los siguientes datos: \n"+datosColumna);
            datosFila.add(datosColumna);
            datosColumna = "";
        }
        return datosFila;
    }
/** Recupera datos filtrados de la base de datos*/
    public List<String> recuperarDatosFiltradosBd() {
        WebElement cuerpo;
        WebElement fila;
        List<String> datosFila = new ArrayList<String>();
        String datosColumna = "";
        Validaciones.validarObjeto(tabla.findElement(By.tagName("tbody")), "Vista Tabla");
        int registros = Integer.parseInt(spanCantidad.getText().substring(spanCantidad.getText().lastIndexOf("of") + 3).trim());
        for(int c = 0; c <= registros/10; c++){
            cuerpo = tabla.findElement(By.tagName("tbody"));
            for (int x = 0; x < cuerpo.findElements(By.tagName("tr")).size(); x++) {
                fila = cuerpo.findElements(By.tagName("tr")).get(x);
                for (int y = 0; y < fila.findElements(By.tagName("td")).size(); y++) {
                    datosColumna += fila.findElements(By.tagName("td")).get(y).getText().trim() + ";";
                }
                datosColumna = datosColumna.substring(0, datosColumna.length() - 3);
                System.out.println("Se recupera la fila nro "+(x+1)+", con los siguientes datos: \n"+datosColumna);
                datosFila.add(datosColumna);
                datosColumna = "";
            }
            if(c < (registros/10)){
                btnPaginaSiguiente.click();
                Validaciones.validarObjeto(tabla.findElement(By.tagName("tbody")), "Vista tabla numero" +(c+2));
            }
        }
        return datosFila;
    }
}
