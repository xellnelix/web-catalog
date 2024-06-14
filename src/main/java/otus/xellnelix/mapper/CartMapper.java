package otus.xellnelix.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import otus.xellnelix.dto.input.CartCreateDto;
import otus.xellnelix.dto.output.CartResponseDto;
import otus.xellnelix.entity.Cart;
import otus.xellnelix.entity.Product;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ProductMapper.class, UserMapper.class})
public interface CartMapper {
    @Mapping(target = "userResponseDto", source = "user")
    @Mapping(target = "productResponseDtoList", source = "product")
    @Mapping(target = "amount", source = "product", qualifiedByName = "calcAmount")
    CartResponseDto toCartResponseDto(Cart cart);

    @Named("calcAmount")
    default BigDecimal calcAmount(List<Product> productList) {
        BigDecimal totalAmount = BigDecimal.valueOf(0);
        if (productList == null) {
            return BigDecimal.ZERO;
        }
        for (Product product : productList) {
            totalAmount = totalAmount.add(product.calcAmount());
        }
        return totalAmount;
    }

    List<CartResponseDto> toCartResponseDtoList(List<Cart> cartList);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", source = "productId")
    @Mapping(target = "user.id", source = "userId")
    Cart toCart(CartCreateDto cartCreateDto);
}
