# Mini-Apps Employee

based on https://dummy.restapiexample.com/

## Documentation

### Base URL: `localhost:8080/api/v1`

| endpoint        | method | type |     request body     |
| --------------- | :----: | :--: | :------------------: |
| /employee       |  GET   | JSON | true, required false |
| /employee/{nik} |  GET   | JSON |        false         |
| /employee       |  POST  | JSON |         true         |
| /employee/{id}  |  PUT   | JSON |         true         |
| /employee/{id}  | DELETE | JSON |        false         |

---

### `GET /employee`

```
localhost:8080/api/v1/employee
```

#### Request Body (Optional):

Request body to search with name containing.

```json
{
    "name": "Input Your Name Here"
}
```

#### Response Body:

##### Status: 200 - Success

```json
{
    "status": "Success",
    "code": 200,
    "message": "Get All Employe Data Success!",
    "data": [
        {
            "id": 1,
            "nik": "3201291999190001",
            "name": "Muhammad Irfan Adi Prayoga",
            "age": 24,
            "salary": 10000000.0
        }
    ]
}
```

---

### `GET /employee/{nik}`

```
localhost:8080/api/v1/employee/3201291999190001
```

#### Request Body: -

#### Response Body:

##### Status: 200 - Success

```json
{
    "status": "Success",
    "code": 200,
    "message": "Get Employee by NIK Success.",
    "data": {
        "id": 1,
        "nik": "3201291999190001",
        "name": "Muhammad Irfan Adi Prayoga",
        "age": 24,
        "salary": 10000000.0
    }
}
```

##### Status: 404 - NIK Not Found

```json
{
    "status": "Fail",
    "code": 404,
    "message": "Get Employee By NIK Fail. NIK Not Found.",
    "data": null
}
```

---

### `POST /employee`

```
localhost:8080/api/v1/employee
```

#### Request Body (Required):

```json
{
    "nik": "3201291999190001", // Not Blank, Must 16 digit
    "name": "Muhammad Irfan Adi Prayoga", // Not Blank, Max 50 char
    "age": 24, // Not Null
    "salary": 10000000.0 // Not Null
}
```

#### Response Body:

##### Status: 200 - Success

```json
{
    "status": "Success",
    "code": 200,
    "message": "Insert New Employee Success.",
    "data": {
        "id": 2,
        "nik": "3201291999190001",
        "name": "Muhammad Irfan Adi Prayoga",
        "age": 24,
        "salary": 10000000.0
    }
}
```

---

### `PUT /employee/{id}`

```
localhost:8080/api/v1/employee/1
```

#### Request Body (Required):

```json
{
    "nik": "3201291999190002", // Must 16 digit
    "name": "Muhammad Alejandro Putra", // Max 50 char
    "age": 22,
    "salary": 10000000.0
}
```

#### Response Body:

##### Status: 200 - Success

```json
{
    "status": "Success",
    "code": 200,
    "message": "Update Employee Success.",
    "data": {
        "id": 1,
        "nik": "3201291999190002",
        "name": "Muhammad Alejandro Putra",
        "age": 22,
        "salary": 10000000.0
    }
}
```

##### Status: 404 - Id Not Found

```json
{
    "status": "Fail",
    "code": 404,
    "message": "Update Employee By Id Fail. Id Not Found.",
    "data": null
}
```

##### Status: 400 - NIK Not Unique

```json
{
    "status": "Fail",
    "code": 400,
    "message": "Update Employee By Id Fail. NIK is Not Unique.",
    "data": null
}
```

---

### `DELETE /employee/{id}`

#### Request Body: -

#### Response Body:

##### Status: 200 - Success

```json
{
    "status": "Success",
    "code": 200,
    "message": "Delete Employee Success.",
    "data": null
}
```

##### Status: 404 - Id Not Found

```json
{
    "status": "Fail",
    "code": 404,
    "message": "Delete Employee By Id Fail. Id Not Found.",
    "data": null
}
```
