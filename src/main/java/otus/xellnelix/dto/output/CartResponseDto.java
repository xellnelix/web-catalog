package otus.xellnelix.dto.output;

import java.math.BigDecimal;
import java.util.List;

public record CartResponseDto(
        Long id,
        UserResponseDto userResponseDto,
        List<ProductResponseDto> productResponseDtoList,
        BigDecimal amount
) {
}
