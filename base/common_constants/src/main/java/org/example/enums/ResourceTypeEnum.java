package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * IAM 资源类型
 *
 * @author 徐鹏军
 * @date 2022/7/11 17:53
 */
@AllArgsConstructor
@Getter
public enum ResourceTypeEnum {
    Api("Api"),
    Menu("菜单"),
    Data("数据"),
    Ui("界面，按钮"),
    ;
    private String desc;
}