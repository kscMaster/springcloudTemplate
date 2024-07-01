package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author： Wang Hui
 * @date： 2022/4/26 20:27
 * @description：应用程序的枚举
 **/
@Getter
@AllArgsConstructor
public enum AppNameEnum {
    MY_WORKSPACE("lzdigit-rd-tc-myworkspace", "乐造-数研-个人工作台","个人工作台"),
    LIBRARY("lzdigit-rd-tc-library", "乐造-数研-基础库管理","基础库管理"),
    EBOM("lzdigit-rd-tc-ebom", "乐造-数研-EBOM管理","EBOM管理"),
    PBOM("lzdigit-rd-tc-pbom", "乐造-数研-PBOM管理","PBOM管理"),
    TECHNICAL_STATE("lzdigit-rd-tc-technical-state", "乐造-数研-技术状态管理管理","技术状态管理管理"),
    DB_SYNC("lzdigit-rd-tc-data-sync","乐造-数研-TC数据库同步","TC数据库同步");
    ;
    private String code;
    private String name;
    private String shortName;
}