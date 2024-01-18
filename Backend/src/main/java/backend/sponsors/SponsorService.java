package backend.sponsors;

import backend.sponsors.util.SponsorsDto;
import backend.user.UserRepository;
import backend.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class SponsorService {
    private final SponsorRepository sponsorRepository;
    private final UserRepository userRepository;

    public List<Sponsors> getAllSponsors() {
        return sponsorRepository.findAll();
    }

    public Sponsors addSponsor(Sponsors sponsors) throws Exception {
        // Check if the user with the provided username exists
        Users existingUser = userRepository.findByUsername(sponsors.getUsers().getUsername());

        if (existingUser != null) {
            // Set the user information from the existing user
            sponsors.getUsers().setId(existingUser.getId());
            sponsors.getUsers().setEmail(existingUser.getEmail());
            sponsors.getUsers().setLevel(existingUser.getLevel());

            // Save the sponsor
            return sponsorRepository.save(sponsors);
        } else {
            throw new Exception("User not found");
        }
    }

    public Sponsors getSponsorsById(UUID id) {
        return sponsorRepository.findById(id).orElse(null);
    }

    public Sponsors getSponsorsBySponsor(String sponsor) {
        return sponsorRepository.findBySponsor(sponsor);
    }

    public void deleteSponsorsById(UUID id, UUID userId) throws Exception {
        if (userRepository.existsById(userId)) {
            sponsorRepository.deleteById(id);
        } else {
            throw new Exception("User not found");
        }
    }

    public void deleteSponsorsBySponsor(String sponsor) {
        sponsorRepository.deleteBySponsor(sponsor);
    }


    public void updateSponsorsBySponsor(String sponsorName, SponsorsDto sponsorsDto) {
        // Find the existing sponsor by sponsor name
        Sponsors existingSponsor = sponsorRepository.findBySponsor(sponsorName);

        if (existingSponsor != null) {
            // Update the fields only if the corresponding fields in sponsorsDto are not null
            if (sponsorsDto.getSponsor() != null) {
                existingSponsor.setSponsor(sponsorsDto.getSponsor());
            }
            if (sponsorsDto.getSponsorDetails() != null) {
                existingSponsor.setSponsorDetails(sponsorsDto.getSponsorDetails());
            }
            if (sponsorsDto.getSponsorLink() != null) {
                existingSponsor.setSponsorLink(sponsorsDto.getSponsorLink());
            }

            // Save the updated sponsor
            sponsorRepository.save(existingSponsor);
        } else {
            throw new RuntimeException("Sponsor not found");
        }
    }


    public Sponsors getSponsorsBySponsorName(String sponsor) {
        return sponsorRepository.findBySponsor(sponsor);
    }


}

