package otus.xellnelix.controller;

import org.springframework.web.bind.annotation.*;
import otus.xellnelix.dto.input.CartCreateDto;
import otus.xellnelix.dto.output.CartResponseDto;
import otus.xellnelix.entity.Cart;
import otus.xellnelix.mapper.CartMapper;
import otus.xellnelix.service.CartService;
import otus.xellnelix.service.ProductService;

import java.util.List;

@RestController
public class CartController {
    private final CartService cartService;
    private final CartMapper cartMapper;

    public CartController(CartService cartService, CartMapper cartMapper) {
        this.cartService = cartService;
        this.cartMapper = cartMapper;
    }

    @PostMapping("/carts/add")
    public CartResponseDto addCart(@RequestBody CartCreateDto cartCreateDto) {
        return cartService.save(cartMapper.toCart(cartCreateDto));
    }

    @GetMapping("/carts")
    public List<CartResponseDto> findAllCarts() {
        return cartService.findAll();
    }

    @GetMapping("/carts/{id}")
    public CartResponseDto findCart(@PathVariable Long id) {
        return cartService.findById(id);
    }

    @GetMapping("/carts/users/{id}")
    public CartResponseDto findCartByUser(@PathVariable Long id) {
        return cartService.findByUserId(id);
    }
}
