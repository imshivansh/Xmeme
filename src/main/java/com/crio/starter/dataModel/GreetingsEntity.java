package com.crio.starter.dataModel;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Data
@Document(collection = "greetings")
@NoArgsConstructor
@Component
public class GreetingsEntity {

  private String extId;

  private String message;

}
