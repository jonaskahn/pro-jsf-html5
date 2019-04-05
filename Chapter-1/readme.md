
### Notes

- Actually, since JSF 2.0, the faces-config file becomes optional because most of the JSF configuration can be defined using the Java annotations.

- 
### Question & Answers

- *What is ManagedBean?*
 - The presence of this annotation on a class automatically registers the class with the runtime as a managed bean class. Classes must be scanned for the presence of this annotation at application startup, before any requests have been serviced.
 - The scope of the managed bean is declared using one of NoneScoped, RequestScoped, ViewScoped, SessionScoped, ApplicationScoped, or CustomScoped annotations. If the scope annotations are omitted, the bean must be handled as if the RequestScoped annotation is present.

- *What is JSP (JavaServer Pages)*
>

- *What is Servlets*
>

- *What is JSF (JavaServer Faces)*
>

### Fun things

***JSF in MVC?***

- All we know that JSF was based on MVC technology, but I almost get wrong with JSF MVC until I read this book. Before that, I thought:
  - Model ~~is java class (pojo class)~~
  - View ~~is Facelets Xhtml page~~
  - Controller ~~is ManagedBean~~


- But **I was wrong**. Here is the definiton:
  - Controller , which is represented by the JSF Faces Servlet. The Faces Servlet is responsible for handling the request dispatching and the pages is responsible for handling the JSF request processing life cycle.
  - Model , which is represented by the JSF managed beans and the back-end code. The JSF managed bean is simply a POJO that conforms to the JavaBeans naming conventions and can be accessed from the JSF application (pages and other managed beans).
  - View , which is the rendering technology of JSF. The rendering technology defines the page layout and content.
  - Let's take a look on the picture below:
![JSF MVC](https://live.staticflickr.com/7804/40575279223_c7e5c0f743_o_d.jpg)
