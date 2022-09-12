package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverContext;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;
import utils.Validaciones;


public class Login {

    @FindBy(xpath = "//*[@id=\"imLogin\"]/form/div[1]/label/span")
    private WebElement labelUsuario;

    @FindBy(xpath = "//input[@id = 'imUname']")
    private WebElement inputUsuario;

    @FindBy(xpath = "//input[@id = 'imPwd']")
    private WebElement inputClave;

    @FindBy(xpath = "//input[contains(@value,'Ingresar a Demo')]")
    private WebElement btnIngresar;


    public Login (){
        PageFactory.initElements(DriverContext.getDriver(), this);

    }
    public void ingresarUsuario(String usuario){
        Validaciones.validarObjeto(inputUsuario, "input usuario");
        PdfQaNovaReports.addWebReportImage("Despliegue Login", "Login desplegado correctamente", EstadoPrueba.PASSED, true);
        inputUsuario.sendKeys(usuario);
    }

    public void ingresarClave(String clave){

        inputClave.sendKeys(clave);
    }

    public void clickBtnIngresar()  {
        PdfQaNovaReports.addWebReportImage("Datos Login", "Se ingresa usuario y contraseña", EstadoPrueba.PASSED, false);
        btnIngresar.click();
    }

    public void validarTextoUsuario(String texto){
        Validaciones.validarTexto(labelUsuario, texto);
    }
}
