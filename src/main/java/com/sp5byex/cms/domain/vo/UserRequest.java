package com.sp5byex.cms.domain.vo;

import com.sp5byex.cms.domain.models.Role;
import lombok.Data;

@Data
public class UserRequest {

  String identity;

  String name;

  Role role;
}
