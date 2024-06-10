package otus.xellnelix.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import otus.xellnelix.dto.input.CartCreateDto;
import otus.xellnelix.dto.input.ProductCreateDto;
import otus.xellnelix.dto.output.CartResponseDto;
import otus.xellnelix.dto.output.UserResponseDto;
import otus.xellnelix.entity.Cart;
import otus.xellnelix.entity.Product;
import otus.xellnelix.entity.User;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CartMapper {
    CartResponseDto toCartResponseDto(Cart cart);

    @Mapping(target = "")
    List<CartResponseDto> toCartResponseDtoList(List<Cart> cartList);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "productId", source = "product.id")
    Cart toCart(CartCreateDto cartCreateDto);
}
