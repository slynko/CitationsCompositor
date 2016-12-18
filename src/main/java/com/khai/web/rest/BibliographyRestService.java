package com.khai.web.rest;

import com.khai.db.model.CitationModel;
import com.khai.model.ComposeBibliographiesBody;
import com.khai.db.service.BibliographyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("rest/bibliographies")
public class BibliographyRestService {

    @Value("${dstu.files.folder.path}")
    private String dstuFolderPath;
    @Autowired
    private BibliographyService bibliographyService;

    public BibliographyRestService() {
    }

    @GetMapping
    @RequestMapping("/dstu/files")
    public List<String> getFileNames() {
        List<String> files = new ArrayList<>();
        try(Stream<Path> paths = Files.walk(Paths.get(dstuFolderPath))) {
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

    @GetMapping
    public List<String> getAll() {
        return bibliographyService.findAll()
                .stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void saveAll(@RequestBody List<CitationModel> bibliographies) {
        bibliographyService.saveAll(bibliographies);
    }

    @PostMapping
    @RequestMapping("/add")
    public void addBibliography(@RequestBody CitationModel model) {
        bibliographyService.add(model);
    }

    @PostMapping
    @RequestMapping("/composed")
    public List<String> getComposedBibliographies(@RequestBody ComposeBibliographiesBody composeBibliographiesBody) {

        // some logic with bibliographies will be implemented here

        return composeBibliographiesBody.getBibliographyKeys()
                .stream()
                .map(bibliography -> bibliography = bibliography.concat("."))
                .collect(Collectors.toList());
    }
}
