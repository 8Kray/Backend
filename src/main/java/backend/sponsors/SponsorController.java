package backend.sponsors;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sponsors")
public class SponsorController {

    private final SponsorRepository sponsorRepository;

    @GetMapping
    public List<Sponsors> getAllSponsors() {
        return sponsorRepository.findAll();
    }

    @RequestMapping
    public Sponsors createSponsors(@RequestBody Sponsors sponsors) {
        return sponsorRepository.save(sponsors);
    }
}