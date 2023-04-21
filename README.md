# SponsoredAds

Prerequisites
Before proceeding with the build and run instructions, please make sure you have the following software installed on your machine:

- JDK 17 or higher
- maven
- Docker

Additionally, you will need to clone the repository of the Java 17 Spring Boot application to your local machine.

Build Instructions
To build the Java 17 Spring Boot application using IntelliJ IDEA, follow these steps:

- Open IntelliJ IDEA and import the cloned repository.
- Once the project is imported, go to the "Maven Projects" tab on the right-hand side of the window.
- Expand the project's folder.
- Expand the lifecycle option.
- Mark the options "Clean" + "Install" and press the run option. 
- This will build the Java 17 Spring Boot application and create an executable JAR file in the target directory.

Run Instructions - Using Docker Compose
- Make sure Docker is installed and running on your machine.
- Open a command prompt or terminal window.
- Navigate to the directory where the cloned repository is located.
- Run the following command to start the application and its dependencies (such as a MySQL database) in Docker containers:

docker-compose up -d
- Wait until the 2 containers (MySql and SponsoredAds) will pulled and running.
- After the 2 containers are up and running - you can use the Postman collection for testing the APIs

Note: If you want running the application directly from IntelliJ IDEA you should follow this following steps:

1. Start the MySQL container using the command: `docker run -d --name mysql-container -e MYSQL_ROOT_PASSWORD=sponsoredAds -p 3306:3306 mysql`.

2. Update the `spring.datasource.url` property in your `application.properties` file to point to the MySQL container: `spring.datasource.url=jdbc:mysql://localhost:3306/sponsoredAdsDB?createDatabaseIfNotExist=true`.

3. Finally, after the MySQL container is up and running,  click the "Run" or "Debug" button in IntelliJ IDEA to start the application. 

The server will upload in port 8083.

#APIs

1. Init DB Data:
  - End Point : sponsoredAds/init
  - Method : POST
  - Explanation : Save a bulk of products and categories to the DB.

2. Create Campaign:
  - End Point : sponsoredAds/campaign 
  - Method : POST
  - Body : 
          {
            "name": <String>,
            "startDate": <Dtae in format YYYY-MM-DD>,
            "bid": <int> ,
            "productsSerialNumbers": <Array of products serial numbers (String Array)>
           }
  - The response should be 200 if: All the products serial numbers are valid serial numbers of products in the db. Otherwise - you wull get error status        code with error message that explain what did go wrong. If the response code is 200 - a Json of the campaign that created is returned.
  
 3. Serve Ad :
    - End Point : product/serve-ad
    - Method : GET
    - Query Params: "categoryName" = <The category name>
    - The response code should be 200 unless the catagory name provided is not valid or if there is no product that promited righr now (AKA - there is no         product that in an active campaign). If the response cose is 200 - a Json of the promoted product with the highest bid from the input category.             (unless there are no promoted products from this category, if so - the promoted product with the highes bid will be return)
  
   4. Get all campaigns :
    - End point: sponsoredAds/campaign/all
    - Method : GET
    - Response : Array of all the campaigns from the db (Json).
    
  5. Get all categories:
    - End point: sponsoredAds/category/all
    - Method: GET
    - Response : Array of all the categories from the db (Json).
  
  6. Create category:
    - End point: sponsoredAds/category
    - Method: POST
    - Query param: "name" = <Category name> 
    - Should be 200. If the category already exist - will not duplicate it. 
  
  7. Create product:
    - End point : sponsoredAds/product
    - Method : POST
    - Query Params: "categoryName" = <The category name>
    - Body : {
                "serialNumber": 2,
                "title": "Ball",
                "price": 100
              }
    - Response should be 200 unless: serial num already exist or category name is not valid. 
