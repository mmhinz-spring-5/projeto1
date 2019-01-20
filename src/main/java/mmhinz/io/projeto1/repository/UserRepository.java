package mmhinz.io.projeto1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import mmhinz.io.projeto1.entity.User;

public interface UserRepository extends MongoRepository<User, Long> {
	
	//@Query ("select u from User u where u.name like %?1%")
	//User findByNameQualquerCoisa (String name);
	
	User findByName (String name);
	
	@Query ("{'email' : ?0 }")
	User findByEmailQualquerCoisa (String email);
	
	User findByEmail (String email);

}
