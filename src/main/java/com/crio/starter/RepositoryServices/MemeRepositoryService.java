package com.crio.starter.RepositoryServices;

import java.util.List;
import com.crio.starter.exchangeDTO.Memes;
public interface MemeRepositoryService {

    public Memes addMeme(Memes memes);
    public boolean findByMeme(Memes meme);
    public List<Memes> findMemesFromRepository();
    public Memes findMemeById(String id);
    public void deleteMemes();

    
}



