import {Component, Inject} from '@angular/core';
import {BibliographyService} from "../service/bibliography.service";
import {Router} from '@angular/router';
import {Bibliography} from "../model/Bibliography";
import {Person} from "../model/Person";

@Component({
    selector: 'edit-component',
    templateUrl: 'app/static/template/edit.html',
    providers: [BibliographyService]
})
export class EditComponent {
    constructor(@Inject(BibliographyService) private _bibliographyService:BibliographyService,
                @Inject(Router) private router:Router) {
        this._bibliographyService = _bibliographyService;
        this.bibliography.authors = [];
        this.bibliography.editors = [];
    }

    public bibliography:Bibliography = new Bibliography();

    addAll(bibliographies:string[]) {
        this._bibliographyService.addAll(bibliographies);
    }

    add($event) {
        this._bibliographyService.add(this.bibliography)
            .subscribe(
                res => {
                    this.router.navigate(['/']);
                }
            );
        $event.preventDefault();
    }

    addAuthor() {
        this.bibliography.authors[this.bibliography.authors.length] = new Person();
    }

    addEditor() {
        this.bibliography.editors[this.bibliography.editors.length] = new Person();
    }

    removeAuthor(author:Person) {
        this.bibliography.authors.splice(this.bibliography.authors.indexOf(author), 1);
    }

    removeEditor(editor:Person) {
        this.bibliography.editors.splice(this.bibliography.editors.indexOf(editor), 1);
    }
}
