import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'main-component',
    templateUrl: 'app/template/main.html'
})
export class MainComponent {
    constructor(
        private router: Router
    ) {  }

    edit(): boolean {
        this.router.navigate(['/edit']);
        return false;
    }

    view(): boolean {
        this.router.navigate(['/view']);
        return false;
    }
}
