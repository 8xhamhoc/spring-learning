package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.exception.BlogNotFoundException;
import spring.model.Blog;
import spring.request.BlogPageRequest;
import spring.request.BlogRequest;
import spring.request.GetBlogsByIndexRequest;
import spring.service.BlogService;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs/{id}")
    public Blog queryById(@PathVariable String id) throws BlogNotFoundException {
        int blogId = Integer.parseInt(id);
        return blogService.findById(blogId);
    }

    @GetMapping("/blogs")
    public List<Blog> getBlogs() {
        return blogService.findAll();
    }

    @PostMapping("/blogs")
    public List<Blog> getBlogsByIndex(@RequestBody GetBlogsByIndexRequest request) {
        String sqlCountRows = "SELECT count(*) FROM blog";
        String sqlFetchRows = "SELECT * FROM blog";
        BlogPageRequest blogPageRequest = new BlogPageRequest(sqlCountRows, sqlFetchRows, new Object[] {}, request.getPageSize(), request.getPageNo());
        List<Blog> blogs = blogService.find(blogPageRequest);
        return blogs;
    }

    @PostMapping("/blogs/add")
    public int add(@RequestBody BlogRequest request) {
        Blog blog = new Blog();
        blog.setId(request.getId());
        blog.setTitle(request.getTitle());
        blog.setContent(request.getContent());
        return blogService.save(blog);
    }

    @PutMapping("/blogs")
    public void update(@RequestBody BlogRequest request) {
        Blog blog = new Blog();
        blog.setId(request.getId());
        blog.setTitle(request.getTitle());
        blog.setContent(request.getContent());
        blogService.update(blog);
    }

    @DeleteMapping("/blogs")
    public int delete(@RequestBody BlogRequest request) {
        return blogService.delete(request.getId());
    }

}
