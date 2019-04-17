
## Notes

- Actually, since JSF 2.0, the faces-config file becomes optional because most of the JSF configuration can be defined using the Java annotations.

## Question & Answers

**What is ManagedBean?**

- The presence of this annotation on a class automatically registers the class with the runtime as a managed bean class. Classes must be scanned for the presence of this annotation at application startup, before any requests have been serviced.
- The scope of the managed bean is declared using one of NoneScoped, RequestScoped, ViewScoped, SessionScoped, ApplicationScoped, or CustomScoped annotations. If the scope annotations are omitted, the bean must be handled as if the RequestScoped annotation is present.

**What is JSP (JavaServer Pages)**

- JSP is a **Java view technology running** on the server machine which allows you to write template text in client side languages (like HTML, CSS, JavaScript, ect.). JSP supports taglibs, which are backed by pieces of Java code that let you control the page flow or output dynamically. A well-known taglib is JSTL. JSP also supports Expression Language. 
- When a JSP is requested for the first time or when the web app starts up, **the servlet container will compile it into a class extending HttpServlet and use it during the web app's lifetime**. You can find the generated source code in the server's work directory. In for example Tomcat, it's the /work directory. On a JSP request, the servlet container will execute the compiled JSP class and send the generated output (usually just HTML/CSS/JS) through the web server over a network to the client side, which in turn displays it in the web browser.

**What is Servlets**
- Servlet is a **Java application programming interface** (API) running on the server machine, which intercepts requests made by the client and generates/sends a response. A well-known example is the HttpServlet which provides methods to hook on HTTP requests using the popular HTTP methods such as GET and POST. You can configure HttpServlets to listen to a certain HTTP URL pattern, which is configurable in web.xml, or more recently with Java EE 6, with @WebServlet annotation.
- When a Servlet is first requested or during web app startup, **the servlet container will create an instance of it and keep it in memory during the web app's lifetime**. The same instance will be reused for every incoming request whose URL matches the servlet's URL pattern. You can access the request data by HttpServletRequest and handle the response by HttpServletResponse. Both objects are available as method arguments inside any of the overridden methods of HttpServlet, such as doGet() and doPost().

**What is JSF (JavaServer Faces)**

**What is the difference between Tomcat and Glassfish**

## Fun things

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