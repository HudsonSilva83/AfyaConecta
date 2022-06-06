pipeline {
	agent any 

    stages{
      stage ('Build Backend'){
          
          steps {
    		 	bat 'echo é para apenas Buildar o backend com sucesso'
                //aqui limpa empacota e não executa teste: (bat 'mvn clean package -DskipTests=true') para apenas Buildar o backend om sucesso' 
	    	}

    	}

      stage ('Unit Tests'){
          
          steps {
    		 	bat 'echo testes unitários com sucesso'
                // aqui faz os testes unitários (bat 'mvn test') para apenas testes unitários com sucesso
	    	}

    	}

        stage ('Sonar Analysis'){

            //environment{
                 
                  //scannerHome = tool 'SONAR_SCANNER'

            //}
          
          steps {

                //withSonarQubeEnv('SONAR_LOCAL')
    		 	bat 'echo análise SONAR com sucesso'
                // aqui faz a análise do Sonar(bat "${scannerHome}/bin/sonar-scanner -e (aqui vai parâmentros para adicionar aqui)") 
                // Obs: O SONAR DEVE ESTAR NO AR (LIGADO)
	    	}

    	}

        stage ('Quality Gate'){

         
          
          steps {

             //sleep(5)
             //timeout(time: 1, unit: 'MINUTES')
              //waitForQualityGate abortPipeline: true



    		 	bat 'echo análise Quality Gate com sucesso'
                        //obs: se o Quality Gate falhar o pipeline será parado
	    	}

    	}


        stage ('Deploy Backend'){

         
          
          steps {

           //gerar um paramentro para adicionar aqui


    		 	bat 'echo deploy backend com sucesso'
                      
	    	}

    	}



        stage ('API Test'){

         
          
          steps {

              //dir('api-test'){

              //gerar um paramentro para adicionar aqui
              //bat 'mvn test'

              //}

              
    		 	bat 'echo testes da API com sucesso'
                 //Obs o tomcate deve estar no ar
                       
	    	}

    	}



        stage ('Deploy FrontEnd'){

         
          
          steps {

              //dir('frontend'){

                    //gerar um parametro para adicionar aqui
                    //baixar o codigo do repositório
                    //fazer o build
                    //fazer o deploy
            

              //}

              
    		 	bat 'echo deploy FrontEnd com sucesso'
                 //Obs o tomcate deve estar no ar
                       
	    	}

    	}


         stage ('Testes Funcionais'){

         
          
          steps {

              //dir('functional-test'){

              //gerar um paramentro para adicionar aqui nesta caso como é projeto local mesmo não precisou baixar os paramettros git


             // }

              bat 'mvn test'
    		  cucumber buildStatus: 'null', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', jsonReportDirectory: 'target', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
                       
	    	}

    	}   






	}


}