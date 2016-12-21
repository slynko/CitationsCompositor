package com.khai.db.repository;

import com.khai.db.model.CitationModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Bibliography crud repository.
 */
public interface BibliographyRepository extends CrudRepository<CitationModel, Long> {
    List<CitationModel> findByTitle(List<String> titles);
}
