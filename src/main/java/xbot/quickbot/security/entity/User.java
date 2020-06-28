package xbot.quickbot.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import springfox.documentation.annotations.ApiIgnore;
import xbot.quickbot.common.base.BaseEntity;
import xbot.quickbot.common.view.BaseView;
import xbot.quickbot.common.view.DeleteView;
import xbot.quickbot.common.view.FormView;
import xbot.quickbot.common.view.TableView;

import java.time.LocalDateTime;

/**
 * 用户
 *
 * @author cao.shd
 * @since 2020-06-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("m_user")
@ApiModel(value = "User对象", description = "用户")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @JsonView({TableView.class, FormView.class})
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    @JsonView({TableView.class, FormView.class})
    private String username;

    @ApiModelProperty(value = "密码")
    @JsonView({FormView.class})
    private String password;

    @ApiModelProperty(value = "电话号")
    @JsonView({TableView.class, FormView.class})
    private String phone;

    @ApiModelProperty(value = "邮箱")
    @JsonView({TableView.class, FormView.class})
    private String email;

    @ApiModelProperty(value = "上次访问时间")
    @JsonView({TableView.class})
    private LocalDateTime lastLoginTime;

    @ApiModelProperty(value = "是否禁用: 0禁用 1可用")
    @JsonView({TableView.class, FormView.class})
    private Boolean status;
}
