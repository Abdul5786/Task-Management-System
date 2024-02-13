package com.Abdul.TaskManagementSystem.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtRequest
{
  private String email;
  private String password;
}

