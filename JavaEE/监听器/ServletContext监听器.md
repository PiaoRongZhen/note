## ServletContext监听器
ServletContext的监听器接口有两个：ServletContextListener和ServletContextAttributeListener。
### ServletContextListener
ServletContextListener能对ServletContext的创建和销毁做出响应。当ServletContext初始化时，容器会调用所有注册的ServletContextListeners的contextInitialized方法。该方法如下：
```java
void contextInitialized(ServletContextEvent event)
```
当ServletContext将要销毁时，容器会调用所有注册的ServletContextListeners的contextDestroyed方法。该方法如下：
```java
void contextDestroyed(ServletContextEvent event)
```
contextInitialized方法和contextDestroyed方法都会从容器获取到一个ServletContextEvent。javax.servlet.ServletContextEvent是一个java.util.EventObject的子类，它定义了一个访问ServletContext的getServletContext方法：
```java
ServletContext getServletContext()
```
通过这个方法能够轻松地获取到ServletContext。
### ServletContextAttributeListener
当一个ServletContext范围的属性被添加、删除或者替换时，ServletContextAttributeListener接口的实现类会接收到消息。这个接口定义了如下三个方法：
```java
void attributeAdded(ServletContextAttributeEvent event)
void attributeRemoved(ServletContextAttributeEvent event)
void attributeReplaced(ServletContextAttributeEvent event)
```
attributeAdded方法在一个ServletContext范围属性被添加时被容器调用。attributeRemoved方法在一个ServletContext范围属性被删除时被容器调用。而attributeReplaced方法在一个ServletContext范围属性被新的替换时被容器调用。  
这三个方法都能获取到一个ServletContextAttributeEvent的对象，通过这个对象可以获取属性的名称和值。  
ServletContextAttributeEvent类继承自ServletContextAttribute，并且增加了下面两个方法分别用于获取该属性的名称和值：

```java
String getName()
Object getValue()
```
