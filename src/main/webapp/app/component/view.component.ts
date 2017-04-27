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
    existingBibliographies: string[];
    composedBibliographies: string[];
    newBibliography: Bibliography;

    dstuFiles: string[];
    dstuSelectedFile: string;
    dstuTypes: Object;
    dstuSelectedType: string;
    checkboxMap: string[];
    pagesAmount: number[];
    pageNumber: number;

    error: string;
    bibliographyAddedSuccessfully: boolean;

    constructor(@Inject(BibliographyService) private bibliographyService: BibliographyService) {
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
        this.newBibliography.authors = [];
        this.newBibliography.editors = [];
    }

    initComposeForm() {
        this.getPagesNumber();
        if (!this.pagesAmount || this.pagesAmount <= 1) {
            this.updatePage(0);
        }
        this.getAllDstuFiles();
        this.checkboxMap = [];
        this.error = "";
    }

    getPagesNumber() {
        this.bibliographyService.getPagesNumber()
            .subscribe(
                data => this.pagesAmount = Array(data).fill().map((x, i) => i),
                error => this.error = "Something went wrong."
            );
    }

    previousPage() {
        if (this.pageNumber > 0) {
            this.pageNumber--;
        }
        this.updatePage(this.pageNumber);
    }

    nextPage() {
        if (this.pageNumber < this.pagesAmount.length - 1) {
            this.pageNumber++;
        }
        this.updatePage(this.pageNumber);
    }

    updatePage(pageNumber: number) {
        this.pageNumber = pageNumber;
        this.bibliographyService.getPage(pageNumber)
            .subscribe(
                data => this.existingBibliographies = data,
                error => this.error = "Something went wrong."
            );
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

    updateCheckedOptions(bibliography, event) {
        this.checkboxMap[bibliography] = event.target.checked;
    }

    getComposedBibliographies() {
        var selectedBibliographies = this.getSelectedBibliographies();
        this.bibliographyService.getComposedBibliographies(selectedBibliographies, this.dstuSelectedFile, this.dstuSelectedType)
            .subscribe(
                data => {
                    this.composedBibliographies = data;
                    this.error = "";
                },
                error => this.error = "Something went wrong. Please check if you have prefilled all fields"
            );
    }

    getSelectedBibliographies(): string[] {
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

    removeAuthor(author: Person) {
        this.newBibliography.authors.splice(this.newBibliography.authors.indexOf(author), 1);
    }

    removeEditor(editor: Person) {
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
                    setTimeout(function () {
                        self.bibliographyAddedSuccessfully = false;
                    }, 3000);

                }
            );
    }

    dstuTypesKeys() {
        return Object.keys(this.dstuTypes);
    }

    isChosen(bibliography): boolean {
        return this.checkboxMap[bibliography] != undefined;
    }
}
