package backend.club_d;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clubd")
public class ClubController {

    private final ClubRepository clubRepository;

    @GetMapping
    public List<ClubD> getAllClubs() {
        return clubRepository.findAll();
    }

    @RequestMapping
    public ClubD createClubD(@RequestBody ClubD clubD) {
        return clubRepository.save(clubD);
    }
}