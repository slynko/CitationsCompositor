import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

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