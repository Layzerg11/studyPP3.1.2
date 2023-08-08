package com.studyPP312.ProjectBoot.service;


import com.studyPP312.ProjectBoot.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getUserList();

    public User getUser(int id);

    public void save(User user);

    public void update(int id, User updateUser);

    public void delete(User user);
}
