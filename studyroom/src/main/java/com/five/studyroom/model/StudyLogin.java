package com.five.studyroom.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "study_login")//指定表名
public class StudyLogin {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private Integer id;

    private String username; //用户名

    private String password; //密码

    private Integer userId; //用户id
}
