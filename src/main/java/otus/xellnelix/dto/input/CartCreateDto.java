package otus.xellnelix.dto.input;

import otus.xellnelix.dto.output.ProductResponseDto;
import otus.xellnelix.dto.output.UserResponseDto;

public record CartCreateDto(
        UserResponseDto user,
        ProductResponseDto product
) {
}
