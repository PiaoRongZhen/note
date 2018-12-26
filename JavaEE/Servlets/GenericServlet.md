## GenericServlet

本着尽可能使代码简单的原则， GenericServlet实现了Servlet和ServletConfig接口，并完成以下任务：
* 将init方法中的ServletConfig赋给一个类级变量，以便可以通过调用getServletConfig获取。
* 为Servlet接口中的所有方法提供默认的实现。
* 提供方法，包围ServletConfig中的方法。
```java
public abstract class GenericServlet implements Servlet, ServletConfig, java.io.Serializable
```
GenericServlet通过将ServletConfig赋给init方法中的类级变量config，来保存ServletConfig。下面就是GenericServlet中的init实现：
```java
public void init(ServletConfig config) throws ServletException {
    this.config = config;
    this.init();
}
```
但是，如果在类中覆盖了这个方法，就会调用Servlet中的init方法，并且还必须调用super.init(config)来保存ServletConfig。为了避免上述麻烦，GenericServlet提供了第二个init方法，它不带参数。这个方法是在ServletConfig被赋给config后，由第一个init方法调用。  
这意味着，可以通过覆盖没有参数的init方法来编写初始化代码，ServletConfig则仍然由GenericServlet实例保存。
