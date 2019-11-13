package com.h2t.study.service.impl;

import com.h2t.study.dto.FilePage;
import com.h2t.study.service.FilePageService;
import com.h2t.study.util.FilePageUtil;
import com.h2t.study.vo.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 件分页业务层实现类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/13 11:52
 */
@Service
public class FilePageServiceImpl implements FilePageService {
    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 缓存文件分页结果
     * key -> 文件路径
     * value -> 分页结果对象
     */
    private Map<String, FilePage> cache = new HashMap<>();

    /**
     * 文件分页
     *
     * @param filePath 文件路径
     * @param pageNo   当前页数
     * @return Page 分页对象
     */
    @Override
    public Page filePage(String filePath, Integer pageNo) {
        if (cache.get(filePath) == null) {
            try {
                cache.put(filePath, FilePageUtil.page(filePath));
            } catch (IOException e) {
                logger.error("IO异常，e:{}", e.getCause());
                e.printStackTrace();
            }
        }
        FilePage filePage = cache.get(filePath);
        Page page = new Page();
        page.setFileSize(filePage.getFileSize());
        page.setPageNo(pageNo);
        if (filePage.getPageResult().get(pageNo) == null) {
            logger.info("当前页码内容不存在，pageNo:{}", pageNo);
        }
        page.setContent(filePage.getPageResult().get(pageNo));
        page.setPages(filePage.getPages());
        return page;
    }
}
