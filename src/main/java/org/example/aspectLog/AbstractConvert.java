package org.example.aspectLog;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author walker
 * @since 2022/11/21 23:54
 */
public abstract class AbstractConvert<T> implements Convert<T> {

    @Override
    public OperateLogDO convert(T param) {
        return new OperateLogDO((long) RandomUtils.nextInt(), getRankId(param));
    }

    abstract Long getRankId(T param);
}
