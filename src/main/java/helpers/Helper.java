package helpers;

import org.openqa.selenium.WebDriver;

public class Helper {	
	
	private WebDriver driver;
	public Helper(WebDriver driver) {
		this.driver = driver;
	}
	
	public void esperar(int segundos) {
		try {
			Thread.sleep(segundos*1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
