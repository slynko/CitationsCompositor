package com.khai.db.service;

import com.khai.db.model.CitationModel;

import java.util.List;

/**
 * Bibliography crud service.
 */
public interface BibliographyService {
    List<CitationModel> findAll();
    void saveAll(Iterable<CitationModel> bibliographies);
    CitationModel add(CitationModel model);
}
