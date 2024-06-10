package otus.xellnelix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import otus.xellnelix.dto.input.CartCreateDto;
import otus.xellnelix.dto.output.CartResponseDto;
import otus.xellnelix.mapper.CartMapper;
import otus.xellnelix.service.CartService;

import java.util.List;

@RestController
public class CartController {
    private final CartService cartService;
    private final CartMapper cartMapper;

    public CartController(CartService cartService, CartMapper cartMapper) {
        this.cartService = cartService;
        this.cartMapper = cartMapper;
    }

    @PostMapping("/cart/add")
    public CartResponseDto addCart(@RequestBody CartCreateDto cartCreateDto) {
        return cartService.save(cartMapper.toCart(cartCreateDto));
    }

    @GetMapping("/cart/all")
    public List<CartResponseDto> findAllProduct() {
        return cartService.findAll();
    }
}
