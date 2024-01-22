package backend.club;

import backend.club.util.ClubCreateDto;
import backend.club.util.ClubDto;
import backend.user.UserRepository;
import backend.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class  ClubService {
    private final ClubRepository clubRepository;
    private final UserRepository userRepository;
    public boolean isUserAdmin(String username) {
        Users user = userRepository.findByUsername(username);
        return user != null && "admin".equalsIgnoreCase(user.getLevel());
    }
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }
    public Club addClub(ClubCreateDto clubCreateDto) throws Exception {
        Users existingUser = userRepository.findByUsername(clubCreateDto.getUsers().getUsername());
        if (existingUser != null) {
            if(isUserAdmin(existingUser.getUsername())) {
                Club newClub = new Club();
                newClub.setTitle(clubCreateDto.getTitle());
                newClub.setDetails(clubCreateDto.getClubDetails());
                newClub.setDate(clubCreateDto.getDate());
                newClub.setUsers(existingUser);
                return clubRepository.save(newClub);
            } else {
                throw new Exception("User does not have admin level");
            }
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
