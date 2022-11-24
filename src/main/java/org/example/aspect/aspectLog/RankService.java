package org.example.aspect.aspectLog;

import org.springframework.stereotype.Service;

/**
 * @author walker
 * @since 2022/11/21 21:26
 */
@Service
public class RankService {

    @RecordLog(desc = "save", convert = SaveRankConvert.class)
    public void saveRank(SaveRank saveRank) {
        System.out.println("save rank, id:" + saveRank.getId());
    }

    @RecordLog(desc = "update", convert =  UpdateRankConvert.class)
    public void updateRank(UpdateRank updateRank) {
        System.out.println("update rank, rankId:" + updateRank.getRankId());
    }
}
