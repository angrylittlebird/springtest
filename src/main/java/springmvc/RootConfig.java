package springmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author: ZHANG
 * @Date: 2020/1/6
 * @Description:
 */
@Configuration
@ComponentScan(value = "springmvc",
        excludeFilters = {@ComponentScan.Filter(type=FilterType.ANNOTATION,value = EnableWebMvc.class)})
public class RootConfig {
}
