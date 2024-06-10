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

    @PostMapping("/user/add")
    public void addUser(@RequestBody UserCreateDto userCreateDto) {
        userService.register(userMapper.toUser(userCreateDto));
    }

    @GetMapping("/user/all")
    public List<UserResponseDto> findAllProduct() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public UserResponseDto findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/user")
    public UserResponseDto findUserByLogin(@RequestParam String login) {
        return userService.findByLogin(login);
    }

    @PatchMapping("/user/update/{login}")
    public UserResponseDto update(@PathVariable String login, @RequestBody UserCreateDto userCreateDto) {
        return userService.updateByLogin(login, userMapper.toUser(userCreateDto));
    }

    @DeleteMapping("/user/delete/{id}")
    public UserResponseDto delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
