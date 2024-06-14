package otus.xellnelix.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import otus.xellnelix.dto.input.UserCreateDto;
import otus.xellnelix.dto.output.UserResponseDto;
import otus.xellnelix.entity.User;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserResponseDto toUserResponseDto(User user);

    List<UserResponseDto> toUserResponseDtoList(List<User> userList);

    @Mapping(target = "authority", defaultValue = "ROLE_USER")
    @Mapping(target = "id", ignore = true)
    User toUser(UserCreateDto userCreateDto);

    @Mapping(target = "id", source = "value")
    User map(Long value);
}
