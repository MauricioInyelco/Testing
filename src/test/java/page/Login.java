package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login {

    @FindBy(xpath = "//input[@id = 'imUname']")
    WebElement inputUsuario;

   @FindBy(xpath = "//input[@id = 'imPwd']")
   WebElement inputClave;

    @FindBy(xpath = "//input[contains(@value,'Ingresar a Demo')]")
    WebElement btnIngresar;
    WebDriverWait webDriverWait;

    public Login (WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriverWait = new WebDriverWait(webDriver, 30);
    }
    public void ingresarUsuario(String usuario){
        webDriverWait.until(ExpectedConditions.visibilityOf(inputUsuario));
        //PdfQaNovaReports.addWebReportImage("Despliegue Login", "Login desplegado correctamente", EstadoPrueba.PASSED, true);
        inputUsuario.sendKeys(usuario);
    }

    public void ingresarClave(String clave){

        inputClave.sendKeys(clave);
    }

    public void clickBtnIngresar()  {
        //PdfQaNovaReports.addWebReportImage("Datos Login", "Se ingresa usuario y contraseña", EstadoPrueba.PASSED, false);
        btnIngresar.click();
    }
}
