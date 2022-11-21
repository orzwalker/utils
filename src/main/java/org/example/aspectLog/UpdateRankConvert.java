package org.example.aspectLog;

/**
 * @author walker
 * @since 2022/11/21 21:38
 */
public class UpdateRankConvert extends AbstractConvert<UpdateRank>{

    @Override
    Long getRankId(UpdateRank param) {
        return param.getRankId();
    }
}
