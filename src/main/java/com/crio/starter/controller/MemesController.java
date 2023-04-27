package com.crio.starter.controller;

import lombok.extern.log4j.Log4j2;
import java.util.List;
import javax.validation.Valid;

import com.crio.starter.exchangeDTO.*;
import com.crio.starter.service.MemeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(MemesController.memeRestApiPoint)
public class MemesController {

 public static final String memeRestApiPoint = "/memes";
 public static final String findMemeWithIdRestApiPoint = "/{id}";

 @Autowired 
 private MemeService memeService;

 @GetMapping("/")
 public ResponseEntity<List<Memes>>getMemes(){
    List<Memes>memes = memeService.findMemes();
    return ResponseEntity.ok(memes);
    
 }

 @GetMapping(findMemeWithIdRestApiPoint)
 public ResponseEntity<?>getMemeWithId(@PathVariable String id){
    Memes meme  = memeService.findMemesById(id);
    if(meme==null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }else{
        return ResponseEntity.ok().body(meme);
    }
}




 @PostMapping("/")
 public ResponseEntity<?>postMeme(@Valid @RequestBody Memes meme){
    if(meme.getMemeCaption()==null || meme.getMemeOwner()==null || meme.getMemeUrl()==null){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    boolean verifyIfMemeExist = memeService.checkIfMemeExist(meme);

    if(!verifyIfMemeExist){
        MemeResponse response = memeService.addMemes(meme);
        return ResponseEntity.ok().body(response);
    }else{
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

 }

}

