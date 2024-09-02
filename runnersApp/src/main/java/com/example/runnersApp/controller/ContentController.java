package com.example.runnersApp.controller;

import com.example.runnersApp.model.Content;
import com.example.runnersApp.model.Status;
import com.example.runnersApp.model.Type;
import com.example.runnersApp.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentService contentService;
    @PostMapping
    public Content addContent(@RequestBody Content content) {
        return contentService.addContent(content);
    }

    @PutMapping("/{id}")
    public Content updateContent(@PathVariable Integer id, @RequestBody Content content) {
        content.setId(id);
        return contentService.updateContent(content);
    }

    @DeleteMapping("/{id}")
    public void deleteContent(@PathVariable Integer id) {
        contentService.deleteContent(id);
    }

    @GetMapping
    public Page<Content> getAllContent(Pageable pageable) {
        return contentService.getAllContent(pageable);
    }

    @GetMapping("/user/{userId}")
    public List<Content> getContentByUser(@PathVariable Integer userId) {
        return contentService.getContentByUser(userId);
    }

    @GetMapping("/count/type")
    public long getNumberOfContentsByTypeByUser(@RequestParam Integer userId, @RequestParam String type) {
        return contentService.getNumberOfContentsByTypeByUser(userId, Type.valueOf(type.toUpperCase()));
    }

    @GetMapping("/count/status")
    public long getNumberOfContentsByStatus(@RequestParam String status) {
        return contentService.getNumberOfContentsByStatus(Status.valueOf(status.toUpperCase()));
    }
}
