package otus.xellnelix.dto.output;

import java.math.BigDecimal;

public record ProductResponseDto(
        Long id,
        String name,
        Integer quantity,
        BigDecimal price
) {
}
