package dias.matheus.backendv1.blog.classes;

public class Message {

    public static final Integer SUCCESS = 200;
    public static final Integer ERROR = 400;

    public String message;

    public Integer code;


    public Message() {
    }

    public Message(String message, Integer code) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
