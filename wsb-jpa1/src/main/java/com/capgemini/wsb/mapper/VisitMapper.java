package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public class VisitMapper {
    public static VisitTO mapToDTO(final VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }
        final VisitTO visitDTO = new VisitTO();
        visitDTO.setId(visitEntity.getId());
        visitDTO.setDescription(visitEntity.getDescription());
        visitDTO.setTime(visitEntity.getTime());
        return visitDTO;
    }

    public static VisitEntity mapToEntity(final VisitTO visitDTO) {
        if (visitDTO == null) {
            return null;
        }
        final VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitDTO.getId());
        visitEntity.setDescription(visitDTO.getDescription());
        visitEntity.setTime(visitDTO.getTime());
        return visitEntity;
    }
}
