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































    
    @Test
    public void test(){

        //para poner el programa a dormir 
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Conseguir el título de la página
        System.out.println(driver.getTitle());


        //Para buscar un elemento por localizador
        WebElement textImput =  driver.findElement(By.id("my-text-id"));

        //introducir por teclado
        textImput.sendKeys("Beatriz");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        //para hacer prueba con el boton submit

        WebElement botonSubmit = driver.findElement(By.className("btn"));

        botonSubmit.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        //para imprimir un texto del submit contestacion
        WebElement texto = driver.findElement(By.id("message"));
        System.out.println(texto.getText());

        //comprobación de que el texto que se espera esnull
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void elementForms() throws InterruptedException{


        //para comprobar si los checkbox están checked

        WebElement checkbox = driver.findElement(By.id("my-check-2"));

        checkbox.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        assertTrue(checkbox.isSelected());

    
        //Comprobar que no deje escribir en el disable input

        WebElement compDisable = driver.findElement(By.name("my-disabled"));

        compDisable.sendKeys("Escribir texto");

        assertEquals("",compDisable.getText());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void excepcionDisable() throws InterruptedException{

        //para comprobar si los checkbox están checked

        WebElement checkbox = driver.findElement(By.id("my-check-2"));

        checkbox.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        assertTrue(checkbox.isSelected());

    
        //Comprobar que no deje escribir en el disable input

        WebElement compDisable = driver.findElement(By.name("my-disabled"));

        compDisable.sendKeys("Escribir texto");

        assertEquals("",compDisable.getText());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void elementUpliadForms() throws Exception{

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        String nombreImagen = "foto.jpeg";

        //crea un objeto fichero para poder trabajar con los métodos, porque las rutas absolutas solo valen para este pc, en otro dará error
        File uploadFile = new File("src/test/files/" + nombreImagen);

        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));

        //le mandamos la ruta al file input la ruta con el objeto creado uploadFile con el metodo que coge la ruta absoluta
        fileInput.sendKeys(uploadFile.getAbsolutePath());

        Thread.sleep(2000);

        //utilizo el driver ya creado para probar ahora para hacer click en el botón
        WebElement buttoElement = driver.findElement(By.id("file-submit"));

        buttoElement.click();

        //Uso el driver para probar ahora el texto que nos de aceptacion

        WebElement textoFoto = driver.findElement(By.id("uploaded-files"));

        //Cojo el texto de ambas figuras y uso el gettext 
        assertEquals(nombreImagen, textoFoto.getText());


    }


    //prueba del seleccionable
    @Test
    public void elementSelectForms() throws Exception{

        WebElement select = driver.findElement(By.name("my-select"));

        //selenium ya da de base la clase select para poder probarlos, una vez lo tengo capturado con el driver.
        Select comboSelect = new Select(select);

        comboSelect.selectByIndex(2);


    }


    //prueba selección calendario
    @Test
    public void elementDateForms() throws Exception{

        WebElement calendar = driver.findElement(By.name("my-date"));

        //mando string con barras, mes, dia, año, 
        calendar.sendKeys("01/30/2024");

        Thread.sleep(2000);

        //Le introduzco la tecla tabular con la clase Keys, que ya está almacenando las claves ascii de las teclas para que desaparezca el calendario.
        calendar.sendKeys(Keys.TAB);

    }

    //prueba de radios
    @Test
    public void elementRadioForms() throws Exception{

    //por hacer

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