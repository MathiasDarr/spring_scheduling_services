package org.mddarr.providerservice.models;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("provider_department")
public class Provider {

    @PrimaryKeyColumn(name="provider_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED )
    private String provider_id;

    @PrimaryKeyColumn(name="department_name", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String department_name;

    public String getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(String provider_id) {
        this.provider_id = provider_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

//    @PrimaryKey
//    private ProviderKey key;
//
//    @Column("last_name")
//    private String lastName;
//
//    public Provider(final ProviderKey key, final String lastName) {
//        this.key = key;
//        this.lastName = lastName;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" + "key=" + key + ", lastName='" + lastName  + '}';
//    }
//
//    public ProviderKey getKey() {
//        return key;
//    }
//
//    public void setKey(ProviderKey key) {
//        this.key = key;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
}

