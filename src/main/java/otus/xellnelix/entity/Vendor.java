package otus.xellnelix.entity;

import jakarta.annotation.Nonnull;
import jdk.jfr.Description;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table(name = "vendor", schema = "public")
@Description("Производитель")
public class Vendor {
    @Id
    private Long id;

    @Nonnull
    private String name;

    @Nonnull
    @MappedCollection(idColumn = "id")
    private Set<Product> product;

    @PersistenceCreator
    public Vendor(Long id, String name, Set<Product> product) {
        this.id = id;
        this.name = name;
        this.product = product;
    }

    public Vendor(String name, Set<Product> product) {
        this(null, name, product);
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

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }
}
