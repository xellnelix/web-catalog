package otus.xellnelix.entity;

import jakarta.annotation.Nonnull;
import jdk.jfr.Description;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
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
    private Integer quantity;

    @Nonnull
    private BigDecimal price;

    @PersistenceCreator
    public Product(Long id, String name, Integer quantity, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(String name, Integer quantity, BigDecimal price) {
        this(null, name, quantity, price);
    }

    public Product() {}

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
}
