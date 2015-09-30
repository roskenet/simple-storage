package de.roskenet.simplestorage.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import de.roskenet.simplestorage.entity.Image;

@RepositoryRestResource
public interface ImageRepository extends JpaRepository<Image, UUID>{

}
