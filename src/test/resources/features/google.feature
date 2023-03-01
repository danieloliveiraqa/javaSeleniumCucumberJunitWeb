# new feature
# Tags: optional
# language: pt
# Author: Daniel-Oliveira

Funcionalidade: Executar testes automatizados no google

  @web @CT-01
  Cenario: Validar pesquisa no google
    Dado que estou logado no google
    Quando pesquiso por alguma palavra
    E clico no botao OK
    Entao visualizo o resultado da minha pesquisa
