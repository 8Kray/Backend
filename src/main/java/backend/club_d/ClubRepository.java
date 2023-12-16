package backend.club_d;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Repository
public interface ClubRepository extends JpaRepository<ClubD, UUID> {

    List<ClubD> findClubDByTitle(String title);

    List<ClubD> findClubDBydate(Date date);

    void deleteByTitle(String title);

    void deleteByDate(Date date);
}
