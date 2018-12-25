### HttpServletRequest
HttpServletRequest表示HTTP环境中的Servlet请求。它扩展javax.servlet.ServletRequest接口，并添加了几个方法。新增的部分方法如下：
```java
public Cookie[] getCookies();
```
返回一个Cookie对象数组。
```java
public String getMethod();
```
返回生成这个请求的HTTP方法名称。
```java
public HttpSession getSession();
```
返回与这个请求相关的会话对象。如果没有，将创建一个新的会话对象。
```java
public HttpSession getSession(boolean create);
```
返回与这个请求相关的会话对象。如果有，并且create参数为True，将创建一个新的会话对象。
```java
public String getHeader(String name);
```
返回指定HTTP标题的值。