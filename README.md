## FamPay | Backend Assignment

### Project Goals

To make an API to fetch the latest videos sorted in reverse chronological order of the publishing date-time from YouTube for a given search query in paginated response.

### Basic Functionalities Provided

- Cron Job to constantly fetch data and update the database every 15 seconds.
- GET API, `api/getAll` for fetching videos which are sorted in descending order of their date of publication and returned in paginated format. Accepts 2 optional parameters, page and size of type integer.
- Search API `api/search?query={search-query}` which searches the database for the given string and returns all videos whose title or description contains the same.
- Fail-safe feature to accept multiple API keys and use the next key when one of them hits its daily usage quota.

### Instructions to run the Server

1. Clone the project

`https://github.com/pruthvirajd/youtube-assignment.git`

2. Initialize MS-SQL database and populate the respective values in application.properties

```
ms.sql.server= {sql server ip:port}
database.name= {database name}
spring.datasource.username= {username for accessing sql server}
spring.datasource.password= {password for accessing sql server}
```
3.Provide YouTube Data API key which is required to run this applicaiton. Go to [this page](https://developers.google.com/youtube/v3/getting-started) to create one. Populate the same in application.properties file as shown below:
```
youtube.api.keys= {List of comma-separated API keys}
youtube.api.query= {Query which should be searched to populate the database}
```

> **Note:**
> - In case of multiple API keys, provide them as "," delimited list of keys like so:
```
youtube.api.keys="<API_KEY1>,<API_KEY2>..."
```

3. Install dependencies

`mvn install`

4. Up the tomcat Instance

`java -jar /pruthviraj-youtube-assignment.jar`

### Running using Docker

When using Docker,

1. Set all application.properties as shown above in the ./application.properties file.
2. Run the follow command to generate the image:
```
docker build -t pruthviraj-youtube-assignment.jar .
```

3. Run the following command to initialize the container:
```
 docker run -p 9090:8080 pruthviraj-youtube-assignment.jar
```

4. Find your device's local IP address by hitting this command and looking for en0 inet :
```
ifconfig
```

5. Go to port 9090 on the above obtained IP address:

Sample getAll API call:
`<IP_ADDRESS>:9090/api/getAll`

### Resources

1. https://developers.google.com/youtube/v3
