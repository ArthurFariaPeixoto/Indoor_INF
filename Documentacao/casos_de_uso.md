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


Cenário: FG01-C02 - Logar-se sem sucesso

Dado que o usuário está com o aplicativo Indoor INF aberto, e na tela de login,
Quando o usuário aciona a opção de login,
Então o Indoor INF apresenta uma mensagem de erro de autenticação por credenciais inválidas.


Cenário: FG01-C03 - Logar-se sem sucesso

Dado que o usuário está com o aplicativo Indoor INF aberto, e na tela de login,
Quando o usuário aciona a opção de login,
Então o Indoor INF apresenta uma mensagem de erro de autenticação por falta de conexão com a internet.


Cenário: FG01-C04 - Logar-se sem sucesso

Dado que o usuário está com o aplicativo Indoor INF aberto, e na tela de login,
Quando o usuário aciona a opção de login,
Então o Indoor INF para de funcionar inesperadamente.
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
Funcionalidade: FE01 - Visualizar o mapa interno do INF

Como usuário
  -Eu quero poder acessar o mapa interno do Instituto de Informática e ver qual sala é qual.

Cenário: FE01-C01 - Acessar o mapa do INF e encontrar a sala da coordenação do curso de Engenharia de Software.
```
```
Funcionalidade: FE02 - Visualizar o mapa interno do CAB

Como usuário
  -Eu quero poder acessar o mapa interno do Centro de Aulas B e ver qual sala é qual.

Cenário: FE02-C01 - Acessar o mapa do CAB e encontrar a sala 210.
```
