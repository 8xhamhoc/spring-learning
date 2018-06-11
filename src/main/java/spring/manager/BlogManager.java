package spring.manager;

import spring.model.Blog;

import java.util.List;

public interface BlogManager {

    Blog findById(Integer id);

    List<Blog> findAll();

}
