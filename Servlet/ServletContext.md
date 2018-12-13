## ServletContext
ServletContext表示Servlet应用程序。每个Web应用程序只有一个上下文。在将一个应用程序同时部署到多个容器的分布式环境中，每台Java虚拟机上的Web应用都会有一个ServletContext对象。  
通过在ServletConfig中调用getServletContext方法，可以获得ServletContext。  

有了ServletContext，就可以共享从应用程序中的所有资料处访问到的信息。对象保存在ServletContext中的一个内部Map中。保存在ServletContext中的对象被称作属性。  
ServletContext中的下列方法负责处理属性：
```java
public Object getAttribute(String name);
public void setAttribute(String name, Object object);
public void removeAttribute(String name);
```