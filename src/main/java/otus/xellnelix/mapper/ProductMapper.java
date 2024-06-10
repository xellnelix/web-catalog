package otus.xellnelix.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import otus.xellnelix.dto.input.ProductCreateDto;
import otus.xellnelix.dto.output.ProductResponseDto;
import otus.xellnelix.entity.Product;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    ProductResponseDto toProductResponseDto(Product product);

    List<ProductResponseDto> toProductResponseDtoList(List<Product> productList);

    @Mapping(target = "id", ignore = true)
    Product toProduct(ProductCreateDto productCreateDto);
}
