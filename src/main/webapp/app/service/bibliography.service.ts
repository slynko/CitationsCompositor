import { Injectable, Inject } from '@angular/core';
import { Http } from '@angular/http';

import 'rxjs/add/operator/map';

@Injectable()
export class BibliographyService {

    private endpoint_url = "rest/bibliographies";

    constructor(@Inject(Http) private http: Http) {  }

    getAll() {
        return this.http.get(this.endpoint_url)
            .map(res => res.json());
    }
}