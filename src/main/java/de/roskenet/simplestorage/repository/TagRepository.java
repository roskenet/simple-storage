package de.roskenet.simplestorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.roskenet.simplestorage.entity.Tag;

@RepositoryRestResource
public interface TagRepository extends JpaRepository<Tag, String>{
//
}
