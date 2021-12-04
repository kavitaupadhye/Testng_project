package assignments;
import org.openqa.selenium.By;
//   Open "http://www.testyou.in/Login.aspx" in Chrome using Java…..WebDriver script.
//a. Enter username "Selenium99" and password "Selenium99"
//b. Click on login button
//c. Click on logout button
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLogout
{

	public static void main(String[] args) throws Exception                                           // Throws exception for thread
	{
		String projectPath=System.getProperty("user.dir");                                             // To get project path  
		System.out.println(projectPath);                                                               // Print project path
		System.setProperty("webdriver.chrome.driver",projectPath+"\\BrowserDriver\\chromedriver.exe"); // To set the path of the driver for the chrome browser 
		WebDriver w =new ChromeDriver();                                                               // Create interface object(Webdriver is interface)
		w.get("https://www.testyou.in/Login.aspx");                                                    // Enter url
		w.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).sendKeys("Selenium99");                // Enter username by using id element
		w.findElement(By.id("ctl00_CPHContainer_txtPassword")).sendKeys("Selenium99");                 // Enetr password by using id element
		w.findElement(By.name("ctl00$CPHContainer$btnLoginn")).click();                                // Click on login button using name element
		Thread.sleep(2000);                                                                            // Given sleep time(2000)
		w.findElement(By.id("ctl00_headerTopStudent_lnkbtnSignout")).click();                          // Click on logout button using id element
		w.quit();                                                                                      // Quit the window

	}

}
