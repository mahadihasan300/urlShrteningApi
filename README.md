# urlShrteningApi
This API can short a long URL . It can also collect user data like Device, IP, Browser
REST API documentation of URL Shortener service (Postman)
Database :
DataBase used H2.
To access the database after running the project there will be a JDBC Url in the console of the project . copy the url and go to
http://localhost:8080/h2-console/
Then past the url in the JDBC Url text box . Check the connection and press connect to connect the database .
An POST endpoint which will consume long url, short url domain, some optional parameters
as json format and on success it will return short url as json format and a unique id of the
Record.
http://localhost:8080/generate
JSON Example
Input:
{
"url":"https://www.linkedin.com/jobs/search/?currentJobId=2468052559&pivotType=jymbii",
"shortUrlDomain":"gog.com.",
"parameters": {
"param1": "value1",
"param2": "value2"
}
}
To redirect from the short link to original URl just copy the short link and past it after
http://localhost:8080/
Example:
Suppose Short link generated as 3Cn9Dz
So hit in the browser like http://localhost:8080/3Cn9Dz
An GET endpoint which will return record using unique id returned from endpoint
http://localhost:8080/findBy1
Here 1 is a unique id .
An GET endpoint which will send a list of all click data.
http://localhost:8080/allClickedData
An GET endpoint which will return total count on short url
http://localhost:8080/totalShortUrl
