package com.h2t.study.controller;

import com.h2t.study.service.FilePageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO Description
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/13 12:05
 */
@RestController
public class FilePageController {
    @Resource
    private FilePageService filePageService;

    @GetMapping("/file/page/{filePath}")
    public Object page(@PathVariable("filePath") String filePath,
                       @RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo) {
        return filePageService.filePage(filePath, pageNo);
    }
}
