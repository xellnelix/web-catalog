package otus.xellnelix.entity;

import jakarta.annotation.Nonnull;
import jdk.jfr.Description;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.Set;

@Table(name = "product", schema = "public")
@Description("Товар")
public class Product {
    @Id
    private Long id;

    @Nonnull
    private String name;

    @Nonnull
    private Long vendorId;

    @Nonnull
    private Integer quantity;

    @Nonnull
    private BigDecimal price;

    @MappedCollection(idColumn = "product_id")
    private Set<Cart> cart;

    public Product(Long id, String name, Long vendorId, Integer quantity, BigDecimal price, Set<Cart> cart) {
        this.id = id;
        this.name = name;
        this.vendorId = vendorId;
        this.quantity = quantity;
        this.price = price;
        this.cart = cart;
    }

    public Product(String name, Long vendorId, Integer quantity, BigDecimal price, Set<Cart> cart) {
        this(null, name, vendorId, quantity, price, cart);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Cart> getCart() {
        return cart;
    }

    public void setCart(Set<Cart> cart) {
        this.cart = cart;
    }
}
