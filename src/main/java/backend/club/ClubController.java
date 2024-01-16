package backend.club;

import backend.club.util.ClubDto;
import backend.club.util.ClubMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/club")
public class ClubController {

    private final ClubRepository clubRepository;
    private final ClubService clubService;

    @GetMapping("/all")
    public ResponseEntity<List<ClubDto>> getAllClubs() {
        List<Club> clubs = clubService.getAllClubs();
        List<ClubDto> clubDtoList = ClubMapper.mapToDtoList(clubs);
        return new ResponseEntity<>(clubDtoList, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Club> addClub(@RequestBody Club club) {
        try {
            Club newClub = clubService.addClub(club);
            return new ResponseEntity<>(newClub, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClubDto> getClubById(@PathVariable UUID id) {
        Club club = clubService.getClubById(id);
        if (club != null) {
            ClubDto clubDto = ClubMapper.toDto(club);
            return new ResponseEntity<>(clubDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/search")
    public ResponseEntity<ClubDto> getClubByTitle(@RequestParam String title) {
        Club club = clubService.getClubByTitle(title);
        if (club != null) {
            ClubDto clubDto = ClubMapper.toDto(club);
            return new ResponseEntity<>(clubDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{club}")
    public ResponseEntity<String> updateClubByClub(@RequestParam String club, @RequestBody ClubDto clubDto) {
        try {
            clubService.updateClubByTitle(club, clubDto);
            return ResponseEntity.status(HttpStatus.OK).body("Club updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Club not found");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClubById(@PathVariable UUID id) {
        try {
            clubService.deleteClubById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Club deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Club not found");
        }
    }

 }