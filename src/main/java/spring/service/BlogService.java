package spring.service;

import spring.model.Blog;
import spring.request.BlogPageRequest;

import java.util.List;

public interface BlogService {

    Blog findById(Integer id);

    List<Blog> findAll();

    List<Blog> find(BlogPageRequest pageRequest);

}
