package otus.xellnelix.service;

import otus.xellnelix.dto.input.UserCreateDto;
import otus.xellnelix.dto.output.UserResponseDto;
import otus.xellnelix.entity.User;

import java.util.List;

public interface UserService {
    UserResponseDto save(User user);

    List<UserResponseDto> findAll();

    UserResponseDto findUserById(Long id);

    UserResponseDto updateByLogin(String login, User user);

    UserResponseDto delete(Long id);

    UserResponseDto findByLogin(String login);
}
