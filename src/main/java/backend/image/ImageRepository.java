package backend.image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface ImageRepository extends JpaRepository<Image, UUID> {

}
