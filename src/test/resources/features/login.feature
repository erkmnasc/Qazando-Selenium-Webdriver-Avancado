# language: pt

@login
Funcionalidade: Login
  Eu como usuário do sistema
  Quero fazer login
  Para fazer uma compra no site

  Contexto: Acessar tela de login
    Dado que estou na tela de login

  @login-sucesso
  Cenário: Login com sucesso
    Quando preencho login "teste.finotti@qazando.com" e senha "123456"
    E clico em Login
    Então vejo mensagem de login com sucesso

  @login-inválido
  Esquema do Cenario: Validar: <name>
    Quando preencho login "<user>" e senha "<password>"
    E clico em Login
    Então vejo mensagem "<message>" do campo não preenchido

    Exemplos:
      | user              | password   | message          | name                          |
      | testeqazando.com  | testeteste | E-mail inválido. | Login com E-mail inválido     |
      | teste@qazando.com | teste      | Senha inválida.  | Login com Senha inválida      |
      |                   |            | E-mail inválido. | Login sem E-mail e Senha      |
      | teste@qazando.com |            | Senha inválida.  | Login com E-mail e sem Senha  |
      |                   | testeteste | E-mail inválido. | Login sem E-mail e com  Senha |