## Cookies
Cookies是一个很少的信息片段，可自动地在浏览器和Web服务器间交互，因此cookies可存储在多个页面间传递的信息。Cookie作为HTTP header的一部分，其传输由HTTP协议控制。此外，你可以控制cookies的有效时间。浏览器通常支持每个网站高达20个cookies。  

Cookies的问题在于用户可以通过改变其浏览器设置来拒绝接受cookies。  

可以通过传递name和value两个参数给Cookie 类的构造函数来创建一个cookies：
```java
Cookie cookie = new Cookie(name, value);
```
要将cookie发送到浏览器，需要调用HttpServletResponse的add方法：
```java
httpServletResponse.addCookie(cookie);
```
浏览器在访问同一Web服务器时，会将之前收到的cookie一并发送。  

服务端若要读取浏览器提交的cookie，可以通过HttpServletRequest接口的getCookies方法，该方法返回一个Cookie数组，若没有cookies则返回null。你需要遍历整个数组来查询某个特定名称的cookie。  

目前，还没有一个直接的方法来删除一个cookie，你只能创建一个同名的cookie，并将maxAge属性设置为0，并添加到HttpServletResponse接口中。如下为删除一个名为userName的cookie代码：
```java
Cookie cookie = new Cookie("userName", "");
cookie.setMaxAge(0);
response.addCookie(cookie);
```
maxAge属性决定cookie何时过期。