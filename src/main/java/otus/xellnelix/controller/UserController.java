package otus.xellnelix.controller;

import org.springframework.web.bind.annotation.*;
import otus.xellnelix.dto.input.UserCreateDto;
import otus.xellnelix.dto.output.UserResponseDto;
import otus.xellnelix.mapper.UserMapper;
import otus.xellnelix.service.UserService;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/users/add")
    public UserResponseDto addUser(@RequestBody UserCreateDto userCreateDto) {
        return userService.save(userMapper.toUser(userCreateDto));
    }

    @GetMapping("/users")
    public List<UserResponseDto> findAllProduct() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public UserResponseDto findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/users/find-user/{login}")
    public UserResponseDto findUserByLogin(@PathVariable String login) {
        return userService.findByLogin(login);
    }

    @PatchMapping("/users/{login}")
    public UserResponseDto update(@PathVariable String login, @RequestBody UserCreateDto userCreateDto) {
        return userService.updateByLogin(login, userMapper.toUser(userCreateDto));
    }

    @DeleteMapping("/users/{id}")
    public UserResponseDto delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
