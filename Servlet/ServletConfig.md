## ServletConfig
当Servlet容器初始化Servlet时，Servlet容器会给Servlet的init方法传入一个ServletConfig。ServletConfig封装可以通过@WebServlet传给Servlet的配置信息。这样传入的每一条信息就叫一个初始参数。一个初始参数有key和value两个元件。  
为了从Servlet内部获取到初始参数的值，要在Servlet容器传给Servlet的init方法的ServletConfig中调用getInitParameter方法。getInitParameter的方法签名如下：
```java
public String getInitParameter(String name);
```
除getInitParameter和getInitParameterNames外，ServletConfig还提供了另一个很有用的方法：getServletContext。利用这个方法可以从Servlet内部获取ServletContext。
```java
package app;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ServletConfigDemoServlet",
    urlPatterns = { "/servletConfigDemo" },
    initParams = {
        @WebInitParam(name="admin", value="PiaoRongZhen"),
        @WebInitParam(name="email", value="piaorongzhen@qq.com")
    }
)
public class ServletConfigDemoServlet implements Servlet {
    private ServletConfig servletConfig;

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void init(ServletConfig servletConfig)
            throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        String admin = servletConfig.getInitParameter("admin");
        String email = servletConfig.getInitParameter("email");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><head></head><body>" +
                "Admin:" + admin +
                "<br/>Email:" + email +
                "</body></html>");
    }

    @Override
    public String getServletInfo() {
        return "ServletConfig demo";
    }
    
    @Override
    public void destroy() {
    }
}
```