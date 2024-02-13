package com.Abdul.TaskManagementSystem.entities;

import com.Abdul.TaskManagementSystem.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_details")
public class User  implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String name;
    private String email;
    private String password;
    private String about;
    private UserRole userRole;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return  List.of( new SimpleGrantedAuthority(userRole.name()));
    }

    @Override
    public String getUsername() {
        return this.email;
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
        return true;
    }
}
