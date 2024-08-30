package com.example.runnersApp.controller;
import com.example.runnersApp.model.Content;
import com.example.runnersApp.repository.ContentCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
@RequestMapping("/api/content")
public class ContentController {
    private final ContentCollectionRepository repository;

    @Autowired
    public ContentController(ContentCollectionRepository contentCollectionRepository  ) {
        this.repository = contentCollectionRepository;

    }
    @GetMapping("")
    public Iterable<Content> findAll(
            @RequestParam(value="pageNumber", defaultValue = "0",required = false) int pageNumber,
            @RequestParam(value="pageSize", defaultValue = "2",required = false) int pageSize
    ){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(pageable);
    }
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
            return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found"));
        };
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Content content) {
            repository.save(content);
    }
//the request was successful, but there is no content to send in the response body.
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Content content){
        repository.update(id,content);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
    }
