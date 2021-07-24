# Damco Demo App.

#### Database setting

1. create a database named **damco-demo**
2. collection will automatically created when you insert any document in it.
3. mongodb port number default **27017** and host is **localhost**.
4.  On my local machine, there is no need to configure username, password, if on your system it is required then open **application.properties** files  and make necessary changes here.





#### Junit

1. I am using MongoRepository interface, and only using using its built in methods, so I do not need to write jUnit for this.
2. As said, If I am going to write jUnit test case for controller, and controller calls service methods, so We need to write logic for server methods, instead of we should use **Mockito**. So I am using Mock.



#### Swagger

1. Run application then paste below URL in browser
2. http://localhost:8080/swagger-ui/#/user-controller

