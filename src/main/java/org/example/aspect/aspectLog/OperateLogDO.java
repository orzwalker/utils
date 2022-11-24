package org.example.aspect.aspectLog;

/**
 * @author walker
 * @since 2022/11/21 21:29
 */
public class OperateLogDO {

    private Long id;
    private String desc;
    private Long rankId;

    public OperateLogDO(Long id, Long rankId) {
        this.id = id;
        this.rankId = rankId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", rankId=" + rankId +
                '}';
    }
}
