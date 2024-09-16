# new feature
# Tags: optional
# language: pt
# Author: Daniel-Oliveira

@all
Funcionalidade: Executar diferentes testes automatizados

  @web @CT-02
  Cenario: Validar se a creatina está disponivel no site da growth
    Dado que estou logado no "Growth"
    E insiro no campo "Encontre Suplementos" o valor "Creatina (250g) (Creapure®) - Growth Supplements"
    Quando seleciono o produto "Creatina (250g)"
    Entao visualizo que a creatina esta "Indisponivel"
