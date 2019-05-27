package com.sp5byex.cms.domain.service;

import com.sp5byex.cms.domain.models.User;
import com.sp5byex.cms.domain.repository.UserRepository;
import com.sp5byex.cms.domain.vo.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepo) {
    this.userRepository = userRepo;
  }

  public User update(String id, UserRequest userReq) {
    final User user = this.userRepository.findOne(id);
    user.setIdentity(userReq.getIdentity());
    user.setName(userReq.getName());
    user.setRole(userReq.getRole());

    return this.userRepository.save(user);
  }

  public User create(UserRequest req) {
    User user = new User();

    user.setId(UUID.randomUUID().toString());
    user.setIdentity(req.getIdentity());
    user.setName(req.getName());
    user.setRole(req.getRole());
    return this.userRepository.save(user);
  }

  public void delete(String id) {
    final User user = this.userRepository.findOne(id);
    this.userRepository.delete(user);
  }

  public List<User> findAll() {
    return this.userRepository.findAll();
  }

  public User findOne(String id) {
    return this.userRepository.findOne(id);
  }
}
