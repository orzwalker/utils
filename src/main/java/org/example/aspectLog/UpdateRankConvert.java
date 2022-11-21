package org.example.aspectLog;

/**
 * @author walker
 * @since 2022/11/21 21:38
 */
public class UpdateRankConvert implements Convert<UpdateRank>{
    @Override
    public OperateLogDO convert(UpdateRank param) {
        OperateLogDO operateLogDO = new OperateLogDO();
        operateLogDO.setRankId(param.getRankId());
        return operateLogDO;
    }
}
