# language: pt

Funcionalidade: Cadastrar novo colaborador

  Contexto: Cadastrar Novo Colaborador
    Dado que eu esteja na tela Home do aplicativo
    E aciono a opcao "Digite o código de acesso"
    E preeencho o campo codigo
    E aciono comando avancar
    Entao o app apresenta a tela de "Bem vindo!"

  
  	
  	
  #	@criacao
  #	Cenario: Limpar assinatura
  #
        #E altero o campo celular para "(31)99999-9999"
  #	    E aciono os comandos para aceitar o termo e confirmar
  #	   	Quando faco a assinatura e aciono o comando Limpar
  #		  Entao a assinatura é desfeita e a tela fica disponivel para uma nova assinatura
  #
  #@criacao
  #	Cenario: Pular preenchimento do nome social
  #
  #	  		E altero o campo celular para "(31)99999-9999"
  #		    E aciono os comandos para aceitar o termo e confirmar
  #		    E faco a assinatura e aciono avancar
  #		    E preencho o campo senha "@TesteAutomacaoAfya22" e aciono avancar
  #		    Entao o app apresenta a tela de Parabens com a opcao para continuar
  #		    E aciono o comando para pular a etapa do preenchimento do nome social aciono avancar
  #	  	  E preencho o apelido "Automacao Apelido Afya" e aciono avancar
  #	  		E seleciono a opcao de certificado Reservista como "Não" e aciono avancar
  #	  		E seleciono a opcao de genero como "Mulher" e aciono avancar
  #	  		E seleciono a opcao de cor ou Raca como "Branca" e aciono avancar
  #	  		Quando seleciono a opcao de tipo deficiencia como "Visual" e aciono avancar
  #	  		Entao o app efetua o registro sem o nome social com sucesso
  #	  
  #	  @criacao
  #	   Cenario: Pular preenchimento do Apelido
  #
  #		    E altero o campo celular para "(31)99999-9999"
  #		    E aciono os comandos para aceitar o termo e confirmar
  #		    E faco a assinatura e aciono avancar
  #		    E preencho o campo senha "@TesteAutomacaoAfya22" e aciono avancar
  #		    Entao o app apresenta a tela de Parabens com a opcao para continuar
  #		    E preencho o nome social "Automacao Social Afya" e aciono avancar
  #		    E aciono o comando para pular a etapa do preenchimento do apelido aciono avancar
  #	  	  E seleciono a opcao de certificado Reservista como "Não" e aciono avancar
  #	  		E seleciono a opcao de genero como "Mulher" e aciono avancar
  #	  		E seleciono a opcao de cor ou Raca como "Branca" e aciono avancar
  #	  		Quando seleciono a opcao de tipo deficiencia como "Visual" e aciono avancar
  #	  		Entao o app efetua o registro sem o apelido com sucesso
 #
  #@criacao
  #Cenario: Verificar etapa e dados nome social/apelido
  #
         #E altero o campo celular para "(31)99999-9999"
  #		   E aciono os comandos para aceitar o termo e confirmar
  #		   E faco a assinatura e aciono avancar
  #		   E preencho o campo senha "@TesteAutomacaoAfya22" e aciono avancar
  #		   Entao o app apresenta a tela de Parabens com a opcao para continuar
  #		   E o app apresenta a tela de inicio da etapa para o nome social com a Etapa "Etapa 1 de 6"
  #	     E preencho o nome social "Automacao Social Afya" e aciono avancar
  #	     Entao o app apresenta a Etapa da tela apelido "Etapa 2 de 6" e opcao de voltar
  #	     Quando aciono o comando voltar para a tela do nome social
  #	     Entao o app apresenta o nome social mantido como "Automacao Social Afya"
  #
  #@criacao
  #Cenario: Verificar etapa e dados apelido/certificado Reservista
  #
        #E altero o campo celular para "(31)99999-9999"
  #		  E aciono os comandos para aceitar o termo e confirmar
  #	    E faco a assinatura e aciono avancar
  #	    E preencho o campo senha "@TesteAutomacaoAfya22" e aciono avancar
  #	    Entao o app apresenta a tela de Parabens com a opcao para continuar
  #	    E preencho o nome social "Automacao Social Afya" e aciono avancar
  #	    E preencho o apelido "Automacao Apelido Afya" e aciono avancar
  #	    Entao o app apresenta a Etapa da tela do certificado reservista "Etapa 3 de 6" e opcao de voltar
  #	    Quando aciono o comando voltar para a tela do apelido
  #	    Entao o app apresenta o nome do apelido mantido como "Automacao Apelido Afya"
  #
  #@criacao
  #Cenario: Verificar etapa e dados certificado Reservista/identidade de genero
  #
  #	    E altero o campo celular para "(31)99999-9999"
  #		  E aciono os comandos para aceitar o termo e confirmar
  #	    E faco a assinatura e aciono avancar
  #	    E preencho o campo senha "@TesteAutomacaoAfya22" e aciono avancar
  #	    Entao o app apresenta a tela de Parabens com a opcao para continuar
  #	    E preencho o nome social "Automacao Social Afya" e aciono avancar
  #	    E preencho o apelido "Automacao Apelido Afya" e aciono avancar
  #	    E seleciono a opcao de certificado Reservista como "Sim" e aciono avancar
  #	    Entao o app apresenta a Etapa da tela identidade de genero "Etapa 4 de 6" e opcao de voltar
  #	    Quando aciono o comando voltar para a tela do certificado
  #	    Entao o app apresenta a opcao na tela do certificado mantido como a opcao "Sim"
  #
  #@criacao
  #Cenario: Verificar etapa e dados identidade de genero/corRaca
  #
  #	    E altero o campo celular para "(31)99999-9999"
  #		  E aciono os comandos para aceitar o termo e confirmar
  #	    E faco a assinatura e aciono avancar
  #	    E preencho o campo senha "@TesteAutomacaoAfya22" e aciono avancar
  #	    Entao o app apresenta a tela de Parabens com a opcao para continuar
  #	    E preencho o nome social "Automacao Social Afya" e aciono avancar
  #	    E preencho o apelido "Automacao Apelido Afya" e aciono avancar
  #	    E seleciono a opcao de certificado Reservista como "Sim" e aciono avancar
  #	    E seleciono a opcao de genero como "Não-binário" e aciono avancar
  #	    Entao o app apresenta a Etapa da tela cor e raca "Etapa 5 de 6" e opcao de voltar
  #	    E aciono o comando voltar para a tela do genero
  #	    Entao apresenta a opcao do genero mantido como "Não-binário"
  #
  #@criacao
  #Cenario: Verificar etapa e dados corRaca/tipo deficiencia
  #
  #	    E altero o campo celular para "(31)99999-9999"
  #		  E aciono os comandos para aceitar o termo e confirmar
  #	    E faco a assinatura e aciono avancar
  #	    E preencho o campo senha "@TesteAutomacaoAfya22" e aciono avancar
  #	    Entao o app apresenta a tela de Parabens com a opcao para continuar
  #	    E preencho o nome social "Automacao Social Afya" e aciono avancar
  #	    E preencho o apelido "Automacao Apelido Afya" e aciono avancar
  #	    E seleciono a opcao de certificado Reservista como "Sim" e aciono avancar
  #	    E seleciono a opcao de genero como "Não-binário" e aciono avancar
  #	    E seleciono a opcao de cor ou Raca como "Branca" e aciono avancar
  #	    Entao o app apresenta a Etapa da tela tipo de deficiencia "Etapa 6 de 6" e opcao de voltar
  #	    E aciono o comando voltar para a tela do cor-Raca
  #	    Entao o app apresenta a opcao na tela do Cor-Raca mantido como a opcao "Branca"
  #
  #@criacao
  #Esquema do Cenario: Validar mensagem com e-mail invalido
    #
    #E altero o campo email com um valor inválido o app apresenta mensagem "Digite um e-mail válido" e o comando de confirmar permanece desabilitado
      #
      #| email_1 | automacao@.gmail.com |
      #| email_2 | automacao@gmail.co m |
      #| email_3 | automacao@.gmail.com |
      #| email_4 | automacao@@gmail.com |
      #| email_5 | automacaogmail.com   |
      #| email_6 | automacao@$gmail.com |
  #
  #@criacao
  #Cenario: Validar nivel da senha
    #E altero o campo celular para "(31)99999-9999"
    #E aciono os comandos para aceitar o termo e confirmar
    #E faco a assinatura e aciono avancar
    #E preencho o campo senha para validar de nivel fraca apresentando a mensagem "Senha fraca" e nao habilita o botao avancar
      #| validacao1 | asderyu  |
      #| validacao2 | asdABCeA |
      #| validacao3 | asd123ea |
      #| validacao4 | ABCDFGHY |
      #| validacao5 | 12345678 |
      #| validacao6 | asderyu  |
    #//    Quando preencho o campo senha para validar o nivel media
    #//      | senhaMedia                   | 1a2Ab3Bz   |
    #//    Entao o app apresenta a mensagem de senha media "Senha media" e habilita o comando para avancar
    #Quando preencho o campo senha para validar de nivel forte
      #| senhaForte | aA@1bBe3 |
    #Entao o app apresenta a mensagem de senha forte "Senha forte" e habilita o comando para avancar
    #
    
    @criacao
  	 Cenario: Cadastrar novo Colaborador com sucesso
  
  	     E apresenta a tela com os dados ja preenchidos
  	      | nomeCompleto | Nome Teste           |
  	      | email        | ""                   |
  	      | celular      | (00) 00000-0000      |
  	      | cargo        | ANALISTA DE DADOS PL |
  	      | unidade      | AFYA                 |
  	     Entao altero os campo nomeCompleto para "Hudson Banco de dados"
  		   E altero o campo email para "conecta.afya@gmail.com"
  		   E altero o campo celular para "(31)99999-9999"
  		   Quando aciono os comandos para aceitar o termo e confirmar
  		   Então o app apresenta a tela para assinatura
         Quando faco a assinatura e aciono avancar
  		   E preencho o campo senha "@TesteAutomacaoAfya22" e aciono avancar
  		   Entao o app apresenta a tela de Parabens com a opcao para continuar
  		   E preencho o nome social "Automacao Social Afya teste" e aciono avancar
  		   E preencho o apelido "Automacao Apelido Afya" e aciono avancar
  		   E seleciono a opcao de certificado Reservista como "Sim" e aciono avancar
  		   E seleciono a opcao de genero como "Não-binário" e aciono avancar
  		   E seleciono a opcao de cor ou Raca como "Branca" e aciono avancar
  		   Quando seleciono a opcao de tipo deficiencia como "Prefiro não informar" e aciono avancar
  		   Entao o app apresenta a tela com a mensagem "Seu cadastro foi realizado com sucesso!".
