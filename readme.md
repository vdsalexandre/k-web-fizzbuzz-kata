# Web app FizzBuzz

### Install and use
`git clone https://github.com/vdsalexandre/k-web-fizzbuzz-kata.git`

`gradle build`

`gradle bootRun`

### Description
FizzBuzz Web app endpoint returns a JSON objects containing 1 to limit (for example 100) values.
Every **int1** multiples will be replaced by **str1** text and exactly the same for **int2** and **str2** parameters.

### Application endpoints
    POST http://localhost:9090/fizzbuzz

* #### Parameters :

| key     | value    |
|---------|----------|
| int1    | 3        |
| int2    | 5        |
| limit   | 50       |
| str1    | fizz     |
| str2    | buzz     |

* #### Example :
Body : 
`{
    "int1": 3,
    "int2": 5,
    "limit": 50,
    "str1": "fizz",
    "str2": "buzz"
}`

    GET http://localhost:9090/fizzbuzz/statistics

### Project versions
* Kotlin version : **1.6.10**
* Java version : **17**
* Springboot version : **2.6.6**
* Application version : **0.0.1-SNAPSHOT**
* Tests version : **junit-5**
