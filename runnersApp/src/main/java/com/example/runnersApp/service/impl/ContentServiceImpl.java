package com.example.runnersApp.service.impl;

import com.example.runnersApp.model.Content;
import com.example.runnersApp.model.Status;
import com.example.runnersApp.model.Type;
import com.example.runnersApp.repository.ContentRepo;
import com.example.runnersApp.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentRepo contentRepo;

    @Override
    public Content addContent(Content content) {
        return contentRepo.save(content);
    }

    @Override
    public Content updateContent(Content content) {
        return contentRepo.save(content);
    }

    @Override
    public void deleteContent(Integer contentId) {
        contentRepo.deleteById(contentId);
    }

    @Override
    public Page<Content> getAllContent(Pageable pageable) {
        return contentRepo.findAll(pageable);
    }

    @Override
    public List<Content> getContentByUser(Integer userId) {
        return contentRepo.findByUserId(userId);
    }

    @Override
    public long getNumberOfContentsByTypeByUser(Integer userId, Type type) {
        return contentRepo.countByUserIdAndContentType(userId, type);
    }

    @Override
    public long getNumberOfContentsByStatus(Status status) {
        return contentRepo.countByStatus(status);
    }

}