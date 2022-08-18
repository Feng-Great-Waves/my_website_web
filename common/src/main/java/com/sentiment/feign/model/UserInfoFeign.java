package com.sentiment.feign.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/18 10:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoFeign {
    private Long id;
    private String userName;
    private String nickName;
}
