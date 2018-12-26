## ServletResponse
javax.servlet.ServletResponse接口表示一个Servlet响应。在调用Servlet的Service方法前，Servlet容器首先创建一个ServletResponse，并将它作为第二个参数传给Service方法。ServletResponse隐藏了向浏览器发送响应的复杂过程。  

在ServletResponse中定义的方法之一是getWriter方法，它返回了一个可以向客户端发送文本的java.io.PrintWriter。默认情况下，PrintWriter对象使用ISO-8859-1编码。  

注意  
还有一个方法可以用来向浏览器发送输出，它就是getOutputStream。但这个方法是用于发送二进制数据的，因此，大多数情况使用的是getWriter，而不是getOutputStream。  

在发送任何HTML标签前，应该先调用setContentType方法，设置响应的内容类型，并将“text/html”作为一个参数传入。这是在告诉浏览器，内容类型为HTML。在没有内容类型的情况下，大多数浏览器会默认将响应渲染成HTML。
