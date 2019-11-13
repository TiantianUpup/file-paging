package com.h2t.study.service;

import com.h2t.study.vo.Page;

/**
 * 文件分页业务层
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/13 11:47
 */
public interface FilePageService {
    /**
     * 文件分页
     *
     * @param filePath 文件路径
     * @param pageNo   当前页数
     * @return Page 分页对象
     */
    Page filePage(String filePath, Integer pageNo);
}
