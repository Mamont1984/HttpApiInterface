1.1. регистрация пользователя, возвращает confirmation token, который используется для подтверждения email 
`POST /register`

in
```json
{
  email: "уникальный идентификатор пользователя",
  password: "пароль"
}
```

out ok
```json
{
  success: true,
  message: "",
  token: "токен подтверждения, уникальная случайная строка"
}
```
out error 
```json
{
  success: false,
  message: "описание ошибки",
  error: "error_code"
}
```


1.2. подтверждение токена, полученого при регистрации
`POST /confirm`


in
```json
{
  token: "confirmation token"
}
```
out ок 
```json
{
  success: true,
  message: "",
  user: {
    id: числовой уникальный идентификатор пользователя,
    email: "уникальный идентификатор пользователя",
    created: unix timestamp (msec)
  }  
}
```
out error
```json
{
  success: false,
  message: "описание ошибки",
  error: "error_code"
}
```


1.3. аутентификация пользователя
`POST /login`


in 
```json
{
  email: "уникальный идентификатор пользователя",
  password: "пароль"
}
```
out ok
```json
{
  success: true,
  message: "",
  user: {
    id: числовой уникальный идентификатор пользователя,
    email: "уникальный идентификатор пользователя",
    created: unix timestamp (msec)
  }  
}
```
out error
```json
{
  success: false,
  message: "описание ошибки",
  error: "error_code"
}
