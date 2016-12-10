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
        this.error = "";
        this.bibliographies = [];
    }

    private error: string;
    private bibliographies: string[];

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
    }
}