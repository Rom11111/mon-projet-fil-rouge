import {Component, Input, signal} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MatLineModule} from '@angular/material/core';
import {MatIconModule} from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';

export type MenuItem = {
    icon: string;
    label: string;
    route?:any
}

@Component({
    selector: 'app-custom-sidenav',
    imports: [CommonModule, MatLineModule, MatListModule, MatIconModule],
    templateUrl: './custom-sidenav.component.html',
    styleUrl: './custom-sidenav.component.scss'
})
export class CustomSidenavComponent {

    menuItems = signal<MenuItem[]>([
        {
            icon: "dashboard",
            label: "Dashboard",
            route: "dashboard",
        },
        {
            icon: "video_library",
            label: "Content",
            route: "content",
        },

    ]);
}
