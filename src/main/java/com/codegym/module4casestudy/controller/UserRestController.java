package com.codegym.module4casestudy.controller;

import com.codegym.module4casestudy.model.dto.*;
import com.codegym.module4casestudy.model.entity.User;
import com.codegym.module4casestudy.model.entity.UserInfo;
import com.codegym.module4casestudy.service.JwtService;
import com.codegym.module4casestudy.service.user.IUserService;
import com.codegym.module4casestudy.service.userInfo.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class UserRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    // Hiển thị danh sách thông tin user

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        //Kiểm tra username và pass có đúng hay không
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        //Lưu user đang đăng nhập vào trong context của security
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody SignUpForm user) {
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User newUser = new User(user.getUsername(), user.getPassword());
        userService.save(newUser);
        String avatar = "1651410713778facebook-cap-nhat-avatar-doi-voi-tai-khoan-khong-su-dung-anh-dai-dien-e4abd14d.jpg";
        String background = "1651390542985emirates-arsenal_gkpg.png";
        UserInfo userInfo = new UserInfo(user.getEmail(), user.getPhoneNumber(),
                user.getDateOfBirth(), avatar, background, newUser);
        userInfoService.save(userInfo);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/findUserId/{email}/{phone}")
    public ResponseEntity<User> findUserId(@PathVariable String email, @PathVariable String phone) {
        Long userId = this.userInfoService.findUserId(email, phone);
        Optional<User> user = this.userService.findById(userId);
        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserInfoExitDTO> usernameExitCheck(@PathVariable String username) {
        List<User> users = this.userService.findAllUser();
        UserInfoExitDTO usernameExitDTO = new UserInfoExitDTO();
        usernameExitDTO.setStatus(false);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                usernameExitDTO.setStatus(true);
                break;
            }
        }
        return new ResponseEntity<>(usernameExitDTO, HttpStatus.OK);
    }

    @GetMapping("/userBlock/{username}")
    public ResponseEntity<UserInfoExitDTO> userBlockCheck(@PathVariable String username) {
        List<User> users = this.userService.findAllUser();
        UserInfoExitDTO usernameExitDTO = new UserInfoExitDTO();
        usernameExitDTO.setStatus(false);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                if (users.get(i).getBlockStatus()) {
                    usernameExitDTO.setStatus(true);
                    break;
                }
            }
        }
        return new ResponseEntity<>(usernameExitDTO, HttpStatus.OK);
    }

    @GetMapping("/username-password/{username}/{password}")
    public ResponseEntity<UserInfoExitDTO> passwordTrueCheck(@PathVariable String username, @PathVariable String password) {
        List<User> users = this.userService.findAllUser();
        UserInfoExitDTO usernameExitDTO = new UserInfoExitDTO();
        usernameExitDTO.setStatus(false);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                if (passwordEncoder.matches(password, users.get(i).getPassword())) {
                    usernameExitDTO.setStatus(true);
                    break;
                }
            }
        }
        return new ResponseEntity<>(usernameExitDTO, HttpStatus.OK);
    }

    @PostMapping("/changePassword/{id}")
    public ResponseEntity<User> changePassword(@PathVariable Long id, @RequestBody ChangePassword changePassword) {
        Optional<User> user = this.userService.findById(id);
        String newPassword;
        String oldPassword = changePassword.getOldPassword();
        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            if (passwordEncoder.matches(oldPassword, user.get().getPassword())) {
                if (changePassword.getNewPassword().equals(changePassword.getConfirmNewPassword())) {
                    newPassword = changePassword.getNewPassword();
                } else {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        user.get().setPassword(newPassword);
        user.get().setId(id);
        this.userService.save(user.get());
        return new ResponseEntity<>(user.get(), HttpStatus.OK);

    }
}
