package backend.sponsors;

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

    private final SponsorService sponsorService;

    @PostMapping("/add")
    public Sponsors addSponsor(@RequestBody Sponsors sponsors) {
        Sponsors addedSponsor = sponsorService.addSponsor(sponsors);
        return new ResponseEntity<>(addedSponsor, HttpStatus.CREATED).getBody();
    }

    @GetMapping("/all")
    public List<Sponsors> getAllSponsors() {
        List<Sponsors> sponsorsList = sponsorService.getAllSponsors();
        return new ResponseEntity<>(sponsorsList, HttpStatus.OK).getBody();
    }

    @GetMapping("/name/{sponsor}")
    public List<Sponsors> getSponsorByName(@PathVariable String sponsor) {
        List<Sponsors> sponsorsList = sponsorService.getSponsorByName(sponsor);
        return new ResponseEntity<>(sponsorsList, HttpStatus.OK).getBody();
    }

    @PutMapping("/update/{id}/{sponsorDetails}")
    public ResponseEntity<Sponsors> updateSponsorDetails(@PathVariable UUID id, @PathVariable String sponsorDetails) {
        Sponsors updateSponsor = sponsorService.updateSponsorDetails(id, sponsorDetails);
        return new ResponseEntity<>(updateSponsor, HttpStatus.OK);
    }

    @PutMapping("/update/{id}/{sponsorLink}")
    public ResponseEntity<Sponsors> updateSponsorLink(@PathVariable UUID id, @PathVariable String sponsorLink) {
        Sponsors updateSponsor = sponsorService.updateSponsorLink(id, sponsorLink);
        return new ResponseEntity<>(updateSponsor, HttpStatus.OK);
    }

    @DeleteMapping("/delete/name/{sponsor}")
    public ResponseEntity<Void> deleteSponsorByName(@PathVariable String sponsor) {
        sponsorService.deleteSponsorByName(sponsor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}