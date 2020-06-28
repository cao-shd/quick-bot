package xbot.quickbot.security.model;

import lombok.Data;
import xbot.quickbot.security.entity.User;

@Data
public class UserModel extends User {
    private String view;
}
