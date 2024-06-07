package otus.xellnelix.mapper;

import org.modelmapper.ModelMapper;
import otus.xellnelix.dto.ProductDto;
import otus.xellnelix.entity.Product;

import java.util.Optional;

public class ProductMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static ProductDto toDto(Optional<Product> product) {
        return modelMapper.map(product, ProductDto.class);
    }

    public static Product toEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }
}
