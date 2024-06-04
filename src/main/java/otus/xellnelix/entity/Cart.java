package otus.xellnelix.entity;

import jdk.jfr.Description;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "cart", schema = "public")
@Description("Корзина")
public class Cart {
    private Long userId;
    private Long productId;

    public Cart(Long userId, Long productId) {
        this.userId = userId;
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
