package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageFormulario {
	private WebDriver driver;
	private By nameField;
	private By mailField;
	private By asuntoField;
	private By botonEnviar;
	
	public PageFormulario(WebDriver driver) {
		this.driver = driver;
		nameField = By.name("your-name");
		mailField = By.name("your-email");
		asuntoField = By.name("your-subject");
		botonEnviar = By.xpath("//*[@id=\"wpcf7-f1297-p370-o1\"]/form/p[7]/input");
	}
	
	public void rellenarNombre(String nombre) {
		driver.findElement(nameField).sendKeys(nombre);
	}
	public void rellenarMail(String mail) {
		driver.findElement(mailField).sendKeys(mail);
	}
	public void rellenarAsunto(String asunto) {
		driver.findElement(asuntoField).sendKeys(asunto);
	}
	public void clicEnviar() {
		driver.findElement(botonEnviar).click();
	}
}