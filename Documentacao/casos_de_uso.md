# Indoor INF

### Casos de uso e cenários
Esta seção apresenta as histórias de usuários preliminares. Tais histórias contemplam todas as funcionalidades esperadas e retratam os resultados obtidos até o momento. Novas histórias serão desenvolvidas e as histórias apresentadas a seguir serão evoluídas conforme as necessidades do projeto.

```
Funcionalidade: FG01 - Fazer login no Indoor INF como usuário.

- Como usuário
- Eu quero fazer login no Indoor INF
- Para chegar em algum lugar.

Cenário: FG01-C01 - Logar-se com sucesso

Dado que o usuário está com o aplicativo Indoor INF aberto, e na tela de login,
Quando o usuário aciona a opção de login,
Então o Indoor INF apresenta a tela com as funcionalidades disponíveis para o usuário.

```
```
Funcionalidade: FG01b - Fazer login no STCS-W3 como paciente.
#Como paciente
#Eu quero fazer login no STCS-W3
#Para realizar obter informações sobre minha saúde.
Cenário: FG01b-C01 - Logar-se com sucesso
Dado que o paciente está com sua identidade digital descentralizada ativa
E na tela de login do STCS-W3,
Quando o paciente aciona a opção de login,
Então o STCS-W3 apresenta a tela com as funcionalidades disponíveis para o paciente.
```
```
Funcionalidade: FG02 - Obter relatório de acesso ao registro de saúde
#Como paciente
#Eu quero obter um relatório dos acessos realizados ao meu registro de saúde
#Para saber quando e quem acessou o meu registro de saúde.
Cenário: FG02-C01 - Obter relatório de acesso ao registro de saúde
Dado que o paciente está logado no sistema
E opcionalmente fornece uma data de início e uma data de fim válidas para o relatório,
Quando o paciente aciona a opção de emitir relatório,
Então o STCS-W3 apresenta um relatório com identificação de quem efetuou o acesso e
a data de acesso para todos os acessos ao registro de saúde realizados no intervalo
fornecido.
```

```
Funcionalidade: FE01 - Capturar o exame de pupilometria para diagnóstico de glaucoma.
#Como médico
#Eu quero capturar os movimentos pupilares
#Para obter um exame de glaucoma.
Cenário: FE01-C01 - Capturar com sucesso os movimentos pupilares.
Dado que o médico está logado no sistema
E vestindo óculos de realidade virtual e aumentada
E aciona capturar exame de pupilometria
E o paciente está vestindo o pupilômetro
E se comporta adequadamente para o registro dos movimentos pupilares
Quando a captura termina
Então o médico e o paciente obtêm a mensagem de que a captura foi realizada com sucesso.
Cenário: FE01-C02 - Capturar com intercorrências os movimentos pupilares.
Dado que o médico está logado no sistema
E vestindo óculos de realidade virtual e aumentada
E aciona capturar exame de pupilometria
E o paciente está vestindo o pupilômetro
E há alguma intercorrência, por exemplo, o paciente pisca em momento não esperado,
E o médico e o paciente obtêm a mensagem de que uma intercorrência ocorreu
E a captura é reiniciada do último ponto válido,
Quando a captura termina
Então o médico e o paciente obtêm a mensagem de que a captura foi realizada com sucesso.
```
```
Funcionalidade: FE02 - Diagnosticar glaucoma.
#Como médico
#Eu quero obter um diagnóstico de glaucoma e registrá-lo no registro de saúde do paciente
#Para atender um paciente.
Cenário: FE02-C01 - Obter diagnóstico de glaucoma.
Dado que o médico está logado no sistema
E possui o exame de pupilometria válido do paciente
Quando o médico seleciona a opção diagnosticar glaucoma,
Então o sistema fornece um diagnóstico de glaucoma.

Cenário: FE02-C02 - Registrar exame de movimentos pupilares e diagnóstico de glaucoma
no registro de saúde do paciente.
Dado que o médico está logado no sistema
E possui o exame de pupilometria válido do paciente
E possui diagnóstico de glaucoma,
Quando o médico seleciona a opção registrar exame e diagnóstico,
Então o exame e diagnóstico de glaucoma são registrados na blockchain
E o STCS-W3 apresenta para a mensagem de que o registro foi realizado com sucesso.
```

```
Funcionalidade: FE03 - Acessar exame de pupilometria e diagnóstico de glaucoma anteriormente realizado.

#Como médico
#Eu quero acessar e analisar exame de pupilometria realizado, que está na blockchain
#Para conhecer o histórico de saúde do paciente.
Cenário: FE03-C01 - Acessar o exame e diagnóstico sobre glaucoma na blockchain.
Dado que o médico está logado no sistema
E o paciente autorizou o médico acessar o exame e diagnóstico sobre glaucoma
Quando o médico seleciona a opção analisar exame
Então o exame de movimentos pupilares é apresentado para o médico analisar os resultados,
podendo pausar, acelerar e retroceder nas imagens.
```
```
Funcionalidade: FE04 - realizar consulta médica remota
#Como médico
#Eu quero realizar uma consulta médica remota do paciente
#Para realizar uma transferência de cuidado
Cenário: FE04-C01 - Consultar registro eletrônico de saúde (RES) do paciente
Dado que o médico está logado no sistema
E vestindo óculos de realidade virtual e aumentada
E o paciente possui RES na plataforma de blockchain
E autorizou o médico a acessar o RES
Quando o médico fornece a identificação do paciente
Então o médico obtém o prontuário do paciente em uma interface imersiva
Cenário: FE04-C02 - Obter um gêmeo digital do paciente em transferência de cuidado
Dado que o médico está logado no sistema
E vestindo óculos de realidade virtual e aumentada
E o paciente em transferência está conectado aos sensores de sinais vitais
Quando algum sinal vital monitorado pelos sensores atingir um nível crítico
Então o sistema deve disparar um alarme visual e sonoro no ambiente de realidade virtual,
E fornecer um rol de diagnósticos com base em aplicação de técnicas de inteligência
artificial.
```
```
Funcionalidade: FE05 - obter versão didática do P-avatar
#Como paciente
#Eu quero um relatório da minha saúde com base nos sensores que estou vestindo
#Para saber minha condição médica
Cenário: FE05-C01 - Acessar versão didática e simplificada do P-Avatar
Dado que o paciente está logado no sistema
E vestindo sensores de sinais vitais
Quando o paciente solicita o relatório da sua condição de saúde
Então o paciente obtém o relatório produzido com base em aplicação de técnicas de
inteligência artificial.
```
