package org.example.aspect.aspectException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author walker
 * @since 2022/11/24 17:09
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 1、切点
     * 2、切面
     * 3、织入
     */

    @Pointcut("@annotation(org.example.aspect.aspectException.AnnotationLog)")
    public void pointcut() {
    }


    /**
     * 环绕通知记录日志可能存在的问题
     * 1、业务方法执行前的切面代码发生异常
     * 2、业务方法执行后的切面代码发生异常
     * 3、业务方法执行发生异常
     * <p>
     * 要求：
     * 1、如果是切面代码发生异常，记录日志即可
     * 2、业务方法执行发生异常，向上抛出异常
     * 3、切面代码异常不影响业务方法执行
     * <p>
     * 解决方案：
     * 让切面代码能感知到业务方法执行状态：
     * 是否抛出异常
     * 是否执行结束
     * 因此封装JoinPoint，创建实例执行业务方法，并获取执行状态
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object result;
        JoinPointProxy proxy = new JoinPointProxy(pjp);
        try {
            result = handler(proxy);
        } catch (Exception e) {
            if (proxy.getExecuted()) {
                // 业务方法执行异常
                Exception exception = proxy.getException();
                if (null != exception) {
                    throw exception;
                }
            }

            // 切面代码异常，但不知道是业务方法前/后异常
            System.out.println("切面代码异常 " + e.getMessage());
            e.printStackTrace();

            if (proxy.getExecuted()) {
                // 业务方法后切面代码异常
                // 但是业务方法执行成功了，所以放行
                System.out.println("业务方法后切面代码异常");
                return proxy.getResult();
            } else {
                // 业务方法前切面代码异常
                // 业务方法还没有执行，调用一次
                System.out.println("业务方法前切面代码异常");
                result = proxy.proceed();
            }
        }

        return result;
    }


    private Object handler(JoinPointProxy proxy) throws Throwable {
        Object result;
        int i = 0;

        // 1.业务方法前的切面代码异常
        i = 1 / 0;

        // 2.业务方法
        result = proxy.proceed();

        // 3.业务方法后的切面代码异常
        i = i / 0;

        return result;
    }

}

class JoinPointProxy {

    private final ProceedingJoinPoint joinPoint;
    /**
     * 是否执行了业务方法
     */
    private Boolean isExecuted;
    /**
     * 执行过程中的异常信息
     */
    private Exception exception;
    /**
     * 执行结果
     */
    private Object result;

    public JoinPointProxy(ProceedingJoinPoint joinPoint) {
        this.joinPoint = joinPoint;
        this.isExecuted = false;
    }

    public Object proceed() throws Throwable {
        if (!this.getExecuted()) {
            try {
                this.result = this.joinPoint.proceed();
            } catch (Exception e) {
                this.exception = e;
                throw e;
            } finally {
                this.isExecuted = true;
            }
        }
        return this.result;
    }


    public Boolean getExecuted() {
        return isExecuted;
    }

    public Exception getException() {
        return exception;
    }

    public Object getResult() {
        return result;
    }

}
