package com.khai.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class BibliographyService {

    @Value("${dstu.files.folder.path}")
    private String dstuFolderPath;

    private static List<String> bibliographyKeys;

    public BibliographyService() {
        BibliographyService.bibliographyKeys = getMockBibliographyKeys();
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
        return BibliographyService.bibliographyKeys;
    }

    @PostMapping
    public void setAll(@RequestBody List<String> bibliographies) {
        BibliographyService.bibliographyKeys = bibliographies;
    }

    @PostMapping
    @RequestMapping("/add")
    public void addBibliography(@RequestBody String bibliography) {
        BibliographyService.bibliographyKeys.add(bibliography);
    }

    @PostMapping
    @RequestMapping("/composed")
    public List<String> getComposedBibliographies(@RequestBody List<String> bibliographyNames) {

        // some logic with bibliographies will be implemented here

        return bibliographyNames
                .stream()
                .map(bibliography -> bibliography = bibliography.concat("."))
                .collect(Collectors.toList());
    }

    private  List<String> getMockBibliographyKeys() {
        List<String> keys = new ArrayList<>();

        keys.add("Author L.L. 1990");
        keys.add("Author D.D. 1991");
        keys.add("Author S.S. 1992");
        keys.add("Author Z.Z. 1993");
        keys.add("Author K.K. 1993");

        return keys;
    }
}
