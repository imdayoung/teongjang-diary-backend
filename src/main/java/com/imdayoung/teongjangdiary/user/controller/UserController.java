package com.imdayoung.teongjangdiary.user.controller;

import com.imdayoung.teongjangdiary.global.response.response.ApiResponse;
import com.imdayoung.teongjangdiary.user.dto.UserVO;
import com.imdayoung.teongjangdiary.user.mapper.UserMapper;
import com.imdayoung.teongjangdiary.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    @GetMapping("/user")
    public ApiResponse<List<UserVO>> index() {
        List<UserVO> userVO = userMapper.selectUserList();
        return ApiResponse.success(userVO);
    }

    @PostMapping("/api/v1/user/signup")
    public ApiResponse<String> signup(@RequestBody UserVO userVO) {
        userService.signUp(userVO);
        return ApiResponse.success("success");
    }
}
