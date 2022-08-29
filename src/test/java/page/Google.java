package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Google {

    //@FindBy(className = "gLFyf gsfi")
    //WebElement inputBuscar;

    // @FindBy(xpath = "//input[contains(@data-ved, '0ahUKEwiN5aujgeH5AhXgg5UCHaJSCbYQ4dUDCAs') ]")
    // WebElement btnBuscar;
    //@FindBy(className = "gLFyf gsfi")
    @FindBy(xpath = "//input[contains(@class,'gLFyf gsfi')]")
    WebElement inputBuscar;

    @FindBy(xpath = "//input[contains(@value,'Buscar con Google')]")
    WebElement btnBuscar;



    public Google(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
    public void ingresarBusqueda(String busqueda){
        inputBuscar.sendKeys(busqueda);
    }
    public void clickBtnBuscar(){
        btnBuscar.click();
    }

}