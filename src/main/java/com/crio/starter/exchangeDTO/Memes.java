package com.crio.starter.exchangeDTO;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Memes {
    @Id
    private String id;

    @NonNull
    @JsonProperty("name")
    private String memeOwner;

    @NonNull
    @JsonProperty("caption")

    private String memeCaption;
    @NonNull
    @JsonProperty("url")
    private String memeUrl;

    
}

