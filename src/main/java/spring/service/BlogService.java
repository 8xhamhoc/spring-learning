package spring.service;

import spring.model.Blog;

import java.util.List;

public interface BlogService {

    Blog findById(Integer id);

    List<Blog> findAll();

}
