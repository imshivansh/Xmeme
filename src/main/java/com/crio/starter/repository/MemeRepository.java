package com.crio.starter.repository;
import com.crio.starter.dataModel.MemesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepository extends MongoRepository<MemesEntity,String> {
    public MemesEntity findByMemeOwnerAndMemeCaptionAndMemeUrl(String memeOwner,String memeCaption,String memeUrl);

}

