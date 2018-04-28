# distributed-tracing

1- Build a project 

    mvn clean install -Pdocker
    
2- Start the application 

    docker-compose up 
    
3- Test the application 

3.1- Go to the dashboard zipkin

    http://localhost:9411/
    
3.2 Go to the mesures endPoint 

    http://localhost:8956/mesures
    
3.3 After having done tne above instructions, 
go a second time to the dashboard zipkin and click on 

    Find Traces