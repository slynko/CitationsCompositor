package com.khai.db.repository;

import com.khai.db.model.CitationModel;
import org.springframework.data.repository.CrudRepository;

/**
 * Bibliography crud repository.
 */
public interface BibliographyRepository extends CrudRepository<CitationModel, Long> {
}
