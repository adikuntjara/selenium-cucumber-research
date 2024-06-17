package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class Login {

    WebDriver driver;
    WebDriverWait wait;

    // Mendefinisikan locator untuk tombol "Sign in" di halaman utama Google
    By signInButtonLocator = By.xpath("//a[contains(text(),'Sign in') or @title='Sign in']");
    // Mendefinisikan locator untuk formulir login Google (input email)
    By emailTextField = By.xpath("//input[@type='email' or @name='identifier']");

    @Given("the user is on the Google homepage")
    public void the_user_is_on_the_google_homepage() {
        // Mengatur WebDriverManager untuk menangani setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        // Membuat instance dari ChromeDriver
        driver = new ChromeDriver();
        // Membuat instance dari WebDriverWait dengan waktu tunggu (misalnya, 10 detik)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Membuka halaman Google
        driver.get("https://www.google.com");
        // Print judul halaman
        System.out.println("Title of the page is: " + driver.getTitle());
    }

    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String buttonText) {
        // Menunggu hingga tombol "Sign in" dapat diklik
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(signInButtonLocator));
        // Mengklik tombol "Sign in"
        signInButton.click();
    }

    @Then("the user should be redirected to the Google login form")
    public void the_user_should_be_redirected_to_the_google_login_form() {
        // Menunggu hingga formulir login terlihat
        WebElement loginForm = wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextField));
        // Memvalidasi bahwa formulir login ditampilkan
        if (loginForm.isDisplayed()) {
            System.out.println("Login form is displayed successfully!");
        } else {
            System.out.println("Login form is not displayed.");
        }
        // Menutup browser
        driver.quit();
    }
}