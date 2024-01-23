package backend.image;

import jakarta.persistence.Lob;
import lombok.*;

@Data
@Builder(builderClassName = "ImageUploadDtoBuilder")
@AllArgsConstructor
@NoArgsConstructor
public class ImageUploadDto extends Image {
    private String name;
    private String type;
    @Lob
    private byte[] data;
    public static ImageUploadDtoBuilder builder() {
        return new ImageUploadDtoBuilder();
    }

    public static class ImageUploadDtoBuilder extends ImageBuilder {
    }
}
