package test;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test0 {

	public static void main(String[] args) throws Throwable{
 
		
		String filename;
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		String text = driver.findElement(By.id("nav-logo-sprites")).getText();
		System.out.println(text);
		File file=new File("\"C:\\Users\\asus\\Desktop\\filename.xlsx\"");
		FileInputStream fis=new FileInputStream(file);
		
		
		
		
		
		
		
		
	}

}