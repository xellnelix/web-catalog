package otus.xellnelix.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import otus.xellnelix.dto.input.UserCreateDto;
import otus.xellnelix.dto.output.UserResponseDto;
import otus.xellnelix.entity.User;
import otus.xellnelix.mapper.UserMapper;
import otus.xellnelix.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void register(User user) {
        userRepository.save(user);
    }

    @Override
    public List<UserResponseDto> findAll() {
        return userMapper.toUserResponseDtoList((List<User>) userRepository.findAll());
    }

    @Override
    public UserResponseDto findUserById(Long id) {
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.map(userMapper::toUserResponseDto).orElse(null);
    }

    @Override
    public UserResponseDto updateByLogin(String login, User user) {
        User foundUser = userRepository.findByLogin(login);
        if (foundUser == null) {
            logNotFound(user.getLogin());
            return null;
        }
        if (user.getLogin() != null) {
            foundUser.setLogin(user.getLogin());
        }
        if (user.getPassword() != null) {
            foundUser.setPassword(user.getPassword());
        }
        return userMapper.toUserResponseDto(userRepository.save(foundUser));
    }

    @Override
    public UserResponseDto delete(Long id) {
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isPresent()) {
            userRepository.deleteById(id);
            return userMapper.toUserResponseDto(foundUser.get());
        }
        log.info("User with id = {} not found", id);
        return null;
    }

    @Override
    public UserResponseDto findByLogin(String login) {
        return userMapper.toUserResponseDto(userRepository.findByLogin(login));
    }

    private void logNotFound(String login) {
        log.info("User with login = {} not exists", login);
    }
}
