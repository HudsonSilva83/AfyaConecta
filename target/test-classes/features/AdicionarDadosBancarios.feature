# language: pt

Funcionalidade: Informar os Dados Bancarios

  Contexto: Informar Dados Bancarios
       
       Dado que eu esteja logado e que ja tenha enviado os documentos para admissao
       
         |CPF   |28612091004            |
         |Senha |@TesteAutomacaoAfya22  |
          
       Entao o app apresenta a tela para iniciar as informacoes dos dados Bancarios 
          
      
       
    #Cenario: Enviar Conta Bancaria depois
     #ps. iniciar o cadastro e envio de documentos tudo novamente
#		    Quando aciono o comando Enviar Depois
#		    Entao o app apresenta a tela home com status como "Etapa pendente" e a opcao de enviar os dados bancarios
#		  
     #
    #Cenario: Adicionar Conta Bancaria depois
    #ps. iniciar o cadastro e envio de documentos tudo novamente 
#		    E aciono o comando para comecar
#		    Quando aciono o comando Adicionar uma conta Depois
#		    Entao o app retorna para a tela home com status como "Etapa pendente" e a opcao de enviar os dados bancarios
		        
      
    @ContaBancaria 
    Cenario: Adicionar uma conta Bancaria
      
	      Quando aciono o comando para comecar
		    Entao o app apresenta a tela para colocar uma conta bancaria
		    E aciono o comando Adicionar Conta
	      Entao o app apresenta a tela para informar o banco 
		    E preencho o nome do banco "Itau" e aciono avancar
		    Entao o app apresenta a tela para informar a agencia
		    E preencho o nome da agencia "001" e aciono avancar
		    Entao o app apresenta a tela para informar a Conta
	      E preencho a Conta "0003001" e aciono finalizar
	      Entao o app apresenta a tela para anexar o comprovante de conta
	      E aciono o comando para anexar o comprovante de conta
	      E seleciono o arquivo e aciono o comando enviar o arquivo
	      Entao o app apresenta a tela de sucesso com os dados bancarios cadastrados
      
      
  
      