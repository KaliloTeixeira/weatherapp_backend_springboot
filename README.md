# weatherapp_backend_springboot

# **Preparation Project**
# **Java 17 - Springboot 3.1.2**
**Project name:** WeatherApp API
**Tech stack:** Springboot 3.1.2, Angular8+
## **Lesson goals**
Project made as improvement of previous project weatherapp_backend.

### To Run

// Clone the repository
- git clone

// 
- mvn spring-boot:run


**Springboot 3.1.2 - Java 17**
1. Springboot Web
1. Rest Controller
1. Dependency Injection (DI)
1. Java Persistence API (JPA)
1. Background services (Scedulers)
1. Access external services via Rest API (Rest Client)


## **Homework description**
Create a client-server application, the main function is to show a cities weather (temperature) data on a simple web interface, so we call our application "WeatherApp"

### **The main functions of the WeatherApp**
1. Enter a city name, and fint the weather information from a public, external API (eg. openweathermap.com)
1. Save the weather information to local database for the city that was entered
1. List the cities and weather information that are in our local database
1. Can delete city from out local database
1. Weather data is automatically refreshed in the background using a scheduled service

### **Use cases**
1. Add new city weather data
1. Get list of weather data from our local database
1. Delete city from our local database

### **Tasks to be completed**
#### **Backend**
1. Create and configure the Springboot project, called WeatherApp
1. Configure database 
   0. Create schema: weatherapp
   0. Create table: weatherdata 
      0. cityname - name of the city
      0. temperature - the last known temperature of the city
      0. time - the time of the measurement
1. Configure application server.
1. Create services and Rest interfaces.
1. Build and deploy application.
1. Test application's Rest API


## **Checklist**

|**Component**|**Task**|**Description**|**Done (Y/N)**|
| :-: | :-: | :-: | :-: |
|Backend|Create project structure|Create a Springboot web application project in your favorite IDE and configure it.|:white_check_mark:|
|Backend|Build and deploy project|Build and run the empty project.|:white_check_mark:|
|Database|Create database schema and tables|Create the necesary database schema and the tables.|:white_check_mark:|
|Backend|Create entity class and basic JPA functions|Create model for watherdata and save it, load it from database successfully.|:white_check_mark:|
|Backend|Hello world Rest API|Create a simple REST API which returns only "Hello Weather"|:white_check_mark:|
|Backend|Rest API: addCity|Implement and test the addCity API. Save data to database.|:white_check_mark:|
|Backend|Rest API: listCities|Implement and test listCities API. Have to load data from local DB.|:white_check_mark:|
|Backend|Rest API: deleteCity|Implement and test deleteCity API. Have to delete data from local DB.|:white_check_mark:|
|Backend|openweathermap API client|Implement a client that calls openweatherapi.org weather REST API by city name. The result must be saved to our local database.|:white_check_mark:|
|Backend|Scheduled update service|Implement a the update service which update the cities data from the openweather api.|:white_check_mark:|
|Backend|Dependency Injection|Use DI to use Springboot components.|:white_check_mark:|
|Backend|Error handling|Handle errors in the Rest API with general way.|:white_check_mark:|
|Backend|Logging|Log the events what happens in the REST API.|:white_check_mark:|
|<p>Backend +</p><p>Frontend</p>|CHECK ALL THE APPLICATION IS WORKING?|CHECK ALL THE APPLICATION IS WORKING?|:white_check_mark:|
