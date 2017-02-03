import {Component, Inject} from '@angular/core';
import {BibliographyService} from '../service/bibliography.service'

@Component({
    selector: 'view-component',
    templateUrl: 'app/static/template/view.html',
    providers: [BibliographyService]
})
export class ViewComponent {
    constructor(@Inject(BibliographyService) private _bibliographyService:BibliographyService) {
        this._bibliographyService = _bibliographyService;
    }

    ngOnInit() {
        this.clearAll();
        this.getAllBibliographies();
        this.getAllDstuFiles();
    }

    getAllDstuFiles() {
        this._bibliographyService.getAllDstuFiles()
            .subscribe(
                data => this.dstuFiles = data,
                error => this.error = "Something went wrong."
            );
    }

    getAllBibliographies() {
        this._bibliographyService.getAllBibliographies()
            .subscribe(
                data => this.bibliographies = data,
                error => this.error = "Something went wrong."
            );
    }

    getComposedBibliographies($event) {
        this.selectedBibliographies = this.getSelectedBibliographies();
        this._bibliographyService.getComposedBibliographies(this.selectedBibliographies, this.fileName, this.dstuType)
            .subscribe(
                data => this.selectedBibliographies = data,
                error => this.error = "Something went wrong."
            );
        this.composed = this.selectedBibliographies.length > 0;
        $event.preventDefault();
    }

    clearAll() {
        this.bibliographies = [];
        this.selectedBibliographies = [];
        this.optionsMap = [];
        this.composed = false;
        this.error = "";
        this.getAllBibliographies();
    }

    updateCheckedOptions(bibliography, event) {
        this.optionsMap[bibliography] = event.target.checked;
    }

    compose($event) {
        this.selectedBibliographies = this.getSelectedBibliographies();
        this.composed = this.selectedBibliographies.length > 0;
        $event.preventDefault();
    }

    getSelectedBibliographies():string[] {
        var selectedBibliographies = [];
        for (var key in this.optionsMap) {
            if (this.optionsMap.hasOwnProperty(key) && this.optionsMap[key]) {
                selectedBibliographies.push(key);
            }
        }
        return selectedBibliographies;
    }

    getDstuTypes() {
        this._bibliographyService.getDstuTypes(this.fileName)
            .subscribe(
                data => this.dstuTypes = data,
                error => this.error = "Something went wrong."
            );
    }
}