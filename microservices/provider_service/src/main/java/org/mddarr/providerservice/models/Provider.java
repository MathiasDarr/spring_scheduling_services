package org.mddarr.providerservice.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("provider_department")
@Data
@NoArgsConstructor
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


}

