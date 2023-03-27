The backend API is here, host = "localhost:8081"
For participant:

`GET` end point = /api/v1/participants -> to get a list of all participants in the database.

`POST` end point = /api/v1/participants -> to create one or more participants in the database using a list of String, request body.

Json Example:
```json
[
    "participant1",
    "participant2"
]
```
>Passing this Json to the API will create 2 participant with name participant1 and participant2.

`DELETE` end point = /api/v1/participants -> to delete one or more participants By id in the database using list, request body.

Json Example:
```json
[
    68,
    69
]
```
>Passing this Json to the API will delete the participant with id 68 and the participant with id 69.

`PUT` end point = /api/v1/participants -> to update one or more participants By id in the database using list, request body.

Json Example:
```json
[
    {
        "id": 71,
        "name": "updated name1"
    }
]
```

>Passing this Json to the API will update the name of participant with id 71 to "updated name1".

---
For practice:

`GET` end point = /api/v1/practices -> to get a list of all practices in the database.

`POST` end point = /api/v1/practices -> to create one or more practices in the database using list, request body.

Json Example:
```json
[
    {
        "date": "2023-04-03",
        "venue": "somewhere",
        "startTime": "20:00:00",
        "endTime": "23:00:00"
    }
]
```
>Passing this Json to the API will create 1 practice with details above.

`DELETE` end point = /api/v1/practices -> to delete one or more practices By id in the database using list, request body.

Json Example:
```json
[
    1,
    2
]
```
>Passing this Json to the API will delete the practice with id 1 and the practice with id 2.

`PUT` end point = /api/v1/practices -> to update one or more practices By id in the database using list, request body.

Json Example:
```json
[
    {
        "id": 1,
        "date": "2023-03-24",
        "venue": "updated venue",
        "startTime": "20:00:00",
        "endTime": "23:00:00"
    },
    {
        "id": 2,
        "date": "2023-03-27",
        "venue": "updated venue",
        "startTime": "20:00:00",
        "endTime": "23:00:00"
    }
]
```
>Passing this Json to the API will update the date, venue, startTime and endTime of 2 practices with id 1 and 2.
---
For Attendance:

`GET` end point = /api/v1/attendances -> to get a list of all attendances in the database.

`POST` end point = /api/v1/attendances -> to create one or more attendances in the database using list, request body.

Json Example:
```json
[
    {
        "participantId":1,
        "practiceId":1
    },
    {
        "participantId":1,
        "practiceId":2
    },
    {
        "participantId":2,
        "practiceId":1
    }
]
```
>Passing this Json to the API will create 3 attendances.

`DELETE` end point = /api/v1/attendances -> to delete one or more attendances By id in the database using list, request body.

Json Example:
```json
[
    5,
    6
]
```
>Passing this Json to the API will delete the attendances with id 5 and the attendances with id 6.
