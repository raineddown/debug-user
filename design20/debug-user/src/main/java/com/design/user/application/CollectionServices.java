package com.design.user.application;

import com.design.user.adapter.inbound.dto.CollectionDTO;
import com.design.user.application.inbound.CollectionUseCase;
import com.design.user.application.outbound.CollectionRepository;
import com.design.user.domain.Collections;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CollectionServices implements CollectionUseCase {
    @Autowired
    private final CollectionRepository collectionRepository;

    @Override
    public List<CollectionDTO> findAllCollection() {
        return collectionRepository.findAllCollection();
    }

    @Override
    public boolean addCollection(int project_id,int match_id,String collection_time,String images) {
        return collectionRepository.addCollection(project_id,match_id,collection_time,images);
    }

    @Override
    public List<CollectionDTO> findCollection(int user_id) {
        return collectionRepository.findCollection(user_id);
    }

    @Override
    public int countUser() {
        return collectionRepository.countUser();
    }

    @Override
    public int countPrize() {
        return collectionRepository.countPrize();
    }

    @Override
    public int countExpert() {
        return collectionRepository.countExpert();
    }

    @Override
    public int countProject() {
        return collectionRepository.countProject();
    }
}
