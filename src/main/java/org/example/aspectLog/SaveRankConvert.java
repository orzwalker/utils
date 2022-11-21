package org.example.aspectLog;

/**
 * @author walker
 * @since 2022/11/21 21:38
 */
public class SaveRankConvert extends AbstractConvert<SaveRank>{

    @Override
    Long getRankId(SaveRank param) {
        return param.getId();
    }
}
