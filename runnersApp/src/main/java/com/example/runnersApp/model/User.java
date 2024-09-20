package com.example.runnersApp.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;

@EqualsAndHashCode

@Entity
@Table(name = "app_user")
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(unique = true)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(name = "verification_code")
    private String verificationCode;
    @Column(name = "verification_expiration")
    private LocalDateTime verificationCodeExpiresAt;

    @Column(nullable = false)
    private String password;

    private boolean locked=false;
    private boolean enabled=false;

    public User() {

    }


    public LocalDateTime getVerificationCodeExpiresAt(){
      return verificationCodeExpiresAt;
    }
    public User(String username,String email, String password, Role role) {

        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public String getVerificationCode(){
      return verificationCode;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Role getRole(){
      return role;
    };

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }
    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
    public void setVerificationCodeExpiresAt(LocalDateTime verificationCodeExpiresAt) {
        this.verificationCodeExpiresAt = verificationCodeExpiresAt;
    }
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLocked() {
        return locked;
    }


    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public boolean getEnabled(){
      return enabled;
    }

    // Override toString method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                "userRole"+role+
                ", email='" + email + '\'' +
                ", password='" + "[PROTECTED]" + '\'' +
                ", locked=" + locked +
                ", enabled=" + enabled +
                '}';
    }
}
