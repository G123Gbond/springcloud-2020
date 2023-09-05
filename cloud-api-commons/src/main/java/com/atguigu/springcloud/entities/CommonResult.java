package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Lin lin
 * ClassName: CommonResult
 * Package: com.atguigu.springcloud.entities
 * Date: 2023/8/22
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    Integer code;
    String message;
    T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

}
