
## Notes

- Actually, since JSF 2.0, the faces-config file becomes optional because most of the JSF configuration can be defined using the Java annotations.
- JSF Converters don't proceed in the second phase - [Apply Request Model except when you set immediate equals true](https://stackoverflow.com/a/12837663/2865414)

## Question & Answers

**What is ManagedBean?**

- The presence of this annotation on a class automatically registers the class with the runtime as a managed bean class. Classes must be scanned for the presence of this annotation at application startup, before any requests have been serviced.
- The scope of the managed bean is declared using one of NoneScoped, RequestScoped, ViewScoped, SessionScoped, ApplicationScoped, or CustomScoped annotations. If the scope annotations are omitted, the bean must be handled as if the RequestScoped annotation is present.

**What is JSP (JavaServer Pages)?**

- JSP is a **Java view technology running** on the server machine which allows you to write template text in client side languages (like HTML, CSS, JavaScript, ect.). JSP supports taglibs, which are backed by pieces of Java code that let you control the page flow or output dynamically. A well-known taglib is JSTL. JSP also supports Expression Language. 
- When a JSP is requested for the first time or when the web app starts up, **the servlet container will compile it into a class extending HttpServlet and use it during the web app's lifetime**. You can find the generated source code in the server's work directory. In for example Tomcat, it's the /work directory. On a JSP request, the servlet container will execute the compiled JSP class and send the generated output (usually just HTML/CSS/JS) through the web server over a network to the client side, which in turn displays it in the web browser.
- Example:
  <img src="https://live.staticflickr.com/65535/40660030113_5120ebcc2f_o_d.png" data-canonical-src="https://live.staticflickr.com/65535/40660030113_5120ebcc2f_o_d.png" width="900" height="543" />

**What is Servlets?**
- Servlet is a **Java application programming interface** (API) running on the server machine, which intercepts requests made by the client and generates/sends a response. A well-known example is the HttpServlet which provides methods to hook on HTTP requests using the popular HTTP methods such as GET and POST. You can configure HttpServlets to listen to a certain HTTP URL pattern, which is configurable in web.xml, or more recently with Java EE 6, with @WebServlet annotation.
- When a Servlet is first requested or during web app startup, **the servlet container will create an instance of it and keep it in memory during the web app's lifetime**. The same instance will be reused for every incoming request whose URL matches the servlet's URL pattern. You can access the request data by HttpServletRequest and handle the response by HttpServletResponse. Both objects are available as method arguments inside any of the overridden methods of HttpServlet, such as doGet() and doPost().

**What is JSF (JavaServer Faces)?**
- JSF is a component based MVC framework which is built on top of the Servlet API and provides components via taglibs which can be used in JSP or any other Java based view technology such as Facelets. Facelets is much more suited to JSF than JSP. It namely provides great templating capabilities such as composite components, while JSP basically only offers the `<jsp:include>` for templating, so that you're forced to create custom components with raw Java code (which is a bit opaque and a lot of tedious work in JSF) when you want to replace a repeated group of components with a single component. Since JSF 2.0, JSP has been deprecated as view technology in favor of Facelets.
- JSF provides the FacesServlet as the sole request-response Controller. It takes all the standard and tedious HTTP request/response work from your hands, such as gathering user input, validating/converting them, putting them in model objects, invoking actions and rendering the response. 

**Facelets**
- The term Facelets refers to the view declaration language for JavaServer Faces technology. JavaServer Pages (JSP) technology, previously used as the presentation technology for JavaServer Faces, does not support all the new features available in JavaServer Faces in the Java EE 6 platform. JSP technology is considered to be a deprecated presentation technology for JavaServer Faces

- Facelets is a powerful but lightweight page declaration language that is used to build JavaServer Faces views using HTML style templates and to build component trees. Facelets features include the following:
  - Use of XHTML for creating web pages
  - Support for Facelets tag libraries in addition to JavaServer Faces and JSTL tag libraries
  - Support for the Expression Language (EL)
  - Templating for components and pages


**What is the difference between Tomcat and Glassfish?**
- Glassfish is a complete Java EE application server, including an EJB container and all the other features of this stack. It comes from Oracle and, therefore, each new specification will be tested and implemented with Glassfish first.
- Tomcat is simply an HTTP server and a Java servlet container. It is run by the Apache community. Tomcat is open source and free. Supports all Java EE technologies. It is not compatible with any commercial support, but only supported by the community.

Read more at: [GlashFish vs Tomcat](https://www.freelancinggig.com/blog/2017/06/05/whats-difference-glassfish-apache-tomcat/)

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
    <img src="https://live.staticflickr.com/7804/40575279223_c7e5c0f743_o_d.jpg" data-canonical-src="https://live.staticflickr.com/7804/40575279223_c7e5c0f743_o_d.jpg" width="900" height="498" />
