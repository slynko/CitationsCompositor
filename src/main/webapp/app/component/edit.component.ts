import { Component, Inject } from '@angular/core';
import {BibliographyService} from "../service/bibliography.service";
import { Router } from '@angular/router';
import {Bibliography} from "../model/Bibliography";

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
        this.bibliography = new Bibliography();
    }

    public bibliography: Bibliography;

    addAll(bibliographies: string[]) {
        this._bibliographyService.addAll(bibliographies)
            .subscribe(
                res => {},
                err => {}
            );
    }

    add($event) {
        this._bibliographyService.add(this.bibliography)
            .subscribe(
                res => {},
                err => {}
            );
        $event.preventDefault();
        this.router.navigate(['/']);
    }
}
