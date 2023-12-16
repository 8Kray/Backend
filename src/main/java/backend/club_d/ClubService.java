package backend.club_d;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClubService {
    private final ClubRepository clubRepository;

    public ClubD addClub(ClubD clubD) {
        return clubRepository.save(clubD);
    }


    public List<ClubD> getAllClubs() { return clubRepository.findAll(); }

    public List<ClubD> getClubByClubTitle(String title) { return clubRepository.findClubDByTitle(title); }

    public List<ClubD> getClubByClubDate(Data date) { return clubRepository.findClubDBydate((Date) date); }

    public ClubD updateClubTitle(UUID id, String title) {
        ClubD clubD = clubRepository.findById(id).orElseThrow();
        clubD.setTitle(title);
        return clubRepository.save(clubD);
    }

    public void deleteClubByClubTitle(String title) {
        clubRepository.deleteByTitle(title);
    }

    public void deleteClubByDate(Date date) {
        clubRepository.deleteByDate(date);
    }


}
