#Challenger BrasilPrev Customer API Rest
This project is a API Rest to execute CRUD operations on Customer entity. That application uses database in memory (H2), Swagger Framework to document the endpoints, expose application health check and observability metrics to Prometheus using Spring Actuator and protected the application endpoint using Spring Security.

#Operations
To consume that API you can use conventional ways like PostMan and Insomnia. Was configured Swagger Framework to that project, it is a another way to consume the API accessing via host/swagger-ui.html.

#Building the application and running

1. Clone the git repository;
2. Go to the directory of application;
3. Run the maven command to create a package;
4. Run the application like a common java application;
5. Consume the API via http://localhost:8080/.

~~~sh
git clone https://github.com/recorderitsolutions/desafio-brasilprev.git
cd desafio-brasilprev/
mvn clean package
java -jar target/desafio-brasilprev-1.0.0-SNAPSHOT.jar
~~~

#Building a Docker image and running
1. Clone the git repository;
2. Go to the directory of application;
3. Run the Docker command to build a image;
4. Run the Docker command to run the application exposing the port 8080;
5. Consume the API via http://localhost:8080/.

~~~sh
git clone https://github.com/recorderitsolutions/desafio-brasilprev.git
cd desafio-brasilprev/
docker build -t desafio-brasilprev .
docker run -d --name desafio-brasilprev -p 8080:8080 desafio-brasilprev
~~~

#Accessing the API remotely
That application was deployed on Heroku and can accessed clicking [here](https://desafio-brasilprev-20210314.herokuapp.com/) .

#Security
The API is protected by Spring Security and to access the endpoints is necessary use Basic Authentication

User: admin

Password: admin123

To access the Swagger, Actuator and H2 Console is not necessary to authenticate.

#H2 Console
host/h2-console

#Swagger Framework
host/swagger-ui.html

#Spring Actuator
host/actuator

#Prometheus Metrics
host/actuator/prometheus