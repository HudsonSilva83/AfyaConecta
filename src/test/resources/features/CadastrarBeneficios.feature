# language: pt

Funcionalidade: Cadastrar Beneficios
    
  Contexto: Cadastrar Beneficios
    
        Dado que eu esteja logado e que ja tenha enviado os documentos para admissao e adicionado os Dados Bancarios
       
         |CPF   |28612091004            |
         |Senha |@TesteAutomacaoAfya22  |
          
       Entao o app apresenta a tela para iniciar as informacoes dos dados do Beneficio
     
		    
       
    @Beneficios
    Cenario: Cadastrar Beneficios: Vale Transporte(somente Onibus - idem Ida e Volta, Plano odontologico(Essencial Plus), Saude 
      
        Quando aciono o comando para comecar
        Entao o app apresenta a tela com os beneficios disponiveis 
        Quando aciono o comando para comecar para iniciar 
		    Entao o app apresenta a tela para selecionar se deseja vale transporte
	      E seleciono a opcao "Sim" e aciono avancar
		    Entao o app apresenta as opcoes de transporte a ser utilizado
		    E seleciono a quantidade de onibus para a Ida ao trabalho "1" aciono avancar, preencho os dados do onibus a ser utilizado
		     
			     | nomeLinha      | BoavistaLtda  |
			     | valorTarifa    | 1,51          |
			     | nomeLinha2     | SavassiLtda   |
			     | valorTarifa2   | 2,22          |
			     | nomeLinha3     | SavassiLtda   |
			     | valorTarifa3   | 3,50          |
			
		     Entao o app apresenta a pergunta referente ao trajeto ida e volta
		     E seleciono a opcao "Sim" como o mesmo trajeto e aciono avancar
		     Entao o app apresenta a tela de confirmacao do pedido do vale transporte com os respectivos valores e aciono avancar
		     
		       | valorTrajetoIda      | 3,73   |
			     | valorTrajetoVolta    | 3,73   |
			     | valorTotalDiario     | 7,46   |
			     | descontoMensal       | 164,12 |
				     
		     Entao o app apresenta a tela de do termo de aceite
		     Quando aciono aceitar e aciono finalizar  
		     Entao o app apresenta a tela de vale transporte concluido e aciono comando avancar
		     Entao o app apresenta a tela de Plano Odontologico 
		     Quando escolho a opcao de ter plano odontologico
		     Entao o app apresenta as informacoes de planos disponiveis
		     E escolho um dos planos disponiveis no caso "Essencial Plus" e aciono continuar
		     Entao o app apresenta tela para incluir dependentes
		     E aciono comando para incluir dependentes
		     E incluo o dependente com suas informacoes e aciono avancar
		       | grauParentesto      | Filho(a)     |
			     | idade               | 0 a 6 anos   |
			     | nomeCompeto         | Anna Clara   |
			     | dataNascimento      | 20/04/2019   |
			     | CPF                 | 05469845680  |
			    
			   Entao o app apresenta a tela de certidao de nascimento
			   E aciono o comando anexar a certidao de nascimento
			   E seleciono o arquivo da certidao de nascimento  
			   E aciono comando de enviar o arquivo da certidao de nascimento
			  
			   Entao o app apresenta a tela de carteirinha de vacinacao
			   E aciono comando de anexar a carteirinha de vacinacao
			   E seleciono o arquivo da carteirinha de vacinacao
			   E aciono comando de enviar a carteirinha de vacinacao
			   
			   E seleciono o dependente e aciono avancar
			   Entao o app apresenta a tela com dados de confirmacao do plano ondotologico "Essencial Plus"
			   E aciono o comando avancar da tela de confirmacao
			   
			   Entao o app apresenta a tela termo de escolha do plano odontologico
			   E aciono o comando de aceitar o termo e finalizar
			   Entao o app apresenta a tela plano odontologico concluida com sucesso e aciono avancar
			   
			   E o app apresenta a tela para informar o ticket restaurante e alimenta????o
			   Quando aciono o comando para customizar o beneficio
			   Entao o app apresenta a tela de op????o para receber como alimenta????o ou restaurante
			   Quando aciono a op????o de beneficio ticket "Alimenta????o" e aciono avancar do beneficio
			   Entao o app apresenta a tela de confirma????o da escolha "Ticket Alimenta????o" e aciono finalizar
			   E o app apresenta a tela do termo de escolha do beneficio do Ticket
			   Quando aciono o comando de aceitar o termo e finalizar
			   Entao o app apresenta a tela de escolha salva do Ticket e aciono comando avancar
			   
			   E o app apresenta a tela de informacoes do Gympass
			    
			     | carrossel01      | Rede com mais de 24.000 academias pra voc?? frequentar!   |
			     | carrossel02      | Mais recursos como Personal, Nutricionista e Psicol??go   |
			     | carrossel03      | Planos gratuitos ou pagos a partir de R$39,90/m??s        |
			     | carrossel04      | Sem taxas de cancelamento                                |
			     | carrossel05      | Digital, fa??a tudo pelo app da Gympass                   |
			  
			  E o app apresenta os passos para o Gympass e aciono continuar
			  
			     | passo01   | Ser?? enviado um email do Gympass                    |
			     | passo02   | Acesse o site ou baixe o app do Gympass             |
			     | passo03   | Clique em cadastre-se gr??tis                        |
			     | passo04   | Em nome da empresa, procure por Afya como parceira  |
			     | passo05   | Informe seu CPF e conclua o cadastro de sua conta   |
			     | passo06   | Veja os planos dispon??veis                          |
			  			   
			   Entao o app apresenta a tela da escolha salva e informando que foi enviado email sobre o Gympass e aciono avancar
          
          | texto01 |Sua escolha foi salva!|
          | texto02 |Voc?? pode escolher assinar o Gympass a qualquer momento. Vai ser enviado um e-mail no decorrer do m??s com suas instru????es.|

			   E o app apresenta a tela de informacoes do Plano de Saude

          | titulo           |CNU - Centro Nacional Unimed|
          | texto01          |Pensando em trazer sempre as melhores op????es de benef??cios, a Afya oferece o plano de assist??ncia m??dica para cuidar de voc?? e da sua fam??lia.                       |
          | texto02          |Como funciona?|
          | texto03          |O benef??cio se refere ao plano de sa??de CNU (Central Nacional Unimed) e se estende a todos os funcion??rios e seus respectivos dependentes.                           |
          | texto04          |A acomoda????o do plano ?? apartamento e o formato ?? o de coparticipa????o para titulares e dependentes, com mensalidade apenas para os dependentes, no valor de R$321,67.|
          | texto05          |Coparticipa????o|
          | carrossel01      |A coparticipa????o acontece por procedimento realizado e o valor ?? descontado diretamente na folha de pagamento.|
          | carrossel02      |Para consultas eletivas e de urg??ncia, o desconto ?? de 30% do valor do procedimento.|
          | carrossel03      |Para exames simples e de alta complexidade, o valor m??ximo de cobran??a ?? de R$60,00 por procedimento.|
          | carrossel04      |N??o existe cobran??a de coparticipa????o para interna????o e terapias.|
                           
			   E aciono comando para adicionar dependentes
         E seleciono o dependente e aciono avancar da selecao do dependentes
         Entao o app apresenta a tela de confirmacao do pedido do plano de saude e depois aciona avancar
         
          | titulo              |Haver?? um desconto integral na folha de pagamento mensal.|
          | texto01             |Afya Novalima|
          | texto02             |R$??321,67 por dependente|
          | Cadastrado no Plano |Anna Clara|
          | Desconto mensal     |R$??321,67|
          
         Entao o app apresenta a tela do termo de aceite do plano de saude 
         Quando aciono aceitar o termo
         Entao o app apresenta a tela com o plano cadastro concluido
          
          
          
         
         
          
			   
			   
			
			 
			 
			 
			 
			 
			 
			 
			 
			   
			   
			   
			   


















		    