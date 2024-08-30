package com.example.runnersApp.repository;

import com.example.runnersApp.model.Content;
import com.example.runnersApp.model.Status;
import com.example.runnersApp.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }
    public Page<Content> findAll(Pageable pageable) {
        // Determine the start and end index for pagination
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), contentList.size());

        // Extract the sublist for the current page
        List<Content> paginatedList = contentList.subList(start, end);

        // Create and return a PageImpl object
        return new PageImpl<>(paginatedList, pageable, contentList.size());
    }



    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }


    @PostConstruct
    private void init() {
        Content c = new Content(
                1,
                "My First Recipe",
                "This is the recipe description",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""

        );
        contentList.add(c);
    }

    public void save(Content content) {
        contentList.add(content);
    }

    public void update(Integer id, Content updatedContent) {
        Optional<Content> foundcontent = findById(id);


        if (foundcontent.isPresent()) {
            //get the found content
            Content existingContent = foundcontent.get();
            //remove existing content
            contentList.remove(existingContent);

            contentList.add(updatedContent);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
    }

    public void deleteById(Integer id) {
        Optional<Content> foundContent = findById(id);
        if (foundContent.isPresent()) {
            contentList.remove(foundContent.get());
        }
    }
}

