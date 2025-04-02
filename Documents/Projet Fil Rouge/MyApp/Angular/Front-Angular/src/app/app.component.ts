import {Component, computed, signal} from '@angular/core';
import {RouterLink, RouterLinkActive, RouterOutlet} from '@angular/router';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatSidenavModule} from '@angular/material/sidenav';


@Component({
    selector: 'app-root',
    standalone: true,
    imports: [RouterOutlet,
        RouterLink, RouterLinkActive,
        MatToolbarModule, MatButtonModule,
        MatIconModule, MatSidenavModule,
    ],
    templateUrl: './app.component.html',
    styleUrl: './app.component.scss'
})
export class AppComponent {
    title = 'cda_2025_front';
    collapsed = signal(false);
    sidenavWidth = computed(() => (this.collapsed() ? "65px" : "250px"));
}
