package backend.sponsors;

import backend.sponsors.util.SponsorsDto;
import backend.sponsors.util.SponsorsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sponsors")
public class SponsorController {

    private final SponsorRepository sponsorRepository;
    private final SponsorService sponsorService;
    @GetMapping("/all")
    public ResponseEntity<List<SponsorsDto>> getAllSponsors() {
        List<Sponsors> sponsors = sponsorService.getAllSponsors();
        List<SponsorsDto> sponsorsDtoList = SponsorsMapper.mapToDtoList(sponsors);
        return new ResponseEntity<>(sponsorsDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SponsorsDto> getSponsorById(@PathVariable UUID id) {
        Sponsors sponsor = sponsorService.getSponsorsById(id);
        if (sponsor != null) {
            SponsorsDto sponsorsDto = SponsorsMapper.toDto(sponsor);
            return new ResponseEntity<>(sponsorsDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<SponsorsDto> getSponsorBySponsorName(@RequestParam String sponsorName) {
        Sponsors sponsor = sponsorService.getSponsorsBySponsorName(sponsorName);
        if (sponsor != null) {
            SponsorsDto sponsorsDto = SponsorsMapper.toDto(sponsor);
            return new ResponseEntity<>(sponsorsDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Sponsors> addSponsor(@RequestBody Sponsors sponsors) {
        try {
            Sponsors newSponsor = sponsorService.addSponsor(sponsors);
            return new ResponseEntity<>(newSponsor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update{sponsor}")
    public ResponseEntity<String> updateSponsorsBySponsor(@RequestParam String sponsor, @RequestBody SponsorsDto sponsorsDto) {
        try {
            sponsorService.updateSponsorsBySponsor(sponsor, sponsorsDto);
            return ResponseEntity.status(HttpStatus.OK).body("Sponsors updated successfully");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSponsor(@PathVariable UUID id, @RequestParam UUID userId) {
        try {
            sponsorService.deleteSponsorsById(id, userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteSponsorBySponsorName(@RequestParam String sponsorName) {
        sponsorService.deleteSponsorsBySponsor(sponsorName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
