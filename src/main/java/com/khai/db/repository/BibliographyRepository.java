package com.khai.db.repository;

import com.khai.db.model.CitationModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Bibliography crud repository.
 */
public interface BibliographyRepository extends PagingAndSortingRepository<CitationModel, Long> {
    CitationModel findByTitle(String title);
}
