package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author： Wang Hui
 * @date： 2022/5/3 14:44
 * @description： 送审类型枚举
 **/
@Getter
@AllArgsConstructor
public enum ApprovalTypeEnum {
    ITEM("partSend", "零件送审", "Process_20220426112203"),
    ITEMS("moduleSend", "组件送审", "Process_20220426114521"),
    ITEM_QUICK_RELEASE("partSendFast", "零件快速发布", "Process_20220426111850"),
    ITEMS_QUICK_RELEASE("moduleSendFast", "组件快速发布", "Process_20220426111850");

    private String key;
    private String value;
    private String model;

    /***
     *根据key获取model
     *
     * @param code key
     * @author: 王辉
     * @date: 2022/5/3 14:50
     * @return:  {@link String}
     */
    public static String getModelByKey(String code) {
        ApprovalTypeEnum[] approvalTypeEnums = values();
        for (ApprovalTypeEnum approvalTypeEnum : approvalTypeEnums) {
            if (approvalTypeEnum.getKey().equals(code)) {
                return approvalTypeEnum.getModel();
            }
        }
        return "";
    }
}