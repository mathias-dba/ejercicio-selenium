package com.ejercicioseleniummathias;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import helpers.Helper;
import pages.PageFormulario;

@SpringBootApplication
public class EjercicioSeleniumApplication {
	
	public static void main(String[] args) {
		/*Inicializar el ChromeDriver junto a un Helper y un PageFormulario donde vamos a llamar funciones que nos van a ser
		de utilidad como la función de esperar en el caso de Helper y de rellenar campos en PageFormulario*/
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		Helper helper = new Helper(driver);
		PageFormulario llenarForm = new PageFormulario(driver);
		
		//Generar By para obtener el xpath del botón de contacto para luego clicarlo
		By irAContacto = By.xpath("//*[@id=\"menu-item-1364\"]/a");
		
		//Maximizar la ventana e ingresar a la página de Consultoría Global
		driver.manage().window().maximize();
		driver.navigate().to("https://www.consultoriaglobal.com.ar/cgweb/");
		System.out.println("Ingresando a Consultoría Global");
		helper.esperar(3);
		
		//Ingresar a contacto
		driver.findElement(irAContacto).click();
		System.out.println("Ingresando a la sección de Contacto");
		helper.esperar(3);
		
		//Una vez en la sección de contacto, rellenar los campos y enviar...
		llenarForm.rellenarNombre("nombre del usuario");
		System.out.println("Ingresando campo de nombre");
		
		llenarForm.rellenarMail("mail del usuario");
		System.out.println("Ingresando campo de mail, que en este caso va a ser inválido");
		
		llenarForm.rellenarAsunto("asunto del usuario");
		System.out.println("Ingresando campo de asunto");
		
		llenarForm.clicEnviar();
		System.out.println("Pulsando el botón de enviar");
		
		//Espera a la alerta
		helper.esperar(3);
		
		//Generar WebElement e imprimir mensaje de alerta de mail inválido
		WebElement mailInvalido = driver.findElement(By.xpath("//*[@id=\"wpcf7-f1297-p370-o1\"]/form/p[2]/span/span"));
		System.out.println(mailInvalido.getText());
		helper.esperar(3);
		System.out.println("Cerrando la página");
		
		//Cerrar el ChromeDriver
		driver.close();
	}

}
