import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Teste de Login")
public class EstudoTest {

    private WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void inicioTesteUnico() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://front.serverest.dev/login");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Teste finalizado");
        driver.quit();
    }

    private String gerarEmail() {
        return "joao52" + System.currentTimeMillis() + "@uol.com.br";
    }

    @Test
    @Order(1)
    @DisplayName("Teste realizado no caminho feliz com sucesso")
    public void testCadastroSimplesComDadosValidos() {

        assertThat(driver.findElement(By.linkText("Cadastre-se")).getText(), is("Cadastre-se"));
        driver.findElement(By.linkText("Cadastre-se")).click();

        driver.findElement(By.id("nome")).sendKeys("joao52");

        driver.findElement(By.id("email")).sendKeys(gerarEmail());

        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("administrador")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.textToBe(
                By.cssSelector(".btn-primary"), "Cadastrar"));

        assertEquals(
                "Cadastrar",
                driver.findElement(By.cssSelector(".btn-primary")).getText(),
                "Texto esperado 'Cadastrar', mas foi exibido outro texto."
        );

        driver.findElement(By.cssSelector(".btn-primary")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("a.alert-link")));

        assertEquals(
                "Cadastro realizado com sucesso",
                driver.findElement(By.cssSelector("a.alert-link")).getText(),
                "Texto esperado 'Cadastro realizado com sucesso', mas foi exibido outro texto"
        );
    }
    @Test
    @Order(2)
    @DisplayName("Teste realizado no caminho feliz com sucesso")
    public void testCadastroSimplesComEmailExistente() {

        assertThat(driver.findElement(By.linkText("Cadastre-se")).getText(), is("Cadastre-se"));
        driver.findElement(By.linkText("Cadastre-se")).click();

        driver.findElement(By.id("nome")).sendKeys("joao52");
        driver.findElement(By.id("email")).sendKeys("joaopparazzi@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("administrador")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.textToBe(
                By.cssSelector(".btn-primary"), "Cadastrar"));

        assertEquals(
                "Cadastrar",
                driver.findElement(By.cssSelector(".btn-primary")).getText(),
                "Texto esperado 'Cadastrar', mas foi exibido outro texto."
        );

        driver.findElement(By.cssSelector(".btn-primary")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.alert.alert-secondary.alert-dismissible > span")));

        assertEquals(
                "Este email já está sendo usado",
                driver.findElement(By.cssSelector("div.alert.alert-secondary.alert-dismissible > span")).getText(),
                "Texto esperado 'Este email já está sendo usado', mas foi exibido outro texto"
        );
    }
}