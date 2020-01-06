package springmvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

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
}
