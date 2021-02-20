# LibraryProject---Java
Backend + Frontend for a library. Frontend - HTML + CSS + JS

1. Description of the problem

The purpose of the application is to implement the management of a library. This means that our library will have 3 users: the admin, the librarian and the client. The admin will be the user who can create new books, create new librarian positions, and assign each librarian a list of books that the librarian will need to deal with. The client is the user who will want to borrow a book. The librarian will first check if the name of the desired book is in the library, and if it is based on the number of copies available, he will be able to borrow the book.
For the moment we have implemented the Book module with all its functionalities. In this way I got used to the work environment and will implement the Admin, User and Client. If my time allows, I want to make a good login

2. APIs and FRAMEWORKS 

As the work environment I use InteliiJ, Java SpringBoot. SpringBoot simplifies the creation of production applications by being very fast, much more general and very specific. In addition to SpringBoot I used the Java Persistance API which is the specification of an interface that describes the management of relational data. With JP API I managed very quickly to make the connections between my application and the database using the CRUD (CREATE READ UPDATE DELETE) methods. In addition, we also used the Hiberante Framework, which is a useful framework for object-to-object relational mapping and provides a framework for mapping an object-oriented domain model into a relational database. MySqlWorkbench was used for the database.

    2.1 The solution of the application  
    

The solution offered for the realization of the application is to have a database through which to store the administrators, clients and the library. In the front-end part we can execute the queries on the tables, queries that are made in the back-end part. For the front-end part, React and Vue will be used and for the back-end part, Java + Spring will be used.

3. Implementation

The project is structured in 6 packages, each package containing the classes that fulfill the same functionality. The project is created of Maven type, and in order to be able to connect to the database two files were created: a pom.xml file that contains all the dependencies necessary for the project operation and a file called application.properties that contains the properties of the server that holds the base data. The model package contains the entity classes that are the basis for creating the project, the repository package contains the repository of each entity needed for our application, namely JPA Repository, the useful package contains the classes that implement the 2 required design patterns, Observer and FactoryPattern, the validity package contains classes that deal with the validation of the data of some methods and the controller package contains the controllers of the entities necessary in the realization of the project, the package being also the busiest in the backend part.
#BookController, ClientController, LibraryController These classes contain implementations of the methods in the interfaces in the repository package and manipulate the data in the tables. They contain methods that search for objects in the database by a certain Id, Name or title, make insertions in the database, deletions, updates. Annotations are very important, especially @RestController which tells us that class has the behavior of a controller. The connections between the application and the Java code are made through these annotations.

#BookRepository, ClientRepository, LibraryRepository These interfaces extend the JpaRepository class and mean that they have several methods implemented by default. These classes are part of the repository package
#Book, Client, Library These classes are in the model package and are the representation of the entities used in the controllers. They have the specific annotations @Table, @Entity and also have variables, constructors, get-eras and set-eras.
#Observer, User, UserFactory These classes are part of the useful package and represent the implementation of the required design patterns, respectively Observ and FactoryPattern. ** 

4. Graphical interface

The graphical interface I chose to do in the WEB using the related tools. It is not a very complex application, it is something simple but I fulfill the main task of the theme, which is to consume all the services created in the backend. For the beginning, the frontendPS folder was created, which contains all the HTML, JS and CSS files related to the project implementation. HTML makes the design part of the page and inside the HTML code there is a link, a redirect to a JavaScript file that implements certain functionalities using the JQuery and AJAX tool. CSS is used very little, it being for style, this being used only for the design of the login page and for the design of all the buttons existing in my application.

4.1 How the graphical interface works 


First of all, run the backend application. After it runs successfully, enter the login.html page and from there start running the application itself. If we want to log in as admin we must enter the "admin" data and the "admin" password and we will be redirected to the library.html page where we will see the list of borrowed books and by whom they were borrowed. From here, as an admin, we have access to add new books to the library, to delete existing books, to add new clients, to delete clients, to create rentals, to delete book rentals, etc.
Instead, if we want to log in as a customer, we only need to enter the username in the login. Each customer logs in only with his name, there is no need to enter a password. Of course, this is not very safe and the application needs to be greatly improved on the security side.

5. Conclusion
The purpose of this application is to automate libraries. It is not a complex application, but it has a back-up database that can be used to store books, customers, book loans, etc.
