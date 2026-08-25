package Application;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user, Long> {

	    Optional<user> findByEmail(String email);
	    boolean existsByEmail(String email);

	}

