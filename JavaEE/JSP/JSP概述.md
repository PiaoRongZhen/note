# JSP概述
JSP页面本质上是一个Servlet。然而，用JSP页面开发比使用Servlet更容易，主要有两个原因。首先，不必编译JSP页面；其次，JSP页面是一个以.jsp为扩展名的文本文件，可以使用任何文本编辑器来编写它们。  
JSP页面在JSP容器中运行，一个Servlet容器通常也是JSP容器。例如，Tomcat就是一个Servlet/JSP容器。  
当一个JSP页面第一次被请求时，Servlet/JSP容器主要做以下两件事情：
1. 转换JSP页面到JSP页面实现类，该实现类是一个实现javax.servlet.jsp.JspPage接口或子接口javax.servlet.jsp.HttpJspPage的Java类。JspPage是javax.servlet.Servlet的子接口，这使得每一个JSP页面都是一个Servlet。该实现类的类名由Servlet/JSP容器生成。如果出现转换错误，则相关错误信息将被发送到客户端。
2. 如果转换成功，Servlet/JSP容器随后编译该Servlet类，并装载和实例化该类，像其他正常的Servlet一样执行生命周期操作。

对于同一个JSP页面的后续请求，Servlet/JSP容器会先检查JSP页面是否被修改过。如果是，则该JSP页面会被重新翻译、编译并执行。如果不是，则执行已经在内存中的JSP Servlet。这样一来，一个JSP页面的第一次调用的实际花费总比后来的花费多，因为它涉及翻译和编译。

JSP页面可以包含模板数据和语法元素。这里，语法元素是一些具有特殊意义的JSP转换符。例如，“<%”是一个元素，因为它表示在JSP页面中的Java代码块的开始。“%>”也是一个元素，因为它是Java代码块的结束符。除去语法元素外的一切是模板数据。模板数据会原样发送给浏览器。例如，JSP页面中的HTML标记和文字都是模板数据。

一个JSP页面不同于一个Servlet的另一个方面是，前者不需要添加注解或在部署描述符中配置映射URL。在应用程序目录中的每一个JSP页面可以直接在浏览器中输入路径页面访问。  
todaysDate.jsp
```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<html>
<head><title>Today's date</title></head>
<body>
<%
  DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
  String s = dateFormat.format(new Date());
  out.println("Today is " + s);
%>
</body>
</html>
```
todaysDate.jsp页面发送了几个HTML标签和字符串“今天是”以及今天的日期到浏览器。  
添加新的JSP界面后，无须重启Tomcat。  
请注意两件事情。首先，Java代码可以出现在JSP页面中的任何位置，并通过”<%“和”%>“包括起来。其次，可以使用page指令的import属性导入在JSP页面中使用的Java类型，如果没有导入的类型，必须在代码中写Java类的全路径名称。
