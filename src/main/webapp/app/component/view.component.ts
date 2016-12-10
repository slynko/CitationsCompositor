import { Component } from '@angular/core';
import { BibliographyService } from '../service/bibliography.service'

@Component({
    selector: 'view-component',
    templateUrl: 'app/static/template/view.html',
    providers: [BibliographyService]
})
export class ViewComponent {
    constructor(private _bibliographyService: BibliographyService){
        this._bibliographyService = _bibliographyService;
    }

    getAll() {
        this.error = "";
        this.bibliographies = [];
        this._bibliographyService.getAll()
            .subscribe(
                data => this.bibliographies = data,
                error => this.error = "Bibliography is invalid."
            );
    }

    clearAll() {
        this.bibliographies = [];
    }
}