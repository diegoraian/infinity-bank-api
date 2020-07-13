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



