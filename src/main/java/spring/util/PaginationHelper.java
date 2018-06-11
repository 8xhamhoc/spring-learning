package spring.util;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PaginationHelper<E> {

    public Page<E> fetch(final JdbcTemplate jt, final String sqlCountRows,
                         final String sqlFetchRows, final Object[] args,
                         final int pageNo, final int pageSize,
                         final RowMapper<E> rowMapper) {

        final int rowCount = jt.queryForObject(sqlCountRows, args, Integer.class);

        int pageCount = rowCount / pageSize;
        if (rowCount > (pageCount * pageSize)) {
            pageCount++;
        }

        final Page<E> page = new Page<E>();
        page.setPageNumber(pageNo);
        page.setPagesAvailable(pageCount);

        final int startRow = (pageNo - 1) * pageSize;

        jt.query(sqlFetchRows, args, new ResultSetExtractor<Object>() {
            @Override
            public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
                final List<E> pageItems = page.getPageItems();
                int currentRow = 0;

                while (rs.next() && currentRow < startRow + pageSize) {
                    if (currentRow >= startRow) {
                        pageItems.add(rowMapper.mapRow(rs, currentRow));
                    }
                    currentRow++;
                }

                return page;
            }
        });

        return page;
    }

}
