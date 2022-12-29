package frameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sample {
	WebDriver driver;
	WebElement em;
	WebElement pas;
	WebElement btn;
	@BeforeClass
	void Launch() {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
	}
	
	@BeforeMethod 
	void url() throws InterruptedException {
		driver.get("https://www.facebook.com");
		Thread.sleep(2000);
		 em = driver.findElement(By.xpath("//input[@id='email']"));
		 pas = driver.findElement(By.xpath("//input[@id='pass']"));
		 btn = driver.findElement(By.xpath("//button[@type='submit']"));
	}
	
	@Test (priority = 2)
	void m1() {
		em.sendKeys("Vinayak");
		pas.sendKeys("123456789");
		btn.click();
		
	}
	
	@Test (priority = 1)
	void m2() throws InterruptedException {
		em.sendKeys("Raj");
		pas.sendKeys("456789");
		btn.click();
		
	}
	@Test (priority = 3,dependsOnMethods="m2")
	void m3() {
		em.sendKeys("Kirti");
		pas.sendKeys("56789");
		btn.click();
		
	}
	@Test (priority = 2)
	void m4() {
		em.sendKeys("Pooja");
		pas.sendKeys("123456789");
		btn.click();
		
	}
	
	@AfterClass
	void closed() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
