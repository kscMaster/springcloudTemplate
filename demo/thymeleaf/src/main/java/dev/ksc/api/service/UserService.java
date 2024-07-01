package dev.ksc.api.service;

import dev.ksc.api.mapper.UserMapper;
import dev.ksc.api.pojo.PjUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public PjUser getUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Transactional
    public int delUserById(Long userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    public PjUser inserUser(PjUser pjUser) {
        pjUser.setUserName("用户名");
        userMapper.insert(pjUser);
        return pjUser;
    }

    public List<PjUser> selectAllUsers() {
        return this.userMapper.selectAll();
    }
}
