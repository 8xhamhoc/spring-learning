package spring.request;

public class BlogPageRequest {

    private String sqlCountRows;
    private String sqlFetchRows;
    private Object[] args;
    private int pageSize;
    private int pageNo;

    public BlogPageRequest() {
    }

    public BlogPageRequest(String sqlCountRows, String sqlFetchRows, Object[] args, int pageSize, int pageNo) {
        this.sqlCountRows = sqlCountRows;
        this.sqlFetchRows = sqlFetchRows;
        this.args = args;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    public String getSqlCountRows() {
        return sqlCountRows;
    }

    public void setSqlCountRows(String sqlCountRows) {
        this.sqlCountRows = sqlCountRows;
    }

    public String getSqlFetchRows() {
        return sqlFetchRows;
    }

    public void setSqlFetchRows(String sqlFetchRows) {
        this.sqlFetchRows = sqlFetchRows;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
