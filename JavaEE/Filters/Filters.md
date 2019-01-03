# Filters
Filter是拦截Request请求的对象：在用户的请求访问资源前处理ServletRequest以及ServletResponse。
## Filter API
Filter的实现必须继承javax.servlet.Filter接口。这个接口包含了Filter的3个生命周期：init、doFilter、destroy。  
Servlet容器初始化Filter时，会触发Filter的init方法，一般来说是在应用开始时。也就是说，init方法并不是在该Filter相关的资源使用到时才初始化的，而且这个方法只调用一次，用于初始化Filter。init方法的定义如下：
```java
void init(FilterConfig filterConfig)
```
当Servlet容器每次处理Filter相关的资源时，都会调用该Filter实例的doFilter方法。Filter的doFilter方法包含ServletRequest、ServletResponse、FilterChain这3个参数。  
doFilter的定义如下：
```java
void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
```
doFilter的实现中允许访问ServletRequet、ServletResponse。这也就意味着允许给ServletRequest增加属性或者增加Header。  
在Filter的doFilter的实现中，最后一行需要调用FilterChain中的doChain方法。注意Filter的doFilter方法里的第3个参数，就是filterChain的实例：

```java
filterChain.doFilter(request, response)
```
一个资源可能需要被多个Filter关联到（更专业一点来说，这应该叫作Filter链条），这时Filter.doFilter()的方法将触发Filter链条中下一个Filter。只有在Filter链条中最后一个Filter里调用的FilterChain.doFilter()，才会触发处理资源的方法。  
如果在Filter.doFilter()的实现中，没有在结尾处调用FilterChain.doFilter()的方法，那么该Request请求中止，后面的处理就会中断。  

Filter接口中，最后一个方法是destroy，它的定义如下：
```java
void destroy()
```
该方法在Servlet容器要销毁Filter时触发，一般在应用停止的时候进行调用。  
## Filter配置
当完成Filter的实现后，就可以开始配置Filter了。Filter的配置需要如下步骤：
* 确认哪些资源需要使用这个Filter拦截处理。
* 配置Filter的初始化参数值，这些参数可以在Filter的init方法中读取到。
* 给Filter取一个名称。

FilterConfig接口允许通过它的getServletContext的方法来访问ServletContext：
```java
ServletContext getServletContext()
```
如果配置了Filter的名字，在FilterConfig的getFilterName中就可以获取Filter的名字。getFilterName的定义如下：
```java
String getFilterName()
```
当然，最重要的还是要获取到开发者或者运维给Filter配置的初始化参数。
```java
String getInitParameter(String parameterName)
```
使用@WebFilter配置Filter。  
举个例子，下述@WebFilter标注配置了一个Filter，名称为DataCompressionFilter，且适用于所有资源：

```java
@WebFilter(filterName="DataCompressionFilter", urlPatterns={"/*"})
```






