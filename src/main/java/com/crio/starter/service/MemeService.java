package com.crio.starter.service;


import java.util.List;
import com.crio.starter.exchangeDTO.MemeResponse;
import com.crio.starter.exchangeDTO.Memes;


public interface MemeService {
    public List<Memes> findMemes();
    public MemeResponse addMemes(Memes memes);
    public boolean checkIfMemeExist(Memes memes);
    public Memes findMemesById(String id);
    public void deleteAll();

}
