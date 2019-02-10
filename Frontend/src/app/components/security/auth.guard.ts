import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SharedService } from 'src/app/service/shared.service';

@Injectable()
export class AuthGuard implements CanActivate{
    public shared : SharedService;

    constructor(private router: Router){
        this.shared = SharedService.getInstance();
    }
    
    canActivate(
        route: ActivatedRouteSnapshot, 
        state: RouterStateSnapshot): Observable<boolean> | boolean {
        if(this.shared.isLoggedIn()){
           return true;
        }
        this.router.navigate(['/login']);
        return false;
    }
}