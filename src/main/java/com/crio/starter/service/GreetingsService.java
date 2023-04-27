package com.crio.starter.service;

import com.crio.starter.exchangeDTO.ResponseDto;
import com.crio.starter.repository.GreetingsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class GreetingsService {

  private final GreetingsRepository greetingsRepository;

  public ResponseDto getMessage(String id) {
    return new ResponseDto(greetingsRepository.findByExtId(id).getMessage());
  }
}
