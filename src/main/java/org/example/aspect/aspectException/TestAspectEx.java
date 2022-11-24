package org.example.aspect.aspectException;

import org.example.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author walker
 * @since 2022/11/24 18:53
 */
public class TestAspectEx {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        SomeService bean = context.getBean(SomeService.class);
        bean.test();
    }
}
