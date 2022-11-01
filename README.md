# INFO 6250 MiniProj
## About INFO 6250
### Course Description
Explores advanced server-side technologies and tools necessary to design and engineer complete web-based enterprise applications quickly. Designed to build on previous experience to cover the life cycle of a web-based application. Focuses on MVC web development frameworks to build server-side, data-intensive, and multitier web applications. Additionally, discusses designing rich internet applications (RIA) using AJAX and service-oriented architecture (SOA) using REST.

### Professor
Ashwin D'Sousa

## Project Description
Create a library management system website using technologies such as Tomcat, Servlet and Jsp. Users and administrators can login, register accounts, manage information, manage books, etc.

## Use Case
### Users
1.	Users can view the list of books in the library.
2.	Users can view specific information about selected books, as well as borrow and return books.
3.	Users can register and login to access the library management system.

### Admin
1.	Admin cannot register but can log in to the system with a pre-defined account and password.
2.	Admin can view the information of registered users, and view and edit their information.
3.	Admin can add or delete the books in the library.
4.	Admin can view and edit book specific information.

## What's Interesting
* The paths of most pages are hashed to avoid direct exposure to users.
* Users cannot access pages other than the home page by typing the URL directly into the address bar, and such requests are blocked.
* All user inputs are verified, once on the front end and once on the back end.
* Dangerous operations by users (e.g. delete users, delete books) are confirmed twice.
* Good code habits and architecture.

## Shortage
* Web pages are more primitive.
* The technology used is older.
* No JS is used, so there is no AJAX.
* The database table design is relatively simple.