package backend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
  
    Users findByUsername(String username);

    void deleteByUsername(String username);

    Users findByEmail(String email);
}
