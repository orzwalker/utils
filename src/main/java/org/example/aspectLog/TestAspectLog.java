package org.example.aspectLog;

import org.example.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author walker
 * @since 2022/11/21 22:05
 */
public class TestAspectLog {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        RankService bean = context.getBean(RankService.class);
        SaveRank saveRank = new SaveRank();
        saveRank.setId(1L);
        bean.saveRank(saveRank);
        UpdateRank updateRank = new UpdateRank();
        updateRank.setRankId(2L);
        bean.updateRank(updateRank);
    }
}
