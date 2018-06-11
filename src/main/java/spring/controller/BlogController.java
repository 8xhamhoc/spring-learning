package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.model.Blog;
import spring.service.BlogService;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blog/{id}")
    public Blog queryById(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        return blogService.findById(blogId);
    }

    @GetMapping("/blog")
    public List<Blog> getBlogs() {
        return blogService.findAll();
    }


}
