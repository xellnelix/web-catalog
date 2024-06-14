package otus.xellnelix.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import otus.xellnelix.dto.output.UserResponseDto;
import otus.xellnelix.entity.User;
import otus.xellnelix.mapper.UserMapper;
import otus.xellnelix.repository.UserRepository;

import java.util.List;

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
    public UserResponseDto save(User user) {
        return userMapper.toUserResponseDto(userRepository.save(user));
    }

    @Override
    public List<UserResponseDto> findAll() {
        return userMapper.toUserResponseDtoList(userRepository.findAll());
    }

    @Override
    public UserResponseDto findUserById(Long id) {
        return userMapper.toUserResponseDto(userRepository.findById(id).orElseThrow());
    }

    @Override
    public UserResponseDto updateByLogin(String login, User user) {
        User foundUser = userRepository.findByLogin(login);
        if (foundUser == null) {
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
        User foundUser = userRepository.findById(id).orElseThrow();
        userRepository.deleteById(id);
        return userMapper.toUserResponseDto(foundUser);
    }

    @Override
    public UserResponseDto findByLogin(String login) {
        return userMapper.toUserResponseDto(userRepository.findByLogin(login));
    }
}
