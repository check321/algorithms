package net.check321.algorithms.sorting;

import net.check321.algorithms.sorting.common.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseSortable {

    @Autowired
    protected CommonUtils commonUtils;

    /**
     * 在给定范围内返回随机数
     *
     * @param l
     * @param r
     * @return 范围内随机数
     */
    protected int randomInRange(int l, int r) {
        return (int)(Math.random() * (r - l + 1)) + l;
    }
}
