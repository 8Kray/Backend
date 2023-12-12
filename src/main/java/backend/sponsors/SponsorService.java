package backend.sponsors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SponsorService {

    private final SponsorRepository sponsorRepository;

    public Sponsors addSponsor(Sponsors sponsor) {

        return sponsorRepository.save(sponsor);
    }

    public List<Sponsors> getAllSponsors() { return sponsorRepository.findAll(); }

    public void deleteSponsorByName(String sponsor) { sponsorRepository.deleteSponsorsByName(sponsor); }

    public Sponsors updateSponsorDetails(UUID id, String sponsorDetails) {
        Sponsors sponsors = sponsorRepository.findById(id).orElseThrow();
        sponsors.setSponsorDetails(sponsorDetails);
        return sponsorRepository.save(sponsors);
    }

    public Sponsors updateSponsorLink(UUID id, String sponsorLink) {
        Sponsors sponsors = sponsorRepository.findById(id).orElseThrow();
        sponsors.setSponsorLink(sponsorLink);
        return sponsorRepository.save(sponsors);
    }

    public List<Sponsors> getSponsorByName(String sponsor) { return sponsorRepository.findSponsorsByName(sponsor);
    }
}

