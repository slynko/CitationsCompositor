package com.khai.web.rest;

import com.khai.db.model.CitationModel;
import com.khai.db.service.BibliographyService;
import com.khai.model.rest.ComposeBibliographiesBody;
import com.khai.web.model.File;
import com.khai.xmlnew.StandardManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Bibliography rest service.
 */
@RestController
@RequestMapping("rest/bibliographies")
public class BibliographyRestService {

    @Value("${dstu.files.folder.path}")
    private String dstuFolderPath;
    @Autowired
    private BibliographyService bibliographyService;

    /**
     * Get dstu file names.
     *
     * @return list of dstu file names
     */
    @GetMapping
    @RequestMapping("/dstu/files")
    public List<String> getFileNames() {
        List<String> files = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(Paths.get(dstuFolderPath))) {
            paths.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    files.add(filePath.toFile().getName());
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return files;
    }

    @PostMapping
    @RequestMapping("/dstu/types")
    public List<String> getDstuTypes(@RequestBody File file) {
        // TODO: replace test list with real one
        List<String> types = new ArrayList<>();
        types.add("some type");
        return types;
        //return StandardManager.getInstance().getTypesOfStandard(file.getType());
    }

    /**
     * Get all bibliographies from db.
     *
     * @return list of bibliographies
     */
    @GetMapping
    public List<String> getAll() {
        return bibliographyService.findAll()
                .stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    /**
     * Save all bibliographies
     *
     * @param bibliographies to save
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAll(@RequestBody List<CitationModel> bibliographies) {
        bibliographyService.saveAll(bibliographies);
    }

    /**
     * Add a bibliography to db
     *
     * @param model to add
     */
    @PostMapping
    @RequestMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CitationModel addBibliography(@RequestBody CitationModel model) {
        return bibliographyService.add(model);
    }

    /**
     * Compose bibliographies using dstu file business logic.
     *
     * @param bibliographies to compose
     * @return composed bibliographies
     */
    @PostMapping
    @RequestMapping("/composed")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getComposedBibliographies(@RequestBody ComposeBibliographiesBody bibliographies) {
        final List<CitationModel> citations = bibliographyService
                .findByTitles(bibliographies.getBibliographyKeys());
        return StandardManager.getInstance().makeCitations(bibliographies.getFileName(),
                bibliographies.getDstuType(), citations);
    }

}
