package com.softium.seed.database.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "PLACES")
@Builder(toBuilder = true)
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PlaceEntity extends BaseEntity {

    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Builder.Default
    private UUID id = UUID.randomUUID();

}
