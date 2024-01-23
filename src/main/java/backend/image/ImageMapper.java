package backend.image;

public class ImageMapper {

    public static ImageUploadDto mapImageToDto(Image image) {
        return ImageUploadDto.builder()
                .name(image.getName())
                .type(image.getType())
                .data(image.getData())
                .build();
    }

    public static Image mapDtoToImage(ImageUploadDto imageDto) {
        return Image.builder()
                .name(imageDto.getName())
                .type(imageDto.getType())
                .data(imageDto.getData())
                .build();
    }
}
