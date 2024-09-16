# new feature
# Tags: optional
# language: pt
# Author: Daniel-Oliveira

@all
Funcionalidade: Executar diferentes testes automatizados

  @web @CT-03
  Cenario: Validar preenchimento de alimentos na minha dieta no dia segunda-feira
    Dado que estou logado no "Myfitnesspal"
    E clico no botao "Entrar"
    E realizo o login no site
    Quando clico no botão "Alimentos"
    E adiciono o alimento "Prè Treino"
    E adiciono o alimento "Pòs Treino"
    E adiciono o alimento "Almoço"
    E adiciono o alimento "Lanche Da Tarde"
    E adiciono o alimento "Jantar"
    Entao adiciono o alimento "Ceia"


    