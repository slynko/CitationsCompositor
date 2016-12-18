import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import { ViewComponent } from '../component/view.component';
import { EditComponent } from '../component/edit.component';
import { MainComponent } from '../component/main.component';
import { BibliographyService } from '../service/bibliography.service';
import { FormsModule } from '@angular/forms';

@NgModule({
    imports: [
        BrowserModule,
        HttpModule,
        FormsModule,
        RouterModule.forRoot([
            {
                path: '',
                component: ViewComponent
            },
            {
                path: 'view',
                component: ViewComponent
            },
            {
                path: 'edit',
                component: EditComponent
            },
            {
                path: 'edit/:id',
                component: EditComponent
            },
            {
                path: '**',
                component: ViewComponent
            }
        ])
    ],
    declarations: [
        MainComponent,
        ViewComponent,
        EditComponent
    ],
    providers: [
        BibliographyService
    ],
    bootstrap: [MainComponent]
})
export class AppModule { }
