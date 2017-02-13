import {Component, Inject} from '@angular/core';
import {BibliographyService} from "../service/bibliography.service";
import {Bibliography} from "../model/Bibliography";
import {Person} from "../model/Person";

@Component({
    selector: 'edit-component',
    templateUrl: 'app/static/template/view.html',
    providers: [BibliographyService]
})
export class ViewComponent {
    existingBibliographies:string[];
    composedBibliographies:string[];
    newBibliography:Bibliography;

    dstuFiles:string[];
    dstuSelectedFile:string;
    dstuTypes:string[];
    dstuSelectedType:string;
    checkboxMap:string[];

    error:string;
    bibliographyAddedSuccessfully:boolean;

    constructor(@Inject(BibliographyService) private bibliographyService:BibliographyService) {
        this.bibliographyService = bibliographyService;
    }

    ngOnInit() {
        this.initPage();
    }

    initPage() {
        this.initAddForm();
        this.initComposeForm();
    }

    initAddForm() {
        this.newBibliography = new Bibliography();
        this.newBibliography.authors = [new Person()];
        this.newBibliography.editors = [new Person()];
    }

    initComposeForm() {
        this.getAllBibliographies();
        this.getAllDstuFiles();
        this.checkboxMap = [];
        this.error = "";
    }

    getAllDstuFiles() {
        this.bibliographyService.getAllDstuFiles()
            .subscribe(
                data => this.dstuFiles = data,
                error => this.error = "Something went wrong."
            );
    }

    getAllDstuTypes() {
        this.bibliographyService.getDstuTypes(this.dstuSelectedFile)
            .subscribe(
                data => this.dstuTypes = data,
                error => this.error = "Something went wrong."
            );
    }

    getAllBibliographies() {
        this.bibliographyService.getAllBibliographies()
            .subscribe(
                data => this.existingBibliographies = data,
                error => this.error = "Something went wrong."
            );
    }

    updateCheckedOptions(bibliography, event) {
        this.checkboxMap[bibliography] = event.target.checked;
    }

    getComposedBibliographies() {
        var selectedBibliographies = this.getSelectedBibliographies();
        this.bibliographyService.getComposedBibliographies(selectedBibliographies, this.dstuSelectedFile, this.dstuSelectedType)
            .subscribe(
                data => this.composedBibliographies = data,
                error => this.error = "Something went wrong."
            );
    }

    getSelectedBibliographies():string[] {
        var selectedBibliographies = [];
        for (var key in this.checkboxMap) {
            if (this.checkboxMap.hasOwnProperty(key) && this.checkboxMap[key]) {
                selectedBibliographies.push(key);
            }
        }
        return selectedBibliographies;
    }

    addAuthor() {
        this.newBibliography.authors.push(new Person());
    }

    addEditor() {
        this.newBibliography.editors.push(new Person());
    }

    removeAuthor(author:Person) {
        this.newBibliography.authors.splice(this.newBibliography.authors.indexOf(author), 1);
    }

    removeEditor(editor:Person) {
        this.newBibliography.editors.splice(this.newBibliography.editors.indexOf(editor), 1);
    }

    addBibliography() {
        this.bibliographyService.add(this.newBibliography)
            .subscribe(
                res => {
                    this.initAddForm();
                    this.getAllBibliographies();
                    this.bibliographyAddedSuccessfully = true;
                    var self = this;
                    setTimeout(function() {
                        self.bibliographyAddedSuccessfully = false;
                    }, 3000);

                }
            );
    }
}
