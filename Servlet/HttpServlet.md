### HttpServlet

HttpServlet类覆盖了javax.servlet.GenericServlet类。使用HttpServlet时，还要借助分别代表Servlet请求和Servlet响应的HttpServletRequest和HttpServletResponse对象。HttpServletRequest接口扩展javax.servlet.ServletRequest，HttpServletResponse扩展javax.servlet.ServletResponse。  

HttpServlet覆盖GenericServlet中的Service方法，并通过下列签名再添加一个Service方法：
```java
protected void service(HttpServletRequest req, HttpServletResponse resp)
throws ServletException, IOException
```
新Service方法和javax.servlet.Servlet中Service方法之间的区别在于，前者接受HttpServletRequest和HttpServletResponse，而不是ServletRequest和ServletResponse。  
像往常一样，Servlet容器调用javax.servlet.Servlet中原始的Service方法。HttpServlet中的编写方法如下：
```java
    @Override
    public void service(ServletRequest req, ServletResponse res)
        throws ServletException, IOException {

        HttpServletRequest  request;
        HttpServletResponse response;

        try {
            request = (HttpServletRequest) req;
            response = (HttpServletResponse) res;
        } catch (ClassCastException e) {
            throw new ServletException("non-HTTP request or response");
        }
        service(request, response);
    }
```

原始的Service方法将Servlet容器的request和response对象分别转换成HttpServletRequest和HttpServletResponse，并调用新的Service方法。这种转换总是会成功的，因为在调用Servlet的Service方法时，Servlet容器总会传入一个HttpServletRequest和一个HttpServletResponse，预备使用HTTP。即便正在实现javax.servlet.Servlet，或者扩展javax.servlet.GenericServlet，也可以将传给Service方法的servlet request和servlet response分别转换成HttpServletRequest和HttpServletResponse。  

然后，HttpServlet中的Service方法会检验用来发送请求的HTTP方法（通过调用request.getMethod），并调用以下方法之一：doGet、doPost、doHead、doPut、doTrace、doOptions和doDelete。这7种方法中，每一种方法都表示一个HTTP方法。doGet和doPost是最常用的。因此，不再需要覆盖Service方法了，只要覆盖doGet或者doPost，或者覆盖doGet和doPost即可。


