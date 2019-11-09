package pers.jiangyinzuo.learn.test;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.jiangyinzuo.learn.config.SpringConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * 测试QueryRunner是否为多例
 */
public class QueryRunnerTest {
    @Test
    public void testQueryRunner() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner queryRunner = (QueryRunner) applicationContext.getBean("queryRunner");
        QueryRunner queryRunner1 = (QueryRunner) applicationContext.getBean("queryRunner");
        assertNotEquals(queryRunner, queryRunner1);
    }
}
