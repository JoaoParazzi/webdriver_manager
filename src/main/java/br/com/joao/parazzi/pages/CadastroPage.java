package br.com.joao.parazzi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CadastroPage {

    private WebDriver driver;

    public CadastroPage(WebDriver driver) {
        this.driver = driver;
    }

    public void realizarCadastro(String nome, String email, String senha) {

        assertThat(driver.findElement(By.linkText("Cadastre-se")).getText(), is("Cadastre-se"));
        driver.findElement(By.linkText("Cadastre-se")).click();

        driver.findElement(By.id("nome")).sendKeys(nome);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(senha);
        driver.findElement(By.id("administrador")).click();
    }
}