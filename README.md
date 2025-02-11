<a href="https://www.buymeacoffee.com/hientech" target="_blank"><img src="https://img.shields.io/badge/-buy_me_a%C2%A0coffee-gray?logo=buy-me-a-coffee" alt="Buy Me A Coffee"></a>
  <br>
## Credit engine project 


### Project structure 
2 services - UserService and FinancialService 

### Tech stack 
+ Spring boot 
+ Maven 
+ Database : MySQL - Flyway for migration 
+ Jobs with Maven project on Jenkins
+ Docker 



### Microservices architecture 
+ Service discovery : Netflix's Eureka
+ Circuit breaker : Hystrix
+ API gateway : Zuul 
+ Configuration server : Spring config server 
+ Message broker : RabbitMQ (basic queue - exchange) 
+ Secure endpoint with JWT 
+ Docker 
+ Jenkins 
  + Job shell script in Jenkins: 
  `# build docker image  
   docker build --pull=true -t https://github.com/HienNguyen711/creditengine-microservices:$GIT_COMMIT  
 
   # test docker image 
   docker run -i --rm https://github.com/HienNguyen711/creditengine-microservices:$GIT_COMMIT ./script/test 
  
   # push docker image to docker hub
   docker pushhttps://github.com/HienNguyen711/creditengine-microservices:$GIT_COMMIT`
