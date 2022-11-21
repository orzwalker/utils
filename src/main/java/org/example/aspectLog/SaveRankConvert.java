package org.example.aspectLog;

/**
 * @author walker
 * @since 2022/11/21 21:38
 */
public class SaveRankConvert implements Convert<SaveRank>{
    @Override
    public OperateLogDO convert(SaveRank param) {
        OperateLogDO operateLogDO = new OperateLogDO();
        operateLogDO.setRankId(param.getId());
        return operateLogDO;
    }
}
