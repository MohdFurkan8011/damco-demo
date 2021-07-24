# Damco Demo App.

#### Database setting

1. create a database named **damco-demo**
2. collection will automatically created when you insert any document in it.
3. mongodb port number default **27017** and host is **localhost**.
4.  On my local machine, there is no need to configure username, password, if on your system it is required then open **application.properties** files  and make necessary changes here.



#### Lombok Setting

Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.
Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.

`If you do not have lombok enable in your IDE please refer to this link to install lombok ----> `

`https://www.baeldung.com/lombok-ide`



#### Junit

1. I am using MongoRepository interface, and  it has only built in methods in my case, so I do not need to write jUnit for this.
2. If your target class another class methods, etc. controller calls service methods then we do not need to call service method, just create **Mock** objects for those. So I am using mockito in my test cases.



#### Swagger

1. Run application then paste below URL in browser
2. http://localhost:8080/swagger-ui/#/user-controller

