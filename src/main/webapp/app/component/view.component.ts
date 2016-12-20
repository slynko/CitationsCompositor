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

    ngOnInit() {
        this.getAllBibliographies();
        this.getAllDstuFiles();
        this.clearAll();
    }

    private fileName: string;
    private error: string;
    private bibliographies: string[];
    private optionsMap: string[];
    private selectedBibliographies: string[];
    private dstuFiles: string[];
    public composed = false;
    
    getAllDstuFiles() {
        this._bibliographyService.getAllDstuFiles()
            .subscribe(
                data => this.dstuFiles = data,
                error => this.error = "Something went wrong."
            );
    }

    getAllBibliographies() {
        this.error = "";
        this.bibliographies = [];
        this._bibliographyService.getAllBibliographies()
            .subscribe(
                data => this.bibliographies = data,
                error => this.error = "Something went wrong."
            );
    }

    getComposedBibliographies($event) {
        this.selectedBibliographies = this.getSelectedBibliographies();
        this._bibliographyService.getComposedBibliographies(this.selectedBibliographies, this.fileName)
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

    getSelectedBibliographies(): string[] {
        var selectedBibliographies = [];
        for (var key in this.optionsMap) {
            if (this.optionsMap.hasOwnProperty(key) && this.optionsMap[key]) {
                selectedBibliographies.push(key);
            }
        }
        return selectedBibliographies;
    }

    callType(value){
        this.fileName = value;
    }
}