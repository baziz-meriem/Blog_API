package com.example.runnersApp.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.NotBlank;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;

    private String resetPasswordToken;
    private boolean isEmailVerified;
    private String verificationToken;

    // Default constructor
    public User() {
    }

    // Constructor with all fields
    public User(Integer id, String email, String password, String resetPasswordToken, boolean isEmailVerified, String verificationToken) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.resetPasswordToken = resetPasswordToken;
        this.isEmailVerified = isEmailVerified;
        this.verificationToken = verificationToken;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    // Override toString method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + "[PROTECTED]" + '\'' + // Avoid printing the actual password
                ", resetPasswordToken='" + resetPasswordToken + '\'' +
                ", isEmailVerified=" + isEmailVerified +
                ", verificationToken='" + verificationToken + '\'' +
                '}';
    }
}
