# language: pt

Funcionalidade: Enviar Documentos para Admimissao
  Como um novo Colaborador ja cadastrado na plataforma
  Eu quero enviar os meus documentos para Admissao

  Cenario: Enviar documentos com sucesso
    Dado que eu esteja na tela Home do app
    Quando aciono a opcao para logar ja com um conta "Já tenho uma conta"
    E o app apresenta o campo CPF, preeencho com cpf "28612091004" e aciono avancar
    E o app apresenta o campo senha, preencho com a senha "@TesteAutomacaoAfya22" e aciono avancar
    E aciono o comando para Enviar Documentos
    E o app apresenta tela com instrucao referente a qualidade das fotos para envio de documentos
    E aciono o comando Continuar
    E o app apresenta a tela para iniciar o envio do documento de identidade
    E aciono o comando Enviar para iniciar o envio do documento de identidade
    E preencho os campos de identidade com os seguintes dados e avancando apos o seu preenchimento
      | RG                 | MG12281029       |
      | Orgao Emissor      | SSP              |
      | data de emissao RG | 20/03/1993       |
      | UF de emissao      | MG               |
      | Nacionalidade      | Brasileira       |
      | Estado Natal       | Minas Gerais     |
      | Cidade Natal       | Belo Horizonte   |
      | Data Nascimento    | 01/01/1989       |
      | Nome Mae           | Maria das Graças |
    E aciono o comando para finalizar a secao de preeenchimento dos documentos de identidade
    E o app apresenta a tela de confirmacao do RG
    E aciono o comando para anexar a identidade Foto frente e verso
    E seleciono a primeira foto para anexar
    E seleciono a segunda foto para anexar
    E aciono o comando para enviar o arquivo
    Entao o app apresenta mensagem de envio dos documentos de identidade "Documento enviado com sucesso"
    E o app apresenta a tela para selecionar o Estado civil
    E aciono o comando selecionar para seguir com Estado Civil
    E informo qual estado civil "Solteiro(a)"
    E aciono o comando avancar
    E o app apresenta a tela para anexar certidao nascimento
    E aciono o comando para anexar a certidao de nascimento
    E seleciono o arquivo para anexar
    E aciono o comando para enviar o arquivo
    Entao o app apresenta mensagem da certidao de nascimento enviado com sucesso "Documento enviado com sucesso"
    E o app apresenta a tela para anexar o Certificado de reservista
    E aciono o comando anexar arquivo Certificado de Reservista
    E seleciono o arquivo Certificado de Reservista
    E aciono o comando Enviar Arquivo Certificado de Reservista
    Entao o app apresenta mensagem do certificado de reservista enviado "Documento enviado com sucesso"
    E o app apresenta a tela para enviar o Diploma ou comprovante de escolaridade
    E aciono o comando para enviar o Diploma
    E seleciono a opcao referente ao Grau de Instituicao "Ensino fundamental incompleto" e acionando avancar
    E aciono o comando anexar arquivo do diploma de escolaridade
    E seleciono o arquivo de escolaridade
    E aciono o comando Enviar Arquivo de escolaridade
    Entao o app apresenta mensagem do Diploma Comprovante enviado "Documento enviado com sucesso"
    Entao o app apresenta a tela para iniciar as informacoes do Titulo de eleitor
    E aciono o comando Enviar para o titulo de eleitor
    E preencho os campos referente ao título de eleitor e avancando apos o seu preenchimento
      | NumeroTituloEleitor | 111111111111 |
      | DataEmissaoTitulo   | 12/03/1993   |
      | UFTituloEleitor     | MG           |
      | ZonaVotacao         |           01 |
      | SecaoVotacao        |           02 |
    E aciono o comando para finalizar a secao do Titulo Eleitor
    E o app apresenta a tela do anexar o Titulo de Eleitor
    E aciono o comando anexar o arquivo
    E seleciono o arquivo
    E aciono o comando Enviar Arquivo
    Entao o app apresenta mensagem de envio do titulo "Documento enviado com sucesso"
    E o app apresenta a tela para anexar o Comprovante da ultima votacao
    E aciono o comando anexar o arquivo do comprovante
    E seleciono o arquivo do comprovante
    E aciono o comando Enviar Arquivo do comprovante
    Entao o app apresenta mensagem do Comprovante da ultima votacao "Documento enviado com sucesso"
    E apresenta a tela para iniciar o envio do documento carteira de trabalho
    E aciono o comando Enviar para iniciar o envio do documento carteira de trabalho
    E preencho os campos da carteira de trabalho com os seguintes dados e avancando apos o seu preenchimento
      | NumeroCarteiraTrabalho |    7777777 |
      | SerieCarteiraTrabalho  |         01 |
      | UFCarteiraTrabalho     | MG         |
      | DataEmissaoCTPS        | 25/12/2000 |
    E aciono o comando para finalizar a secao de preeenchimento dos documentos de carteira de Trabalho
    E o app apresenta a tela de confirmacao do Carteira de Trabalho
    E aciono o comando para anexar a carteira de trabalho
    E seleciono a primeira pagina para anexar
    E seleciono a segunda pagina para anexar
    E aciono o comando para enviar o arquivo da carteira de trabalho
    Entao o app apresenta mensagem do envio da carteira de trabalho "Documento enviado com sucesso"
    E o app apresenta a tela para informar o numero do PIS
    E aciono o comando Preencher Pis
    E informo o numero do PIS "11111111111"
    E aciono o comando para finalizar a secao de informe do PIS
    E o app apresenta a tela para iniciar as informações do eSocial
    E aciono o comando Enviar para iniciar o envio do documento eSocial
    E aciono o comando para anexar o documento eSocial
    E seleciono o arquivo eSocial para anexar e aciono o comando Enviar Arquivo
    Entao o app apresenta mensagem do eSocial enviado "Documento enviado com sucesso"
    E o app apresenta a tela para iniciar as informações do Endereco
    E aciono o comando Enviar para iniciar o preeenchimento do endereco
    E preencho os campos de endereco e avancando apos o seu preenchimento
      | CEP         | 31070350 |
      | Numero      |      355 |
      | Complemento | Casa     |
    E aciono o comando para finalizar a secao de preeenchimento do endereco
    Entao o app apresenta a tela do anexar o comprovante de residencia
    E aciono o comando para anexar o comprovante de residencia
    E seleciono o arquivo para anexar
    E aciono o comando para enviar o arquivo
    Entao o app apresenta mensagem de envio do comprovante de residencia "Documento enviado com sucesso"
    E o app apresenta a tela de Declaracao de dependentes
    E aciono a opcao referente a dependentes "NÃO TENHO DEPENDENTES"
    E o app apresenta a tela para anexar o documento foto 3x4
    E aciono o comando para anexar a foto
    E seleciono a foto para anexar
    E aciono o comando para enviar o arquivo foto
    Entao o app apresenta mensagem de sucesso para o arquivo foto "Documento enviado com sucesso"
    E o app apresenta a tela com os Documentos RG ou CNH anexado e preenchidos
      | Numero          |         12281029 |
      | Orgao           | SSP              |
      | UF              | MG               |
      | Data            | 20/03/1993       |
      | Nacionalidade   | Brasileira       |
      | Estado Natal    | Minas Gerais     |
      | Cidade Natal    | Belo Horizonte   |
      | Nome Mae        | Maria das Gracas |
      | Data Nascimento | 01/01/1989       |
    E o app apresenta a tela com o Estado Civil como "Solteiro"
    E o app apresenta a tela com a Certidao de Casamento ou nascimento anexado
    E o app apresenta a tela com o Certificado de reservista anexado
    E o app apresenta a tela com o Comprovante de escolaridade ou diploma anexado a informacao do grau de instituicao
      | grauInstituicao | Ensino fundamental incompleto |
    E o app apresenta a tela com o titulo de eleitor anexado com os dados
      | Numero          | 111111111111 |
      | Data de emissao | 12/03/1993   |
      | UF              | MG           |
      | Secao           |           02 |
      | Zona            |           01 |
    E o app apresenta a tela com o comprovante de votacao da ultima votacao anexado
    E o app apresenta a tela com a carteira de trabalho anexado com os dados
      | NumeroCarteiraTrabalho |    7777777 |
      | UFCarteiraTrabalho     | MG         |
      | SerieCarteiraTrabalho  |         01 |
      | DataEmissaoCTPS        | 25/12/2000 |
    E o app apresenta a tela com o numero do PIS "11111111111"
    E o app apresenta a tela com o eSocial anexado
    E o app apresenta a tela com o comprovante de residencia anexado com os dados
      | CEP      |31070350 |
      | Endereco | Avenida Argelia, 355 Casa - Boa Vista - BELO HORIZONTE |
    E o app apresenta a tela com a foto 3x4 anexada
    E aciono o comando Concluir Envio
    E o app apresenta a tela de Declaracao de envio
    E aceito o termo e aciono o comando Concluir Envio
    Entao o app apresenta tela de Documentos enviados com sucesso.
