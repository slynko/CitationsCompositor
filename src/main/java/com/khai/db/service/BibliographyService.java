package com.khai.db.service;

import com.khai.db.model.CitationModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Bibliography crud service.
 */
public interface BibliographyService {
    /**
     * Find all citations.
     * @return all citations
     */
    List<CitationModel> findAll();

    Page<CitationModel> findAll(PageRequest pageRequest);

    int countAll();
    /**
     * Save all bibliographies.
     * @param bibliographies to save
     */
    void saveAll(Iterable<CitationModel> bibliographies);

    /**
     * Add a bibliography.
     * @param model to add
     * @return added model
     */
    CitationModel add(CitationModel model);

    List<CitationModel> findByTitles(List<String> titles);
}
