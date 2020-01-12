package config.condition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

/**
 * @Author: ZHANG
 * @Date: 2020/1/4
 * @Description:
 */
public class ConditionDemo implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //适用于当前bean只有当另外某个特定的bean也声明了之后才会创建
        BeanDefinitionRegistry registry = context.getRegistry();
        System.out.println("isRegistry:" + registry.containsBeanDefinition("myDataSource"));

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        BeanDefinition datasource = beanFactory.getBeanDefinition("myDataSource");
        Objects.nonNull(datasource);
        System.out.println("isPrototype:" + datasource.isPrototype());
        System.out.println("isSingleton:" + datasource.isSingleton());
        System.out.println("isLazyInit:" + datasource.isLazyInit());
        System.out.println("scope:" + datasource.getScope());
        System.out.println("beanClassName:" + datasource.getBeanClassName());
        System.out.println(datasource.getPropertyValues());

        //判断当前对象是否包含某注解
        boolean conditional = metadata.isAnnotated(Bean.class.getName());
        System.out.println("当前Bean对象是否包含某注解:" + conditional);

        return true;
    }
}
