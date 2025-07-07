package com.imdayoung.teongjangdiary.user.mapper;

import com.imdayoung.teongjangdiary.user.dto.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface UserMapper {

    List<UserVO> selectUserList();
    Optional<UserVO> findUserByLgnId(String lgnId);
    Optional<UserVO> findUserByUserId(String userId);
    Optional<UserVO> findUserByRefreshToken(String refreshToken);
    void updateRefreshToken(String userId, String refreshToken);
    void insertUser(UserVO user);
}
