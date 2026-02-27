package br.com.joao.parazzi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators centralizados
    private By campoEmail = By.id("email");
    private By campoSenha = By.id("password");
    private By botaoEntrar = By.xpath("//button[text()='Entrar']");
    private By tituloHome = By.cssSelector("h1");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(campoEmail));
    }

    public void realizarLogin(String email, String senha) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(campoEmail))
                .sendKeys(email);

        driver.findElement(campoSenha)
                .sendKeys(senha);

        driver.findElement(botaoEntrar)
                .click();
    }


}