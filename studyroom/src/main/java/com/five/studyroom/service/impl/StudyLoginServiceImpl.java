package com.five.studyroom.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.five.studyroom.mapper.StudyLoginMapper;
import com.five.studyroom.model.StudyLogin;
import com.five.studyroom.service.StudyLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudyLoginServiceImpl
        extends ServiceImpl<StudyLoginMapper, StudyLogin>
        implements StudyLoginService {
    @Autowired
    private StudyLoginMapper studyLoginMapper;

    @Override
    public StudyLogin findByUsername(String username) {
        QueryWrapper<StudyLogin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        StudyLogin studyLogin = studyLoginMapper.selectOne(queryWrapper);
        return studyLogin;
    }
}
