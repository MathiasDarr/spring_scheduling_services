package org.mddarr.providerservice.models;

import lombok.AllArgsConstructor;
import org.springframework.data.cassandra.core.mapping.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import static org.springframework.data.cassandra.core.cql.Ordering.DESCENDING;
import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;


@PrimaryKeyClass
public class ProviderKey implements Serializable {

    @PrimaryKeyColumn(name = "department_name", type = PARTITIONED)
    private String first_name;


    @PrimaryKeyColumn(name = "provider_id", ordinal = 1, ordering = DESCENDING)
    private UUID id;

    public ProviderKey(final String first_name, final UUID id) {
        this.first_name = first_name;
        this.id = id;
    }

    public String getFirstName() {

        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PersonKey{"
                + "firstName='"
                + first_name
                + '\''
                + ", id="
                + id
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProviderKey personKey = (ProviderKey) o;

        if (first_name != null ? !first_name.equals(personKey.first_name) : personKey.first_name != null)
            return false;

        return id != null ? id.equals(personKey.id) : personKey.id == null;
    }

    @Override
    public int hashCode() {
        int result = first_name != null ? first_name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}

