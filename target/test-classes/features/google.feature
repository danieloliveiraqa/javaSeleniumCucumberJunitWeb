# new feature
# Tags: optional
# language: pt
# Author: Daniel-Oliveira

@todos
Funcionalidade: Executar diferentes testes automatizados


  @web @CT-03459
  Cenario: Validar pesquisa no google
    Dado que estou logado no "Google"
    Entao validar que consigo manipular varias chaves ao digitar no campo

  @web @CT-2730
  Cenario: Validar pesquisa no google
    Dado que estou logado no "Google"
    Entao validar que consigo manipular varias chaves ao digitar no campo

  @web @CT-273j
  Cenario: Validar pesquisa no google
    Dado que estou logado no "iframe"
    Entao valido que tento fazer mover mouse pra caixa de texto

  @web @CT-011
  Cenario: Validar pesquisa no google
    Dado que estou logado no "hyundai"
    Entao valido que a cor do botao get started é verde


  @web @CT-011
  Cenario: Validar pesquisa no google
    Dado que estou logado no "hyundai"
    Entao validar que banco vai extrair

  @web @CT-123
  Cenario: Validar pesquisa no google
    Dado que estou logado no "Google"
    Entao validar que elemento sumiu da tela

  @web @CT-1234
  Cenario: Validar pesquisa no google
    Dado que estou logado no "Checkbox"
    Quando clico no checkbox
    Entao validar que checkbox

  @web @CT-010
  Cenario: Validar pesquisa no google
    Dado que estou logado no "Mediafire"
    Quando clico no botao "Baixar"
    Entao visualizo que o download do arquivo foi feito com sucesso

  @web @CT-01
  Cenario: Validar pesquisa no google
    Dado que estou logado no "Google"
    Quando pesquiso por alguma palavra chamada "Fast2mine"
    E clico no botao OK
    Entao visualizo o resultado da minha pesquisa



  @web @CT-032131236
  Esquema do Cenario: validar ingredientes
    Dado que estou logado no "Google"
    Quando pesquiso por alguma palavra chamada "<Ingrediente>"
    E clico no botao OK
    #Entao visualizo o resultado da minha pesquisa


    Exemplos:
      | Ingrediente      |
      | farinha de trigo |
      | chocolate em pó  |
      | açúcar           |
      | ovos             |
      | leite            |
      | óleo vegetal     |
      | fermento em pó   |

  @web @CT-0097
  Cenário: Preencher todos os campos do formulário
    Dado que estou logado no "saucedemo"
    E preencho os seguintes campos:
      | Campo             | Valor      |
      | Nome              | j          |
      | Sobrenome         | 1234567890 |
      | Email             | o          |
      | Telefone          | a          |
      | Endereco pessoal  | o          |
      | Endereco Trabalho | 1          |
      | Estado            | 2          |
      | Cidade            | 3          |
    Quando clico no botão "Enviar"
    Então vejo a mensagem de confirmação "Registro salvo com sucesso"



