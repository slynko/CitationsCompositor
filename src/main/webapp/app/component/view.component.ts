import { Component, Inject} from '@angular/core';
import { BibliographyService } from '../service/bibliography.service'

@Component({
    selector: 'view-component',
    templateUrl: 'app/static/template/view.html',
    providers: [BibliographyService]
})
export class ViewComponent {
    constructor(@Inject(BibliographyService) private _bibliographyService: BibliographyService){
        this._bibliographyService = _bibliographyService;
        this.optionsMap = [];
    }

    private error: string;
    private bibliographies: string[];
    private optionsMap: string[];
    private selectedBibliographies: string[];

    getAll() {
        this.error = "";
        this.bibliographies = [];
        this._bibliographyService.getAll()
            .subscribe(
                data => this.bibliographies = data,
                error => this.error = "Something went wrong."
            );
    }

    clearAll() {
        this.bibliographies = [];
        this.selectedBibliographies = [];
        this.optionsMap = [];
    }

    updateCheckedOptions(bibliography, event) {
        this.optionsMap[bibliography] = event.target.checked;
    }

    compose() {
        this.selectedBibliographies = this.getSelectedBibliographies();
    }

    getSelectedBibliographies(): string[] {
        var selectedBibliographies = [];
        for (var key in this.optionsMap) {
            if (this.optionsMap.hasOwnProperty(key) && this.optionsMap[key]) {
                selectedBibliographies.push(key);
            }
        }
        return selectedBibliographies;
    }
}