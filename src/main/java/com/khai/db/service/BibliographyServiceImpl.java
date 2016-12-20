package com.khai.db.service;

import com.google.common.collect.Lists;
import com.khai.db.model.CitationModel;
import com.khai.db.repository.BibliographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of bibliography crud service.
 */
@Service
public class BibliographyServiceImpl implements BibliographyService {
    @Autowired
    private BibliographyRepository bibliographyRepository;

    @Override
    public List<CitationModel> findAll() {
        return Lists.newArrayList(bibliographyRepository.findAll());
    }

    @Override
    public void saveAll(Iterable<CitationModel> bibliographies) {
        bibliographyRepository.save(bibliographies);
    }

    @Override
    public CitationModel add(CitationModel model) {
        return bibliographyRepository.save(model);
    }
}
