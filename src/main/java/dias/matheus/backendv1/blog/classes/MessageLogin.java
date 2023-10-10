package dias.matheus.backendv1.blog.classes;

import dias.matheus.backendv1.blog.enums.UserRole;

public class MessageLogin  extends
Message
{
    public UserRole token;

    public Long userId;

    public MessageLogin() {
    }

    public MessageLogin(String message, Integer code, UserRole token, Long userId) {
        super(message, code);
        this.token = token;
        this.userId = userId;
    }

    public UserRole getToken() {
        return this.token;
    }
}
