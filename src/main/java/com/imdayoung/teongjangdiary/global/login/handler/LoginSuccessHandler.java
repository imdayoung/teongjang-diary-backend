package com.imdayoung.teongjangdiary.global.login.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imdayoung.teongjangdiary.global.jwt.service.JwtService;
import com.imdayoung.teongjangdiary.global.login.dto.CustomUserDetails;
import com.imdayoung.teongjangdiary.global.login.dto.LoginSuccessDTO;
import com.imdayoung.teongjangdiary.global.response.response.ApiResponse;
import com.imdayoung.teongjangdiary.user.mapper.UserMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtService jwtService;
    private final UserMapper userMapper;
    private final ObjectMapper objectMapper;

    @Value("${jwt.access.expiration}")
    private String accessTokenExpiration;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String lgnId = extractUsername(authentication);
        String userId = extractUserId(authentication);
        String accessToken = jwtService.createAccessToken(lgnId, userId);
        String refreshToken = jwtService.createRefreshToken();

        jwtService.sendAccessAndRefreshToken(response, accessToken, refreshToken);

        LoginSuccessDTO loginSuccessDTO = LoginSuccessDTO.builder()
                .userId(userId)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

        ApiResponse<LoginSuccessDTO> loginSuccessResponse = ApiResponse.success(loginSuccessDTO);

        userMapper.findUserByUserId(userId)
                .ifPresent(user -> {
                    userMapper.updateRefreshToken(user.getUserId(), refreshToken);
                });

        log.info("로그인에 성공하였습니다. 사용자아이디 : {}", userId);
        log.info("로그인에 성공하였습니다. AccessToken : {}", accessToken);
        log.info("발급된 AccessToken 만료 기간 : {}", accessTokenExpiration);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(loginSuccessResponse));

        ApiResponse.success(loginSuccessResponse);
//        LoginSuccessResponse loginSuccessResponse = LoginSuccessResponse.builder()
//                .username(username)
//                .accessToken(accessToken)
//                .refreshToken(refreshToken)
//                .build();
//
//        ApiResponse<LoginSuccessResponse> successResponse = ApiResponse.success(loginSuccessResponse);
//
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(objectMapper.writeValueAsString(successResponse));
//
//        ApiResponse.success(loginSuccessResponse);
//
//        memberRepository.findByUsername(username)
//                .ifPresent(member -> {
//                    member.updateRefreshToken(refreshToken);
//                    memberRepository.saveAndFlush(member);
//                });
    }

    private String extractUsername(Authentication authentication) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }

    private String extractUserId(Authentication authentication) {

        Object principal = authentication.getPrincipal();

        if (principal instanceof CustomUserDetails) {
            return ((CustomUserDetails) principal).getUserId();
        }

        return null;
    }
}
