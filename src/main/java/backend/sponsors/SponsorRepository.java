package backend.sponsors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface SponsorRepository extends JpaRepository<Sponsors, UUID> {
    void deleteSponsorsByName(String sponsor);

    List<Sponsors> findSponsorsByName(String sponsor);
}
