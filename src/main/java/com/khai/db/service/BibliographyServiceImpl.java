package com.khai.db.service;

import com.google.common.collect.Lists;
import com.khai.db.model.CitationModel;
import com.khai.db.repository.BibliographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of bibliography crud service.
 */
@Service
public class BibliographyServiceImpl implements BibliographyService {
    @Autowired
    private BibliographyRepository bibliographyRepository;

    /**
     * Find all citations.
     * @return all citations
     */
    @Override
    public List<CitationModel> findAll() {
        return Lists.newArrayList(bibliographyRepository.findAll());
    }

    /**
     * Save all bibliographies.
     * @param bibliographies to save
     */
    @Override
    public void saveAll(Iterable<CitationModel> bibliographies) {
        bibliographyRepository.save(bibliographies);
    }

    /**
     * Add a bibliography.
     * @param model to add
     * @return added model
     */
    @Override
    public CitationModel add(CitationModel model) {
        return bibliographyRepository.save(model);
    }

    @Override
    public List<CitationModel> findByTitles(List<String> titles) {
        List<CitationModel> citations = new ArrayList<>();
        for (String title : titles) {
            CitationModel citation = bibliographyRepository.findByTitle(title);
            if (citation != null) {
                citations.add(citation);
            }
        }
        return citations;
    }


}
