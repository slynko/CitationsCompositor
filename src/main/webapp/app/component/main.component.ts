import {Component, Inject} from '@angular/core';
import {Router} from '@angular/router';

@Component({
    selector: 'main-component',
    templateUrl: 'app/static/template/main.html'
})
export class MainComponent {
    constructor(@Inject(Router) private router:Router) {
    }

    view():boolean {
        this.router.navigate(['/view']);
        return false;
    }
}
