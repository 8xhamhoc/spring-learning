package spring.manager;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import spring.model.Blog;
import spring.model.BlogRowMapper;

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
