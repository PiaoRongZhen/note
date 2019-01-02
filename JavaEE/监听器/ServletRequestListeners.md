# ServletRequest Listeners
## ServletRequestListener
ServletRequestListener监听器会对ServletRequest的创建和销毁事件进行响应。容器会通过一个池来存放并重复利用多个ServletRequest，ServletRequest的创建是从容器池里被分配出来的时刻开始，而它的销毁时刻是放回容器池里的时间。  
ServletRequestListener接口有两个方法，requestInitialized和requestDestroyed：
```java
void requestInitialized(ServletRequestEvent event)
void requestDestroyed(ServletRequestEvent event)
```
当一个ServletRequest创建（从容器池里取出）时，requestInitialized方法会被调用，当ServletRequest销毁（被容器回收）时，requestDestroyed方法会被调用。这两个方法都会接收一个ServletRequestEvent对象，可以通过使用这个对象的getServletRequest方法来获取ServletRequest对象：
```java
ServletRequest getServletRequest()
```
另外，ServletRequestEvent接口也提供了一个getServletContext方法来获取ServletContext，如下所示：
```java
ServletContext getServletContext()
```
## ServletRequestAttributeListener
当一个ServletRequest范围的属性被添加、删除或替换时，ServletRequestAttributeListener接口会被调用。ServletRequestAttributeListener接口提供了三个方法：attributeAdded、attributeReplaced和attributeRemoved。如下所示：
```java
void attributeAdded(ServletRequestAttributeEvent event)
void attributeRemoved(ServletRequestAttributeEvent event)
void attributeReplaced(ServletRequestAttributeEvent event)
```
这些方法都可以获得一个继承自ServletRequestEvent的ServletRequestAttributeEvent对象。通过ServletRequestAttributeEvent类提供的getName和getValue方法可以访问到属性的名称和值：
```java
String getName()
Object getValue()
```

