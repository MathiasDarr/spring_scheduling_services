package org.mddarr.providerservice.models;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("provider_department")
public class Provider {

    @PrimaryKey
    private ProviderKey key;

    @Column("last_name")
    private String lastName;

    public Provider(final ProviderKey key, final String lastName) {
        this.key = key;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" + "key=" + key + ", lastName='" + lastName  + '}';
    }

    public ProviderKey getKey() {
        return key;
    }

    public void setKey(ProviderKey key) {
        this.key = key;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

