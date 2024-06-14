package otus.xellnelix.dto.input;

public record UserCreateDto(
        String login,
        String password,
        String authority
) {
}