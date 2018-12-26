### HttpServletResponse
HttpServletResponse表示HTTP环境中的Servlet响应。下面是它里面定义的部分方法：
```java
public void addCookie(Cookie cookie);
```
给这个响应对象添加一个cookie。
```java
public void addHeader(String name, String value);
```
给这个响应对象添加一个header。