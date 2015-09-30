package de.roskenet.simplestorage.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.roskenet.simplestorage.entity.Image;

@RepositoryRestResource
public interface ImageRepository extends JpaRepository<Image, UUID>{

}
