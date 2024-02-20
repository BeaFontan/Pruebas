package dev.selenium;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class ChromeTest {

    static ChromeDriver driver;

    @BeforeAll
    public static void start(){

        driver = new ChromeDriver();
        driver.get("http://www.vilanovadearousa.com/");
    }



    @Test
    public void CPR1(){

        WebElement email =  driver.findElement(By.xpath(".//a[@mce_href='http://www.conectavilanova.com/']"));

        email.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



    @Test
    public void CPR2(){

        WebElement buscador =  driver.findElement(By.name("searchword"));

        buscador.sendKeys("tramites");
        buscador.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    @Test
    public void CPR3(){
        
        //WebElement sugerenciasA =  driver.findElement(By.xpath(".//a[@title='Sugerenicas']"));

        driver.get("http://www.vilanovadearousa.com/index.php?option=com_contact&view=contact&id=1%3Abuzon-sugerencias-contac&catid=8%3Aconcello");

        
        WebElement formularioNombre =  driver.findElement(By.id("contact_name"));
        WebElement formularioEmail = driver.findElement(By.id("contact_email"));
        WebElement formularioTema = driver.findElement(By.id("contact_subject"));
        WebElement formularioMensaje = driver.findElement(By.id("contact_text"));
        WebElement checkEnvioEmail = driver.findElement(By.id("contact_email_copy"));
        WebElement botonEnviarForm = driver.findElement(By.className("button"));

        formularioNombre.sendKeys("Nombre");
        formularioEmail.sendKeys("abc@hotmail.com");
        formularioTema.sendKeys("Tema");
        formularioMensaje.sendKeys("Mensaje");
        checkEnvioEmail.click();
        botonEnviarForm.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void CPR4(){

        driver.get("http://www.vilanovadearousa.com/index.php?searchword=HOL&ordering=newest&searchphrase=all&option=com_search");
  
       WebElement checkArticulos = driver.findElement(By.id("area_content"));

       checkArticulos.click();

       try {
           Thread.sleep(5000);
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }

       assertTrue(checkArticulos.isSelected());
    }

    
    @Test
    public void CPR5(){
        
        driver.get("http://www.vilanovadearousa.com/index.php?searchword=HOL&ordering=newest&searchphrase=all&option=com_search");

        WebElement cajaBuscador = driver.findElement(By.id("search_searchword"));

        cajaBuscador.sendKeys("Frase exacta");

       WebElement radioExacta = driver.findElement(By.id("searchphraseexact"));

        radioExacta.click();

        WebElement botonBuscar = driver.findElement(By.className("button"));

       botonBuscar.click();

       try {
           Thread.sleep(5000);
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
    }

    @AfterAll
    public static void end(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        driver.quit();
    }
    
}