package spring.manager;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import spring.model.Blog;
import spring.model.BlogRowMapper;
import spring.request.BlogPageRequest;
import spring.util.Page;
import spring.util.PaginationHelper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BlogManagerImpl implements BlogManager {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Blog findById(Integer id) {
        String sql = "SELECT * FROM blog WHERE id = ?";
        Blog blog = jdbcTemplate.queryForObject(sql, new BlogRowMapper(), id);
        return blog;
    }

    @Override
    public List<Blog> findAll() {
        String sql = "SELECT * FROM blog";
        List<Blog> blogs = jdbcTemplate.query(sql, new MyBlogRowMapper());
        return blogs;
    }

    @Override
    public List<Blog> find(BlogPageRequest pageRequest) {
        PaginationHelper paginationHelper = new PaginationHelper();
        Page<Blog> blogPage = paginationHelper.fetch(jdbcTemplate, pageRequest.getSqlCountRows(),
                pageRequest.getSqlFetchRows(), pageRequest.getArgs(), pageRequest.getPageNo(), pageRequest.getPageSize(),
                new BlogRowMapper());
        return blogPage.getPageItems();
    }

    @Override
    public int save(Blog blog) {
        String sql = "INSERT INTO blog (id, title, content) VALUES(?, ?, ?)";
        return jdbcTemplate.update(sql, blog.getId(), blog.getTitle(), blog.getContent());
    }

    @Override
    public void update(Blog blog) {
        String sql = "UPDATE blog SET content = ? WHERE id = ?";
        int status = jdbcTemplate.update(sql, blog.getContent(), blog.getId());
        System.out.println("===Update status: " + status);
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM blog WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    private class MyBlogRowMapper implements RowMapper<Blog> {

        @Override
        public Blog mapRow(ResultSet resultSet, int i) throws SQLException {
            Blog blog = new Blog();
            blog.setId(resultSet.getInt("id"));
            blog.setTitle(resultSet.getString("title"));
            blog.setContent(resultSet.getString("content"));
            return blog;
        }

    }

}
