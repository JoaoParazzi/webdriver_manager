import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void inicioTesteUnico() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://front.serverest.dev/login");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLogin() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")))
                .sendKeys("joaopparazzi@outlook.com.br");

        driver.findElement(By.id("password"))
                .sendKeys("12346");

        driver.findElement(By.xpath("//button[text()='Entrar']"))
                .click();

        wait.until(ExpectedConditions.textToBe(
                By.cssSelector("h1"),
                "Bem Vindo JOAO PEDRO PARAZZI"
        ));

        assertThat(
                driver.findElement(By.cssSelector("h1")).getText(),
                is("Bem Vindo JOAO PEDRO PARAZZI")
        );
    }
}