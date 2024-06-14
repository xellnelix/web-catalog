package otus.xellnelix.dto.input;

import java.util.List;

public record CartCreateDto(
        Long userId,
        List<Long> productId
) {
}
