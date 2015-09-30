package de.roskenet.simplestorage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.roskenet.simplestorage.entity.Tag;

//@RepositoryRestResource(exported=false)
//@RepositoryRestResource(path="/tags", exported=false)
@RepositoryRestResource
public interface TagRepository extends JpaRepository<Tag, String>{
//	List<Tag> findAllByOrderById();
}
