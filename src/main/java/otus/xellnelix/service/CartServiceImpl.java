package otus.xellnelix.service;

import org.springframework.stereotype.Service;
import otus.xellnelix.dto.output.CartResponseDto;
import otus.xellnelix.entity.Cart;
import otus.xellnelix.mapper.CartMapper;
import otus.xellnelix.repository.CartRepository;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public CartServiceImpl(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    @Override
    public CartResponseDto save(Cart cart) {
        return cartMapper.toCartResponseDto(cartRepository.save(cart));
    }

    @Override
    public List<CartResponseDto> findAll() {
        return cartMapper.toCartResponseDtoList(cartRepository.findAll());
    }

    @Override
    public CartResponseDto findById(Long id) {
        return cartMapper.toCartResponseDto(cartRepository.findById(id).orElseThrow());
    }

    @Override
    public CartResponseDto findByUserId(Long id) {
        return cartMapper.toCartResponseDto(cartRepository.findByUserId(id));
    }
}
