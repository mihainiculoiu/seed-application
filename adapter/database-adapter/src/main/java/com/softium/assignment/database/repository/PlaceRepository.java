package com.softium.assignment.database.repository;

import com.softium.assignment.database.entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceEntity, UUID> {



}
