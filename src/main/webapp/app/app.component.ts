import { Component } from '@angular/core';
import { BibliographyService } from './service/bibliography.service'

@Component({
    selector: 'my-app',
    templateUrl: 'app/template/home.html',
    providers: [BibliographyService]
})
export class AppComponent {
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