import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import br.com.joao.parazzi.pages.LoginPage;

public class LoginUsandoMetodoTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void iniciar() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://front.serverest.dev/login");
    }

    @AfterEach
    void finalizar() {
            driver.quit();
    }

    @Test
    void testLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.realizarLogin(
                "joaopparazzi@uol.com.br",
                "12346"
        );

        wait.until(ExpectedConditions.textToBe(
                By.cssSelector("h1"),
                "Bem Vindo Ulisses89225"
        ));

        assertThat(
                driver.findElement(By.cssSelector("h1")).getText(),
                is("Bem Vindo Ulisses89225")
        );
    }
}