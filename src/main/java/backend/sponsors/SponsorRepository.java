package backend.sponsors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SponsorRepository extends JpaRepository<Sponsors, UUID> {
    Sponsors findBySponsor(String sponsor);

    void deleteBySponsor(String sponsor);
}
