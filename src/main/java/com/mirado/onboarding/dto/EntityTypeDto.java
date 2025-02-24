package com.mirado.onboarding.dto;

import com.mirado.onboarding.models.EntityType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntityTypeDto {
    private Integer id;
    private String name;

    public static EntityTypeDto fromEntity(EntityType entityType) {
        if (entityType == null) return null;
        return EntityTypeDto.builder()
                .id(entityType.getId())
                .name(entityType.getName())
                .build();
    }

    public static EntityType toEntity(EntityTypeDto entityTypeDto) {
        if (entityTypeDto == null) return null;
        EntityType entityType = new EntityType();
        entityType.setId(entityTypeDto.getId());
        entityType.setName(entityTypeDto.getName());
        return entityType;
    }
}
