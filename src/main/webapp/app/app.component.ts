import {Component} from 'angular2/core';
//import {BibliographyService} from './service/bibliography.service'

@Component({
    selector: 'my-app',
    templateUrl: 'app/template/home.html',
    //providers: [BibliographyService]
})
export class AppComponent {
    // constructor(private _bibliographyService: BibliographyService){
    //     this._bibliographyService = _bibliographyService;
    // }

    getAllBibliographies (){
        // this.error = "";
        // this.bibliographies = [];
        // this._bibliographyService.getAllBibliographies()
        //     .subscribe(
        //         data => this.bibliographies = data,
        //         error => this.error = "Region " + this.region + " is invalid."
        //     );
    }
}