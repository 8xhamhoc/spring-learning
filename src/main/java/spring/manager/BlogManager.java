package spring.manager;

import spring.exception.BlogNotFoundException;
import spring.model.Blog;
import spring.request.BlogPageRequest;

import java.util.List;

public interface BlogManager {

    Blog findById(Integer id) throws BlogNotFoundException;

    List<Blog> findAll();

    List<Blog> find(BlogPageRequest pageRequest);

    int save(Blog blog);

    void update(Blog blog);

    int delete(int id);

}
