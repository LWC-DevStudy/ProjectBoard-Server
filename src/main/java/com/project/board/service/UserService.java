package com.project.board.service;

import com.project.board.domain.User;
import com.project.board.dto.SignupRequestDto;
import com.project.board.dto.UserRequestDto;
import com.project.board.exception.ApiRequestException;
import com.project.board.repository.UserRepository;
import com.project.board.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;

    private static final int MIN_PASSWORD_LENGTH = 6;
    private static final int MAX_PASSWORD_LENGTH = 20;

    public String login(UserRequestDto userRequestDto) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userRequestDto.getUserName(),userRequestDto.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        return jwtTokenProvider.makeJwtToken(authentication);
    }


    public void registerUser(SignupRequestDto signupRequestDto){
        String username = signupRequestDto.getUserName();

        Optional<User> found = userRepository.findByUserName(username);
        if (found.isPresent()) {
            throw new ApiRequestException("중복된 사용자 ID 가 존재합니다.");
        }

        String password = signupRequestDto.getPassword();
        String passwordCheck = signupRequestDto.getPasswordConfirm();

        if (!password.isEmpty() && !passwordCheck.isEmpty()) {
            if (password.length() >= MIN_PASSWORD_LENGTH && password.length() <= MAX_PASSWORD_LENGTH) {
                if (!password.equals(passwordCheck)) {
                    throw new ApiRequestException("패스워드가 일치하지 않습니다!");
                }
            } else {
                throw new ApiRequestException("비밀번호는"+MIN_PASSWORD_LENGTH+"~"+MAX_PASSWORD_LENGTH+"자리를 사용해야 합니다.");
            }
        } else {
            throw new ApiRequestException("패스워드를 입력해 주세요.");
        }

        password = passwordEncoder.encode(password);



        User user = new User(username, password);
        userRepository.save(user);
    }
}