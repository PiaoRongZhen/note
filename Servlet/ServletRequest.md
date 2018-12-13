## ServletRequest
对于每一个HTTP请求，Servlet容器都会创建一个ServletRequest实例，并将它传给Servlet的Service方法。ServletRequest封装了关于这个请求的信息。
```java
// 返回指定请求参数的值。
public String getParameter(String name)
```
getParameter是在ServletRequest中最常用的方法。该方法通常用于返回HTML表单域的值。  
getParameter也可以用于获取查询字符串的值。例如，利用下面的URI调用Servlet：  
http://domain/context/servletName?id=123  
用下面这个语句，可以通过Servlet内部获取id值：

```java
String id = request.getParameter("id");
```
