import initializer.MyFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * @Author: ZHANG
 * @Date: 2020/1/5
 * @Description:    pdf 179
 *
 * 当DispatcherServlet启动的时候，它会创建Spring应用上下文，并加载配置文件或配置类中所声明的bean。
 */
public class SpittrWenAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        //将DispatchServlet映射到"/",这表示它会是应用的默认Servlet。它会处理进入应用的所有请求。
        return new String[]{"/"};
    }

    //  将DispatcherServlet注册到Servlet容器中之后，就会调用customizeRegistration()，
    // 并将Servlet注册后得到的 Registration.Dynamic传递进来。通过重载customizeRegistration()方法，
    // 我们可以对 DispatcherServlet进行额外的配置。
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //启用multipart请求,将上传文件的临时存储目录设置在“/tmp/spittr/uploads”中。
        registration.setMultipartConfig(new MultipartConfigElement("tmp/spittr/uploads"));
    }

    //仅仅为了注册Filter并将其映射到DispatcherServlet
    //getServletFilters()方法返回的所有Filter都会映射到DispatcherServlet上。
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new MyFilter()};
    }
}
