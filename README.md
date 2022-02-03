# Core Service

## Components

**External Account**\
Holder of information about user accounts. Can be used as a validator of user existence.

**External Transaction**\
Is a component interested in the successful completion of the transaction, and expects to receive an amount of money and user, who participated in the payment.

**Authorization**\
Responsible for issuing authorization tokens for communication with Core Servic

## API

### Authorization

Broadcast Successful Transaction Completion\
Issue authorization tokens for communication with Core Service

**Request**

**URL**: https://{auth_host}/auth/token\
**Method**: POST\
**Headers:**
* Content-Type: application/x-www-form-urlencoded

**Parameters**
* grant_type=client_credentials
* client_secret=client_secret
* client_id=itransition_payment_provider

**Response**

Success 200:

```json
{
    "access_token": "token",
    "expires_in": 5400,    "refresh_expires_in": 0,
    "token_type": "Bearer",
    "not-before-policy": 0,
    "scope": "profile email"
}
```

Error 400:

```json
{
"error": "unauthorized_client",
"error_description": "Invalid client secret"
}
```

### External Account

Account Exists\
Indicates is an account with provided id exists

**Request**

**URL**: https://{account_host}/account/{account_id}\
**Method**: GET\
**Headers:**
* Authorization: Bearer {token}
* Content-Type: application/json

**Response**

Success:

```json
{
    "firstName": "John",
    "lastName": "Smith",
    "middleName": null
}
```

Error 400:

```json
{
    "timestamp": 1625569055907,
    "path": "/account/123456",
    "status": 400,
    "error": "Bad Request",
    "requestId": "22780a9e-1"
}
```

### External Transaction

Successful Transaction Completion Receiver\
Receives and process successful transaction completion

**Request**

**URL**: https://{transaction_host}/transaction\
**Method**: POST\
**Headers:**
* Authorization: Bearer {token}
* Content-Type: application/json

**Body:**

```json
{
    "provider": "BOG_GEL", // provider type
    "outerId" : "String", // transaction id from payment provider
    "gateId": "String", // transaction id from payment service
    "outerAt" : "2021-06-09T07:07:01.475Z", // payment date in payment provider
    "account" : 123456,
    "amount" : 12.33,
    "commissionAmount": 1.22,
    "orderId" : "String", // optional
}
```

**Response**

Success:

``` 
```

Error 400:

```json
{
    "timestamp": 1625569055907,
    "path": "/account/123456",
    "status": 400,
    "error": "Bad Request",
    "requestId": "22780a9e-1"
}
```







