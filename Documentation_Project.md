# API_POSTING
resources - logins.csv, postings.csv, файлы с данными заказов и сотрудников. Считывание данных происходит в class ReadCsv.

Использование API : 
Общие запрос : localhost:8080/api/{action}/{value}?isAuthority=false
Поле isAuthority является необязательным, константное значение = false.

1. localhost:8080/api/findByYear/{year}
Поиск необходимой документации по году.
2. localhost:8080/api/findByMonth/{month}
Поиск необходимой документации по месяцу.
3. localhost:8080/api/findByDay/{day}
Поиск необходимой документации по дню.
4. localhost:8080/api/findByQuarter/{quarter}
Поиск необходимой документации по кварталу.

=====================================================================================================================================================================

Примеры :

localhost:8080/api/findByMonth/10/isAuthority=true
Вернёт JSON-объект всех авторизованных поставок по данному месяцу.
