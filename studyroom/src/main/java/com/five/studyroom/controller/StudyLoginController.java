package com.five.studyroom.controller;

import com.five.studyroom.model.StudyLogin;
import com.five.studyroom.service.StudyLoginService;
import com.zy.common.CommonExceptionEnum;
import com.zy.common.CommonUtil;
import com.zy.common.MD5Util;
import com.zy.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/login")
public class StudyLoginController {

    @Autowired
    private StudyLoginService studyLoginService;

    /**
     * 注册
     * @param studyLogin
     * @return
     */
    @PostMapping("/saveStudy")
    public Result saveStudy(@RequestBody StudyLogin studyLogin){
        log.info("studyLogin is {}",studyLogin);
        String password = studyLogin.getPassword();
        String s = MD5Util.encodeByMD5(password);
        studyLogin.setPassword(s);
        studyLoginService.saveOrUpdate(studyLogin);
        return Result.ok();
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @GetMapping("/findAll")
    public Result<List<StudyLogin>> findAll(){
        Result<List<StudyLogin>> result = Result.ok();
        try {
            List<StudyLogin> list = studyLoginService.list();
            result.setResult(list);
            return result;
        }catch (Exception e){
            log.info(e.getMessage());
            result.error500("error");
            return result;
        }
    }

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @PostMapping
    public Result login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password){
        Result result = Result.ok();
        try {
            if (StringUtils.isEmpty(username)){
                CommonUtil.cast(CommonExceptionEnum.USERNAME_ISNULL);
            }else if (StringUtils.isEmpty(password)){
                CommonUtil.cast(CommonExceptionEnum.PASSWORD_ISNULL);
            }
            StudyLogin studyLogin = studyLoginService.findByUsername(username);
            if (studyLogin==null){
                CommonUtil.cast(CommonExceptionEnum.USER_ISNULL);
            }
            String password2 = MD5Util.encodeByMD5(password);
            if (!password2.equals(studyLogin.getPassword())){
                CommonUtil.cast(CommonExceptionEnum.PASSWORD_ERROR);
            }
            return result;
        }catch (Exception e){
            log.info(e.getMessage());
            result.error500("error");
            return result;
        }
    }

    /**
     * 删除用户
     * @param studyLogin
     * @return
     */
    @DeleteMapping("/deleteStudy")
    public Result deleteStudy(StudyLogin studyLogin){
        Result result = Result.ok();
        studyLoginService.removeById(studyLogin.getId());
        return result;
    }
}
