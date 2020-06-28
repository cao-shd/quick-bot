package xbot.quickbot.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import xbot.quickbot.common.base.BaseEntity;

/**
 * 权限
 *
 * @author cao.shd
 * @since 2020-06-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("m_permission")
@ApiModel(value = "Permission对象", description = "权限")
public class Permission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "权限字符串")
    private String code;

    @ApiModelProperty(value = "权限名")
    private String name;

    @ApiModelProperty(value = "路径名")
    private String path;

    @ApiModelProperty(value = "图标名")
    private String icon;

    @ApiModelProperty(value = "权限级别 0一级菜单 1二级菜单 3操作按钮")
    private Boolean level;

    @ApiModelProperty(value = "父级权限")
    private Integer parentId;


}
