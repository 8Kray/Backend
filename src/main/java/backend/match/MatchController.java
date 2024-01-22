package backend.match;

import backend.match.util.MatchCreateDto;
import backend.match.util.MatchDto;
import backend.match.util.MatchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/match")
public class MatchController {

    private final MatchRepository matchRepository;
    private final MatchService matchService;

    @GetMapping("/all")
    public ResponseEntity<List<MatchDto>> getAllMatch() {
        List<Match> match = matchService.getAllMatches();
        List<MatchDto> matchDtoList = MatchMapper.mapToDtoList(match);
        return new ResponseEntity<>(matchDtoList, HttpStatus.OK);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Match>> getAllMatches() {
        List<Match> match = matchService.getAllMatches();
        return new ResponseEntity<>(match, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Match> addMatch(@RequestBody MatchCreateDto match) {
        try {
            Match newMatch = matchService.addMatch(match);
            return new ResponseEntity<>(newMatch, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<MatchDto> getMatchById(@PathVariable UUID id) {
        Match match = matchService.getMatchById(id);
        if (match != null) {
            MatchDto matchDto = MatchMapper.toDto(match);
            return new ResponseEntity<>(matchDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<MatchDto> getMatchByDate(@RequestParam Date date) {
        Match match = matchService.getMatchByDate(date);
        if (match != null) {
            MatchDto matchDto = MatchMapper.toDto(match);
            return new ResponseEntity<>(matchDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update{date}")
    public ResponseEntity<String> updateMatchByDate(@RequestParam Date date, @RequestBody MatchDto matchDto) {
        try {
            matchService.updateMatchByDate(date, matchDto);
            return ResponseEntity.status(HttpStatus.OK).body("Match updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating match");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMatchById(@PathVariable UUID id) {
        try {
            matchService.deleteMatchById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Match deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting match");
        }
    }


}