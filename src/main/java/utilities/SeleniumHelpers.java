package utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class SeleniumHelpers {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public SeleniumHelpers(WebDriver driver) {
    }

    // Method untuk akses URL
    public void navigateToPage(String url) {
        // Mengatur WebDriverManager untuk menangani setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        // Membuat instance dari ChromeDriver
        driver = new ChromeDriver();
        // Membuat instance dari WebDriverWait dengan waktu tunggu (misalnya, 10 detik)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
        System.out.println("Title of the page is: " + driver.getTitle());
    }
}