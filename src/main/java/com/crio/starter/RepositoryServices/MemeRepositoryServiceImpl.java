package com.crio.starter.RepositoryServices;

import java.util.ArrayList;
import java.util.List;
import com.crio.starter.dataModel.MemesEntity;
import com.crio.starter.exchangeDTO.Memes;
import com.crio.starter.repository.MemeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemeRepositoryServiceImpl implements MemeRepositoryService {
    @Autowired
    private MemeRepository memeRepository;
    private ModelMapper modelMapper = new ModelMapper();
    
    @Override
    public Memes addMeme(Memes meme) {
        MemesEntity addMeme = modelMapper.map(meme,MemesEntity.class);
        MemesEntity addedMeme = memeRepository.save(addMeme);
        Memes memeAfterBeingAddedToDatabase = modelMapper.map(addedMeme,Memes.class);
        return memeAfterBeingAddedToDatabase;
    }

    @Override
    public boolean findByMeme(Memes meme) {
        MemesEntity mEntity = memeRepository.findByMemeOwnerAndMemeCaptionAndMemeUrl(meme.getMemeOwner(), meme.getMemeCaption(), meme.getMemeUrl());
        return(mEntity==null)?false:true;
    
    }

    @Override
    public List<Memes> findMemesFromRepository() {
        List<Memes>memes = new ArrayList<>();
        List<MemesEntity> memesListFromDatabase =  memeRepository.findAll();
        for(MemesEntity mEntity:memesListFromDatabase){
            memes.add(modelMapper.map(mEntity,Memes.class));
        }
        return memes;
    }

    @Override
    public Memes findMemeById(String id) {
        MemesEntity memesEntity = memeRepository.findById(id).orElse(null);
        if(memesEntity==null){
            return null;
        }else{
            Memes meme = modelMapper.map(memesEntity,Memes.class);
            return meme;

        }
    }

    @Override
    public void deleteMemes() {
        memeRepository.deleteAll();  
    }
    
}
