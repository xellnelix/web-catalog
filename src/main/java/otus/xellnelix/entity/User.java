package otus.xellnelix.entity;

import jakarta.annotation.Nonnull;
import jdk.jfr.Description;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "user", schema = "public")
@Description("Пользователь")
public class User {
    @Id
    private Long id;

    @Nonnull
    private String login;

    @Nonnull
    private String password;

    @Nonnull
    private String authority;

    @MappedCollection(idColumn = "user_id")
    private Cart cart;

    @PersistenceCreator
    public User(Long id, String login, String password, String authority, Cart cart) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.authority = authority;
        this.cart = cart;
    }

    public User(String login, String password, String authority, Cart cart) {
        this(null, login, password, authority, cart);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
