package com.h2t.study.dto;

import java.util.Map;

/**
 * 分页对象
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/13 10:59
 */
public class FilePage {
    /**
     * 文件总大小，单位为byte
     */
    private Long fileSize;

    /**
     * 分页结果
     * key -> 分页页码
     * value -> 分页内容
     */
    private Map<Integer, String> pageResult;

    /**
     * 可以分页的数量
     */
    private Long pages;

    //getter and setter
    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Map<Integer, String> getPageResult() {
        return pageResult;
    }

    public void setPageResult(Map<Integer, String> pageResult) {
        this.pageResult = pageResult;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }
}
