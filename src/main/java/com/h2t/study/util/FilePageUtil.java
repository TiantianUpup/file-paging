package com.h2t.study.util;

import com.h2t.study.dto.FilePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件分页工具类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/13 11:03
 */
public class FilePageUtil {
    /**
     * 读取的字节大小
     */
    private static final int BYTE_SIZE = 10;
    private static Logger logger = LoggerFactory.getLogger(FilePageUtil.class);

    /**
     * 分页
     *
     * @param filePath 文件路径
     * @return
     */
    public static FilePage page(String filePath) throws IOException {
        File file = new File(filePath);
        //该流读取是为了判断读取指定内容大小是否出现乱码
        FileInputStream judgeFis = null;
        //该流根据是否出现乱码读取文件，出现乱码读取字节数-3，不出现乱码读取指定字节数
        FileInputStream readFis = null;

        try {
            judgeFis = new FileInputStream(file);
            readFis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            logger.error("找不到指定文件，文件路径:{}", filePath);
            e.printStackTrace();
        }

        int judgeLength;
        int pageSize = 1;
        Map<Integer, String> pageResult = new HashMap<>();
        byte[] judgeBuffer;
        int size = BYTE_SIZE;
        while ((judgeBuffer = allocateByte(size)).length > 0 && (judgeLength = judgeFis.read(judgeBuffer)) != -1) {
            int readLength;
            String pageContent;
            String str = new String(new String(judgeBuffer, 0, judgeLength));
            //获取读取到文件的字节数
            byte[] bytes = str.getBytes();
            //末尾是中文出现乱码
            if (bytes[bytes.length - 1] < 0) {
                size = BYTE_SIZE - 3;
                byte[] readBuffer = new byte[BYTE_SIZE - 3];
                readLength = readFis.read(readBuffer);
                pageContent = new String(readBuffer, 0, readLength);
            } else {
                //未出现乱码不需要-3
                byte[] bytes1 = new byte[BYTE_SIZE];
                size = BYTE_SIZE;
                readLength = readFis.read(bytes1);
                pageContent = new String(bytes1, 0, readLength);
            }

            pageResult.put(pageSize, pageContent);
            pageSize++;  //页数+1

        }

        FilePage filePage = new FilePage();
        long fileSize = file.length(); //总的文件大小，单位为kb
        //long pages = fileSize / BYTE_SIZE + 1;  //总的分页数量 【这样计算值不准确】
        filePage.setPageResult(pageResult);
        filePage.setFileSize(fileSize);
        filePage.setPages(Long.valueOf(pageSize - 1));
        return filePage;
    }

    /**
     * 动态分配缓冲区大小
     *
     * @param size 缓冲区大小
     * @return
     */
    private static byte[] allocateByte(int size) {
        return new byte[size];
    }
}
