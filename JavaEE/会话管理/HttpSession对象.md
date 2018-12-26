## HttpSession对象
一个用户可以有且最多有一个HttpSession，并且不会被其他用户访问到。  
HttpSession对象在用户第一次访问网站的时候自动被创建，你可以通过调用HttpServletRequest的getSession方法获取该对象。getSession有两个重载方法：
```java
public HttpSession getSession();

public HttpSession getSession(boolean create);
```
没有参数的getSession方法会返回当前的HttpSession，若当前没有，则创建一个返回。getSession(false)返回当前HttpSession，如当前存在，则返回null。getSession(true)返回当前HttpSession，若当前没有，则创建一个getSession(true)同getSession()一致。  

可以通过HttpSession的setAttribute方法将值放入HttpSession，该方法签字如下：
```java
public void setAttribute(String name, Object value);
```
请注意，不同于cookie，放入到HttpSession 的值，是存储在内存中的，因此，不要往HttpSession放入太多对象或大对象。尽管现代的Servlet容器在内存不够用的时候会将保存在HttpSessions的对象转储到二级存储上，但这样有性能问题，因此小心存储。  

此外，放到HttpSession的值不限于String类型，可以是任意实现java.io.Serializable的java对象，因为Servlet容器认为必要时会将这些对象放入文件或数据库中，尤其在内存不够用的时候，当然你也可以将不支持序列化的对象放入HttpSession，只是这样，当Servlet容器视图序列化的时候会失败并报错。  

调用setAttribute方法时，若传入的name参数此前已经使用过，则会用新值覆盖旧值。  

通过调用HttpSession的getAttribute方法可以取回之前放入的对象，该方法的签名如下：
```java
public Object getAttribute(String name);
```
注意，所有保存在HttpSession的数据不会被发送到客户端，不同于其他会话管理技术，Servlet容器为每个HttpSession 生成唯一的标识，并将该标识发送给浏览器，或创建一个名为JSESSIONID的cookie，或者在URL后附加一个名为jsessionid 的参数。在后续的请求中，浏览器会将标识提交给服务端，这样服务器就可以识别该请求是由哪个用户发起的。Servlet容器会自动选择一种方式传递会话标识，无须开发人员介入。  

此外，HttpSession.还定义了一个名为invalidate 的方法。该方法强制会话过期，并清空其保存的对象。默认情况下，HttpSession 会在用户不活动一段时间后自动过期。  

可以通过调用HttpSession 的getMaxInactiveInterval方法来查看会话多久会过期。该方法返回一个数字类型，单位为秒。调用setMaxInactiveInterval 方法来单独对某个HttpSession 设定其超时时间：
```java
public void setMaxInactiveInterval(int interval);
```
若设置为0，则该HttpSession 永不过期。通常这不是一个好的设计，因此该 HttpSession 所占用的堆内存将永不释放，直到应用重加载或Servlet容器关闭。
