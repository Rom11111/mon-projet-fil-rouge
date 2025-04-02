import {Component, inject} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {RouterLink} from '@angular/router';
import {NgStyle} from '@angular/common';


@Component({
    selector: 'app-accueil',
    imports: [
        MatButtonModule, MatCardModule, RouterLink, NgStyle,
    ],
    templateUrl: './accueil.component.html',
    styleUrl: './accueil.component.scss'
})
export class AccueilComponent {

    http = inject(HttpClient)
    products: Product[] = []

    ngOnInit() {
        this.http.get<Product[]>("http://localhost:8080/products")
            .subscribe(products => this.products = products)
    }

}
