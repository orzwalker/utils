package org.example.aspectLog;

/**
 * @author walker
 * @since 2022/11/21 21:38
 */
public interface Convert<T> {

    OperateLogDO convert(T param);
}
