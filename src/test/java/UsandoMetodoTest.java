// PACOTES

// BIBLIOTECAS
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import br.com.joao.parazzi.pages.CadastroPage;

// CLASSE
public class UsandoMetodoTest {

    // ATRIBUTOS
    private WebDriver driver;

    // ANTES DE TODOS OS TESTES
    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    // ANTES DE CADA TESTE
    @BeforeEach
    public void inicioTesteUnico() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://front.serverest.dev/login");
    }

    // DEPOIS DE CADA TESTE
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    private String gerarEmail() {
        return "joao52" + System.currentTimeMillis() + "@uol.com.br";
    }
    // TESTE
    @Test
    public void testCadastro() {

        CadastroPage cadastroPage = new CadastroPage(driver);

        cadastroPage.realizarCadastro(
                "JOAO PEDRO PARAZZI",
                gerarEmail(),
                "12346"
        );

        assertThat(
                driver.findElement(By.cssSelector(".btn-primary")).getText(),
                is("Cadastrar")
        );

        driver.findElement(By.cssSelector(".btn-primary")).click();

        assertThat(
                driver.findElement(By.cssSelector(".lead")).getText(),
                is("Este é seu sistema para administrar seu ecommerce.")
        );
    }
}