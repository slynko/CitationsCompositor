package com.khai.db.repository;

import com.khai.database.CitationModel;
import org.springframework.data.repository.CrudRepository;

public interface BibliographyRepository extends CrudRepository<CitationModel, Long> {
}
