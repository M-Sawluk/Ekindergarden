package ekindergarten.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "users")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 45, nullable = false)
    private String name;
    @Column(length = 45, nullable = false)
    private String surname;
    @Column(length = 11, nullable = false, unique = true)
    private String pesel;
    @ManyToMany(mappedBy = "children")
    private Set<User> users;

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(pesel);
        hcb.append(users);
        return hcb.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Child)) {
            return false;
        }
        Child that = (Child) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(pesel, that.pesel);
        eb.append(users, that.users);
        return eb.isEquals();
    }

    public static class Builder {
        private Child instance;

        public Builder() {
            instance = new Child();
        }

        public Builder withName(String name) {
            instance.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            instance.surname = surname;
            return this;
        }

        public Builder withPesel(String pesel) {
            instance.pesel = pesel;
            return this;
        }

        public Child build() {
            return instance;
        }
    }
}
