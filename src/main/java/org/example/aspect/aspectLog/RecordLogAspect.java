package org.example.aspect.aspectLog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author walker
 * @since 2022/11/21 21:31
 */
@Component
@Aspect
public class RecordLogAspect {

    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            1,
            1,
            1,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(100));


    @Pointcut("@annotation(org.example.aspect.aspectLog.RecordLog)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 先执行业务逻辑
        Object proceed = pjp.proceed();

        // 业务逻辑执行成功后，才记录日志
        // 无法保证严格一致性，需要考虑MQ等
        threadPoolExecutor.execute(() -> {
            try {
                MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
                RecordLog annotation = methodSignature.getMethod().getAnnotation(RecordLog.class);
                Class<? extends Convert> convert = annotation.convert();
                Convert instance = convert.newInstance();
                // 只处理第一个参数
                OperateLogDO domain = instance.convert(pjp.getArgs()[0]);
                domain.setDesc(annotation.desc());

                // 保存日志
                System.out.println(domain);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        return proceed;
    }
}
