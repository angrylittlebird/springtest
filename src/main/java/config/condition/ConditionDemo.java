package config.condition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
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
        BeanDefinitionRegistry registry = context.getRegistry();
        System.out.println(registry.containsBeanDefinition("myDataSource"));
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        BeanDefinition datasource = beanFactory.getBeanDefinition("myDataSource");
        Objects.nonNull(datasource);
        System.out.println("isPrototype:" + datasource.isPrototype());
        System.out.println("isSingleton:" + datasource.isSingleton());
        System.out.println("isLazyInit:" + datasource.isLazyInit());
        System.out.println("scope:" + datasource.getScope());
        System.out.println("beanClassName:" + datasource.getBeanClassName());
        System.out.println(datasource.getPropertyValues());

        //todo don't know why...
        boolean conditional = metadata.isAnnotated("@Sweet");
        System.out.println(conditional);

        return true;
    }
}
