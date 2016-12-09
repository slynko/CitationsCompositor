import { Injectable } from 'angular2/core';
import { Http } from 'angular2/http';

import 'rxjs/add/operator/map';

@Injectable()
export class BibliographyService {

    private endpoint_url = "rest/bibliographies";

    constructor(private http: Http) {  }

    getAll() {
        return this.http.get(this.endpoint_url)
            .map(res => res.json());
    }
}