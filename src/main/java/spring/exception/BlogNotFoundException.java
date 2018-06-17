package spring.exception;

public class BlogNotFoundException extends Exception {

    private String message;

    public BlogNotFoundException() {
    }

    public BlogNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
