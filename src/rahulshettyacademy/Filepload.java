package rahulshettyacademy;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Filepload {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String downloadPath = System.getProperty("user.dir");

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id=\"pickfiles\"]//span")).click();
		Thread.sleep(3000);
		// Runtime.getRuntime().exec("C:\\Users\\Cedcoss\\Documents\\check\\FileUpload.exe");
		Runtime.getRuntime().exec("C:\\check\\FileUpload.exe");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTaskTextBtn")));
		driver.findElement(By.id("processTaskTextBtn")).click();
		System.out.println("try the edit code");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(5000);
		File f = new File(downloadPath + "/ilovepdf_pages-to-jpg.zip");
		if (f.exists()) {
			Assert.assertTrue(f.exists());
			if (f.delete()) {
				System.out.println("File Deleted");}}}}
