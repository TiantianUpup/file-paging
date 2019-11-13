package com.h2t.study;

import com.h2t.study.dto.FilePage;
import com.h2t.study.util.FilePageUtil;

import java.io.IOException;
import java.util.Map;

/**
 * FilePage测试类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/13 11:38
 */
public class FilePageTest {
    public static void main(String[] args) throws IOException {
        FilePage filePage = FilePageUtil.page("data.txt");
        System.out.println("总页数：" + filePage.getPages());
        System.out.println("分页总大小：" + filePage.getFileSize());
        Map<Integer, String> result = filePage.getPageResult();

        for (Map.Entry<Integer, String> entry : result.entrySet()) {
            System.out.println("No: " + entry.getKey() + " Content: " + entry.getValue());
        }
    }
}
