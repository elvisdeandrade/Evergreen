package br.com.evergreenapi.Repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import br.com.evergreenapi.Domain.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long>{
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String Password);

    
}
