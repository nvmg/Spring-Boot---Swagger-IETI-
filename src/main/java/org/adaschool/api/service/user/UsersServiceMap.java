package org.adaschool.api.service.user;

import org.adaschool.api.repository.user.User;
import org.adaschool.api.repository.user.UserDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsersServiceMap implements UsersService {

    Map<String, User> users = new HashMap<>();

    @Override
    public User save(User user) {
        if (findById(user.getId()).isEmpty()) {
            user.setId(String.valueOf(users.size()));
        }
        users.put(user.getId(), user);
        return users.get(user.getId());
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public List<User> all() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void deleteById(String id) {
        users.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        User userToUpdate = users.get(userId);
        userToUpdate.update(new UserDto(user.getName(), user.getLastName(), user.getEmail()));
        return userToUpdate;
    }
}
