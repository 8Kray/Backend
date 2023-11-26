package backend.club_d;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ClubRepository extends JpaRepository<ClubD, UUID> {

}
