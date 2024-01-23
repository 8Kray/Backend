package backend.image;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "image")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Image implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String type;
    @Lob
    private byte[] data;



}

