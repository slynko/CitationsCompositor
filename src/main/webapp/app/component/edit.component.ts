import { Component, Inject } from '@angular/core';
import {BibliographyService} from "../service/bibliography.service";
import { Router } from '@angular/router';

@Component({
    selector: 'edit-component',
    templateUrl: 'app/static/template/edit.html',
    providers: [BibliographyService]
})
export class EditComponent {
    constructor(
        @Inject(BibliographyService) private _bibliographyService: BibliographyService,
        @Inject(Router) private router: Router) {
        this._bibliographyService = _bibliographyService;
    }

    addAll(bibliographies: string[]) {
        this._bibliographyService.addAll(bibliographies)
            .subscribe();
    }

    add(bibliography: string) {
        this._bibliographyService.add(bibliography)
            .subscribe();
        this.router.navigate(['/']);
    }
}
