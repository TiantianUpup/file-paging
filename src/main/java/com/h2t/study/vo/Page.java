package com.h2t.study.vo;

/**
 * 分页前端展示类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/13 11:48
 */
public class Page {
    /**
     * 文件总大小，单位为byte
     */
    private Long fileSize;

    /**
     * 文件内容
     */
    private String content;

    /**
     * 可以分页的数量
     */
    private Long pages;

    /**
     * 当前分页页码
     */
    private Integer pageNo;

    /**
     * 每页分页的大小
     */
    private Integer pageSize = 10;

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
