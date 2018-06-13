package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.manager.BlogManager;
import spring.model.Blog;
import spring.request.BlogPageRequest;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogManager blogManager;

    @Override
    public Blog findById(Integer id) {
        return blogManager.findById(id);
    }

    @Override
    public List<Blog> findAll() {
        return blogManager.findAll();
    }

    @Override
    public List<Blog> find(BlogPageRequest pageRequest) {
        return blogManager.find(pageRequest);
    }

    @Override
    public int save(Blog blog) {
        return blogManager.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogManager.update(blog);
    }

    @Override
    public int delete(int id) {
        return blogManager.delete(id);
    }
}
