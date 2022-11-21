package org.example.aspectLog;

/**
 * @author walker
 * @since 2022/11/21 21:29
 */
public class OperateLogDO {

    private String desc;
    private Long rankId;

    public OperateLogDO(Long rankId) {
        this.rankId = rankId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    @Override
    public String toString() {
        return "OperateLogDO{" +
                "desc='" + desc + '\'' +
                ", rankId=" + rankId +
                '}';
    }
}
