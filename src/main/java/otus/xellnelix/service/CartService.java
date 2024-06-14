package otus.xellnelix.service;

import otus.xellnelix.dto.output.CartResponseDto;
import otus.xellnelix.entity.Cart;

import java.util.List;

public interface CartService {
    CartResponseDto save(Cart cart);

    List<CartResponseDto> findAll();

    CartResponseDto findById(Long id);

    CartResponseDto findByUserId(Long id);
}
