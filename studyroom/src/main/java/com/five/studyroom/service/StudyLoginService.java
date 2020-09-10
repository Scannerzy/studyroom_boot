package com.five.studyroom.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.five.studyroom.model.StudyLogin;
import org.springframework.stereotype.Service;

public interface StudyLoginService extends IService<StudyLogin> {
    StudyLogin findByUsername(String username);

}
