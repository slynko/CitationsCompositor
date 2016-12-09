import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { BibliographyService } from './service/bibliography.service';

@NgModule({
    imports: [
        BrowserModule,
        HttpModule,
        RouterModule.forRoot([
            {
                path: '',
                component: AppComponent
            },
            {
                path: 'add',
                component: AppComponent
            },
            {
                path: 'edit/:id',
                component: AppComponent
            },
            {
                path: '**',
                component: AppComponent
            }
        ])
    ],
    declarations: [
        AppComponent
    ],
    providers: [
        BibliographyService
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
