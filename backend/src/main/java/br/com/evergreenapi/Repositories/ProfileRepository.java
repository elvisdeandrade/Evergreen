package br.com.evergreenapi.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import br.com.evergreenapi.Domain.Profile;

@RepositoryRestResource
public interface ProfileRepository extends CrudRepository<Profile, Long>{
    
}
