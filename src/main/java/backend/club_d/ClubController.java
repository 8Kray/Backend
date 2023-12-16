package backend.club_d;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clubd")
public class ClubController {

    private final ClubService clubService;

    @PostMapping("/add")
    public ResponseEntity<ClubD> addClub(@RequestBody ClubD clubD) {
        ClubD addedClub = clubService.addClub(clubD);
        return new ResponseEntity<>(addedClub, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClubD>> getAllClubs() {
        List<ClubD> clubList = clubService.getAllClubs();
        return new ResponseEntity<>(clubList, HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<ClubD>> getClubByClubDTitle(@PathVariable String title) {
        List<ClubD> clubList = clubService.getClubByClubTitle(title);
        return new ResponseEntity<>(clubList, HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<ClubD>> getClubByClubDDate(@PathVariable Date date) {
        List<ClubD> clubList = clubService.getClubByClubDate((Data) date);
        return new ResponseEntity<>(clubList, HttpStatus.OK);
    }

    @PutMapping("/update/{id}/{title}")
    public ResponseEntity<ClubD> updateClubTitle(@PathVariable UUID id, @PathVariable String title) {
        ClubD updatedClub = clubService.updateClubTitle(id, title);
        return new ResponseEntity<>(updatedClub, HttpStatus.OK);
    }

    @DeleteMapping("/delete/title/{title}")
    public ResponseEntity<Void> deleteClubByTitle(@PathVariable String title) {
        clubService.deleteClubByClubTitle(title);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/date/{date}")
    public ResponseEntity<Void> deleteClubByDate(@PathVariable Date date) {
        clubService.deleteClubByDate(date);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
