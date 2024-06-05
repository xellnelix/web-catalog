package otus.xellnelix.entity;

import jdk.jfr.Description;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "cart", schema = "public")
@Description("Корзина")
public class Cart {
    @Id
    private Long id;

    private Long userId;
    private Long productId;

    public Cart(Long userId, Long productId) {
        this(null, userId, productId);
    }

    @PersistenceCreator
    public Cart(Long id, Long userId, Long productId) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
