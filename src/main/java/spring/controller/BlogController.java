package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.model.Blog;
import spring.request.BlogPageRequest;
import spring.request.GetBlogsByIndexRequest;
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

    @PostMapping("/blog")
    public List<Blog> getBlogsByIndex(@RequestBody GetBlogsByIndexRequest request) {
        String sqlCountRows = "SELECT count(*) FROM blog";
        String sqlFetchRows = "SELECT * FROM blog";
        BlogPageRequest blogPageRequest = new BlogPageRequest(sqlCountRows, sqlFetchRows, new Object[] {}, request.getPageSize(), request.getPageNo());
        List<Blog> blogs = blogService.find(blogPageRequest);
        return blogs;
    }

}
