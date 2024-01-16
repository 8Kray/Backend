package backend.club;

import backend.club.util.ClubDto;
import backend.user.UserRepository;
import backend.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class  ClubService {
    private final ClubRepository clubRepository;
    private final UserRepository user;

    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }
    public Club addClub(Club club) throws Exception {
        Users existingUser = user.findByUsername(club.getUsers().getUsername());
        if (existingUser != null) {
            club.getUsers().setId(existingUser.getId());
            club.getUsers().setEmail(existingUser.getEmail());
            club.getUsers().setLevel(existingUser.getLevel());
            return clubRepository.save(club);
        } else {
            throw new Exception("User not found");
        }
    }
    public Club getClubById(UUID id) {
        return clubRepository.findById(id).orElse(null);
    }
    public Club getClubByTitle(String title) {
        return clubRepository.findByTitle(title);
    }
    public void deleteClubById(UUID id) {
        clubRepository.deleteById(id);
    }

    public void updateClubByTitle(String title, ClubDto clubDto) {

        Club existingClub = clubRepository.findByTitle(title);
        if (existingClub == null) {
            throw new RuntimeException("Club not found");
        }
        existingClub.setTitle(clubDto.getTitle());
        existingClub.setDetails(clubDto.getDetails());
        existingClub.setDate(clubDto.getDate());
        clubRepository.save(existingClub);
    }
}
