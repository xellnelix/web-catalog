package otus.xellnelix.dto.output;

public record CartResponseDto(
        UserResponseDto userResponseDto,
        ProductResponseDto productResponseDto
) {
}
