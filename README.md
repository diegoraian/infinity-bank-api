# Inifinity Bank API

**Objetivo**: Projeto de uma frente de caixa eletrônico em Spring Boot e Angular 5. Com serviços de consulta de saldo, depósito e retirada.

## Planejamento
O planejamento de projeto foi feito considerando que um sistema de caixa eletônico além dos serviços deve atender os requisitos mínimos de login. Sendo assim investiu-se bastante tempo para atender o sistema de login, configurando o spring security para trabalhar com autenticação via jwt, além da construção dos serviços em si.

Não houve tempo hábil para investir em uma solução de auditoria dos acessos e das transações. Mas chegou a ser iniciado mapeando as classes e criando um interceptor.

## Decisão Arquitetural

O método de autenticação de implementação dos serviços que foi implementado é o JWT. Essa decisão foi tomada considerando o nível de segurança que o negócio precisa além de um serviço de autenticação Servless visando diminuir o consumo de recursos no servidor e a aplicação possa atender mais usuários com menos recursos.


## Serviços

**Endpoint** : localhost:8080
  ###  Autenticação -  /auth

Payload
 ```
    {
    "agency": "",
    "account": "",
    "password": ""
    }
```

Response
 ```
    {
    "tipo": "Bearer",
    "token": "<Token>",
    }
```

###  Saque -  /account/withdraw
Método: **Patch**

Payload
 ```
{
	"bankData" : 
	{
		"agency": "",
		"account": "",
	},
	"value": 0.00

}
```

###  Depósito - /account/deposit
Método: **Patch**

Payload
 ```
{
	"bankData" : 
	{
		"agency": "",
		"account": "",
	},
	"value": 0.00
}
```



