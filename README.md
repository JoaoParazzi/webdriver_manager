# 🧪 webdriver_manager

## 📌 Descrição

Este repositório contém um projeto de **automação de testes web** utilizando **Selenium WebDriver com Java**, **JUnit 5** e **WebDriverManager** para gerenciamento automático dos drivers de navegador.  
Este projeto faz parte do meu **portfólio profissional**, demonstrando habilidades em automação de testes, organização de código, boas práticas e integração com ferramentas modernas de build e execução. :contentReference[oaicite:0]{index=0}

---

## 🚀 Tecnologias Utilizadas

✔ Java 17  
✔ Maven  
✔ Selenium WebDriver  
✔ WebDriverManager :contentReference[oaicite:1]{index=1}  
✔ JUnit 5  
✔ IntelliJ IDEA  

---

## 🧱 Estrutura do Projeto

```text
webdriver_manager/
├── src/
│   ├── main/java/       → Páginas e lógica reutilizável
│   └── test/java/       → Casos de teste automatizados
├── pom.xml              → Configuração do Maven
└── README.md            → Documentação principal
```
📥 Pré-requisitos

Antes de executar os testes, certifique-se de ter instalado:

✔ JDK 17 ou superior
✔ Apache Maven
✔ Navegador Chrome instalado
✔ IntelliJ IDEA (recomendado)

## 📌 Como Executar os Testes

Siga os passos abaixo para rodar o projeto localmente:

### 1️⃣ Clone o repositório

```bash
git clone https://github.com/JoaoParazzi/webdriver_manager.git
```
2️⃣ Acesse a pasta do projeto
```bash
cd webdriver_manager
```
3️⃣ Execute os testes com Maven
```bash
mvn clean test
```
Se a configuração estiver correta, o Maven irá compilar o projeto e executar automaticamente os testes utilizando o JUnit 5.

📄 O que os Testes Fazem

Os testes implementados validam:

Fluxo de cadastro simples com dados válidos

Tentativa de cadastro com e-mail já existente

Verificação de textos e mensagens exibidas na aplicação

Esses testes demonstram o uso de seletores CSS, esperas explícitas (WebDriverWait) e validações assertivas.

## 📌 Principais Conceitos
🧠 WebDriverManager

O WebDriverManager é responsável por baixar automaticamente o driver correto do navegador (ChromeDriver, GeckoDriver etc.) sem necessidade de configuração manual de PATH.

## 📏 JUnit 5

O framework JUnit 5 foi utilizado para a organização dos testes, execução e validação com mensagens claras de falha.

## 💡 Boas Práticas

✴ Uso de gerador de e-mails dinâmicos para evitar duplicidade
✴ Separação de lógica de teste e lógica de páginas
✴ Uso de esperas explícitas para garantir estabilidade dos testes

## 🛠️ Ferramentas Recomendadas

📦 Maven — Build e gerenciamento de dependências
🧠 IntelliJ IDEA — IDE para desenvolvimento Java
🐱‍👤 GitHub — Controle de versão
Chrome — Navegador padrão para execução de WebDriver

## 📈 Próximos Passos

🎯 Adicionar integrações com pipelines CI/CD (GitHub Actions)
🎯 Geração de relatórios com plugins Maven e formato HTML/Allure
🎯 Coveralls / SonarCloud para análise de qualidade

✨ Autor

👤 Joao Parazzi
📍 Brasil
📫 Conecte-se comigo no GitHub!
