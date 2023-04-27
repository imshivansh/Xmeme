package com.crio.starter.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.crio.starter.exchangeDTO.MemeResponse;
import com.crio.starter.exchangeDTO.Memes;
import com.crio.starter.RepositoryServices.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemeServiceImpl implements MemeService {
    @Autowired
    MemeRepositoryService  memeRepositoryServiceImpl;

    @Override
    public List<Memes> findMemes() {
       List<Memes>memes = memeRepositoryServiceImpl.findMemesFromRepository();
       List<Memes>recent50Memes = new ArrayList<>();
       if(memes.size()>100){
        int size = memes.size()-1;
        int count =0;
        while(count<100){
            //adding recent 100 memes
            recent50Memes.add(memes.get(size));
            size--;
            count++;
        }
       }else{
        Collections.reverse(memes);
        return memes;
       }
        return recent50Memes;

    }

    @Override
    public MemeResponse addMemes(Memes memes) {
        Memes addedMeme = memeRepositoryServiceImpl.addMeme(memes);
        MemeResponse meme = new MemeResponse(addedMeme.getId());
        return meme;
        
    }

    @Override
    public boolean checkIfMemeExist(Memes meme) {
        boolean ans  = memeRepositoryServiceImpl.findByMeme(meme);
        return ans;
    }

    @Override
    public Memes findMemesById(String id) {
        Memes meme =memeRepositoryServiceImpl.findMemeById(id);       
        return meme;
        
    }

    @Override
    public void deleteAll() {
      memeRepositoryServiceImpl.deleteMemes();
        
    }
    

    
}
