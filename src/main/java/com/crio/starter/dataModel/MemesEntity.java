package com.crio.starter.dataModel;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@Document("memes")
@AllArgsConstructor
public class MemesEntity {
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

