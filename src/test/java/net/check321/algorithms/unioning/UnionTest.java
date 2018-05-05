package net.check321.algorithms.unioning;

import net.check321.algorithms.annotations.Profiler;
import net.check321.algorithms.union.UnionFind;
import net.check321.algorithms.union.Unionable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnionTest {
    @Test
    @Profiler
    public void searchTest() {
        int n = 1000;
        Unionable unionaFind = new UnionFind(n);

        // 随机union
        for (int i = 0; i < n; i ++){
            int p = (int) (Math.random() * n);
            int q = (int) (Math.random() * n);

            unionaFind.union(p,q);
        }

        // 随机选取元素 判断是否属于并集
        for (int i = 0; i < n; i++) {
            int p = (int) (Math.random() * n);
            int q = (int) (Math.random() * n);

            unionaFind.isConnected(p,q);
        }
    }

}
