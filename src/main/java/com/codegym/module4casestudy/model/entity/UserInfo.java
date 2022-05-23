package com.codegym.module4casestudy.model.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String fullName;

    private String phoneNumber;

    private String dateOfBirth;

    private String address;

    private String avatar;

    private String backGround;

    private String interest;

    @OneToOne
    private User user;

    public UserInfo(String email, String fullName, String phoneNumber, String dateOfBirth, String address, String avatar, String backGround, String interest, User user) {
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.avatar = avatar;
        this.backGround = backGround;
        this.interest = interest;
        this.user = user;
    }

    public UserInfo(Long id, String email, String fullName, String phoneNumber, String dateOfBirth, String address, String avatar, String backGround, User user) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.avatar = avatar;
        this.backGround = backGround;
        this.user = user;
    }

    public UserInfo(String email, String fullName, String phoneNumber, String dateOfBirth, String address, String avatar, String backGround, User user) {
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.avatar = avatar;
        this.backGround = backGround;
        this.user = user;
    }

    public UserInfo(String email, String phoneNumber, String dateOfBirth, String avatar, String backGround, User user) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.avatar = avatar;
        this.backGround = backGround;
        this.user = user;
    }
}
