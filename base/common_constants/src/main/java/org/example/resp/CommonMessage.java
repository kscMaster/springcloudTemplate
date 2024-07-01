package org.example.resp;

//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CommonMessage implements Serializable {

//    @ApiModelProperty(value = "响应码，0是成功，非0失败", example = "0")
    private int code = 0;

//    @ApiModelProperty(value = "响应描述")
    private String msg = "";
    private long page = 0;
    private long size = 0;

    public CommonMessage (int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public CommonMessage (int code, String msg, long page, long size) {
        this.code = code;
        this.msg = msg;
        this.page = page;
        this.size = size;
    }

    /***
     * 判断响应是否成功
     *
     * @author xupj
     * @date 2022/3/29 19:44
     * @return {@link Boolean}
     */
    public Boolean isFail() {
        return code != 0;
    }
}