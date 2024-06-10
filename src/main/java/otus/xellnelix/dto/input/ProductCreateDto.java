package otus.xellnelix.dto.input;

import java.math.BigDecimal;

public record ProductCreateDto(
        String name,
        Integer quantity,
        BigDecimal price
) {
}
