# Session Listeners
一共有四个HttpSession相关的监听器接口：HttpSessionListener、HttpSessionActivationListener、HttpSessionAttributeListener和HttpSessionBindingListener。这四个接口都在javax.servlet.http包中。
## HttpSessionListener
当一个HttpSession创建或者销毁时，容器都会通知所有的HttpSessionListener监听器，HttpSessionListener接口有两个方法：sessionCreated和sessionDestroyed：
```java
void sessionCreated(HttpSessionEvent event)
void sessionDestroyed(HttpSessionEvent event)
```
这两个方法都可以接收到一个继承于java.util.Event的HttpSessionEvent对象。可以通过调用HttpSessionEvent对象的getSession方法来获取当前的HttpSession。getSession方法如下：
```java
HttpSession getSession()
```
sessionCreated方法在每个HttpSession创建时被调用。  
sessionDestroyed方法会在HttpSession销毁之前被调用。
## HttpSessionAttributeListener
HttpSessionAttributeListener接口和ServletContextAttributeListener类似，它响应的是HttpSession范围属性的添加、删除和替换。
HttpSessionAttributeListener接口有以下方法：
```java
void attributeAdded(HttpSessionBindingEvent event)
void attributeRemoved( HttpSessionBindingEvent event)
void attributeReplaced( HttpSessionBindingEvent event)
```
attributeAdded方法在一个HttpSession范围属性被添加时被容器调用。attributeRemoved方法在一个HttpSession范围属性被删除时被容器调用。而attributeReplaced方法在一个HttpSession范围属性被新的替换时被容器调用。  
这三个方法都能获取到一个HttpSessionBindingEvent的对象，通过这个对象可以获取属性的名称和值：
```java
String getName()
Object getValue()
```
## HttpSessionActivationListener
Objects that are bound to a session may listen to container events notifying them that sessions will be passivated and that session will be activated.  
在分布式环境下，会用多个容器来进行负载均衡，有可能需要将session保存起来，在容器之间传递。例如当一个容器内存不足时，会把很少用到的对象转存到其他容器上。这时候，容器就会通知所有HttpSessionActivationListener 接口的实现类。  
HttpSessionActivationListener接口有两个方法，sessionDidActivate和sessionWillPassivate：
```java
void sessionDidActivate(HttpSessionEvent event)
void sessionWillPassivate(HttpSessionEvent event)
```
当HttpSession被转移到其他容器之后，sessionDidActivate方法会被调用。容器将一个HttpSessionEvent方法传递到方法里，可以从这个对象获得HttpSession。  
当一个HttpSession将要失效时，容器会调用sessionWillPassivate方法。和sessionDidActivate方法一样，容器将一个HttpSessionEvent方法传递到方法里，可以从这个对象获得HttpSession。
## HttpSessionBindingListener
Causes an object to be notified when it is bound to or unbound from a session.
当有属性绑定或者解绑到HttpSession上时，HttpSessionBindingListener监听器会被调用。如果对HttpSession属性的绑定和解绑动作感兴趣，就可以实现HttpSessionBindingListener来监听。例如可以在HttpSession属性绑定时更新状态，或者在属性解绑时释放资源。


