import { Injectable } from 'angular2/core';
import { Http } from 'angular2/http';

import 'rxjs/add/operator/map';

@Injectable()
export class BibliographyService {

    private endpoint_url = "http://localhost:8081/entities";

    constructor(private http: Http) {  }

    getAllBibliographies() {
        return this.http.get(this.endpoint_url)
            .map(res => res.json());
    }
}