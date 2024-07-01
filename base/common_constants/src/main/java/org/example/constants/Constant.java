//package org.example.constants;
//
//import io.swagger.annotations.ApiModelProperty;
//
//import java.util.regex.Pattern;
//
///**
// * Nancal.com Inc.
// * Copyright (c) 2021- All Rights Reserved.
// *
// * @Author zhangpp
// * @Date 2021/11/10 14:12
// * @Description 通用常量信息
// */
//public class Constant {
//    @ApiModelProperty("令牌存储有效期 4h（秒）")
//    public static final long TOKEN_EXPIRE = 4L * 60 * 60;
//    @ApiModelProperty("解析${}表达式的正则")
//    public static final Pattern $_PATTERN = Pattern.compile("\\$\\{(\\w+)\\}");
//    @ApiModelProperty("令牌自定义标识")
//    public static final String AUTHORIZATION = "Authorization";
//    @ApiModelProperty("租户令牌自定义标识")
//    public static final String TENANT_ID = "tenantId";
//    @ApiModelProperty("租户令牌自定义标识")
//    public static final String TOKEN = "token";
//    @ApiModelProperty("实体类后缀")
//    public static final String ENTITY = "Entity";
//    @ApiModelProperty("解析{{}}表达式的正则")
//    public static final Pattern PREFIX_PATTERN = Pattern.compile("\\{\\{(.*?)}}");
//
//    private Constant() {
//    }
//
//    @ApiModelProperty("编码器长度")
//    public static final int ENCODER_LENGTH = 5;
//    @ApiModelProperty("字典存储有效期 10分钟（分钟）")
//    public static final long DICT_EXPIRE = 10;
//    @ApiModelProperty("编码器规则存储有效期 10分钟（分钟）")
//    public static final long ENCODER_EXPIRE = 10;
//
//}