package com.khai.web.listener;

import com.khai.db.model.CitationModel;
import com.khai.db.service.BibliographyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Listener for application context change.
 */
@Component
public class Listener implements ApplicationListener {

    @Autowired
    BibliographyService bibliographyService;

    /**
     * Initialise db on context init.
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
            ApplicationContext applicationContext = ((ContextRefreshedEvent) event).getApplicationContext();
            initBibliographies();
        }
    }

    private void initBibliographies() {
        CitationModel citation1 = new CitationModel();
        citation1.setTitle("Some title");

        CitationModel citation2 = new CitationModel();
        citation2.setTitle("Some another title");

        bibliographyService.saveAll(Arrays.asList(citation1, citation2));
    }
}