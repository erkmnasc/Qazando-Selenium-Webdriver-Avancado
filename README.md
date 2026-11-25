# Selenium WebDriver com Java (avançado)

[![E2E tests](https://github.com/erkmnasc/Qazando-Selenium-Webdriver-Avancado/actions/workflows/ci.yml/badge.svg)](https://github.com/erkmnasc/Qazando-Selenium-Webdriver-Avancado/actions/workflows/ci.yml)

Projeto do módulo avançado de Selenium com Java do curso Trilha QA da
Qazando. BDD com Cucumber (Gherkin em português), Page Objects, comandos
reutilizáveis com espera explícita e screenshot anexado ao relatório quando um
cenário falha. Os testes rodam no site de prática
[automationpratice.com.br](https://automationpratice.com.br).

## Stack

Java 17 · Selenium 4 · Cucumber 7 · JUnit 4 · Maven · GitHub Actions

## Cenários

- **Login** (`login.feature`): login com sucesso e um Esquema do Cenário com
  5 combinações de e-mail e senha inválidos ou vazios, conferindo a mensagem
  de cada campo.
- **Cadastro** (`cadastro_usuario.feature`): cadastro de usuário com sucesso,
  com nome, e-mail e senha gerados a cada execução.

## Estrutura

```
src/test/java/
  pages/    page objects (LoginPage, CadastroUsuarioPage)
  steps/    definições dos passos e hook de screenshot
  runner/   runner do JUnit e criação do driver
  support/  comandos com espera explícita, screenshot e massa de teste
```

## Como rodar

Precisa de Java 17, Maven e do navegador escolhido. O driver é baixado pelo
Selenium Manager.

```bash
mvn test                        # Chrome
mvn test -Dbrowser=chrome-ci    # Chrome headless
mvn test -Dbrowser=firefox
mvn test -Dbrowser=edge
mvn test -Dcucumber.filter.tags="@login"   # só os cenários de login
```

O relatório HTML do Cucumber fica em `target/reports/cucumber.html`.

## CI

O GitHub Actions roda os testes em Chrome headless a cada push na `master`, em
pull requests, manualmente e toda segunda-feira, e guarda o relatório como
artefato (`.github/workflows/ci.yml`).
