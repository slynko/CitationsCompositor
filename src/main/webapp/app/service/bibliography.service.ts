import { Injectable, Inject } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs';

import 'rxjs/add/operator/map';

@Injectable()
export class BibliographyService {

    private endpoint_url = "rest/bibliographies";

    constructor(@Inject(Http) private http: Http) {  }

    getAll(): Observable<string[]> {
        //noinspection TypeScriptUnresolvedFunction
        return this.http.get(this.endpoint_url)
            .map(res => res.json());
    }

    getAllDstuFiles(): Observable<string[]> {
        return this.http.get(this.endpoint_url + "/dstu/files")
            .map(res => res.json());
    }

    addAll(bibliographies: string[]): Observable<string[]> {
        //noinspection TypeScriptUnresolvedFunction
        return this.http.post(this.endpoint_url, bibliographies)
            .map(res => res.json());
    }

    add(bibliography: string): Observable<string> {
        //noinspection TypeScriptUnresolvedFunction
        return this.http.post(this.endpoint_url + "/add", bibliography)
            .map(res => res.json());
    }
    
}