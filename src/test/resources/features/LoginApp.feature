# language: pt


Funcionalidade: Logar no App Conecta Afya
  Como um novo Colaborador 
  Eu quero logar na Plataforma do Aplicativo Conecta Afya.

  Contexto: 
    Dado que eu esteja na tela de Home
    Quando quando clico na opção "Já tenho uma conta"
  
  @Logar
  Cenario: Logar no APP com sucesso
    E preeencho o campo com um CPF valido "28612091004"
    E aciono comando para avancar cpf
    Então o APP irá direcionar para tela de senha
    Quando preencho o campo senha com o valor "@TesteAutomacaoAfya22"
    E aciono o comando avancar senha
    Então o APP irá direcionar para a tela logada
    
  
  Cenario: Logar com CPF inválido
    E preeencho o campo com um CPF inválido "28612091003"
    E aciono comando para avancar
    Então o APP apresenta mensagem "Digite um CPF válido."
    
  
  Cenario: Logar com senha inválida
    E preeencho o campo com um CPF válido "28612091004"
    E aciono comando para avancar
    E preeencho o campo senha com o valor inválido "@TesteAutomacaoAfya23"
    E aciono o comando avancar senha
    Então o APP apresenta mensagem "Verifique seus dados e tente novamente."
    
    
    
     
