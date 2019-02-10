import { Component, OnInit } from '@angular/core';
import { Ticket } from 'src/app/model/ticket.model';
import { SharedService } from 'src/app/service/shared.service';
import { ActivatedRoute } from '@angular/router';
import { TicketService } from 'src/app/service/ticket.service';
import { noUndefined } from '@angular/compiler/src/util';
import { ResponseApi } from 'src/app/model/response-api';

@Component({
  selector: 'app-ticket-detail',
  templateUrl: './ticket-detail.component.html',
  styleUrls: ['./ticket-detail.component.css']
})
export class TicketDetailComponent implements OnInit {
  ticket = new Ticket('',0,'','','','',null,null,'',null);
  shared : SharedService;
  message : {};
  classCss : {};
  constructor(
    private ticketService: TicketService,
    private route: ActivatedRoute
  ) { 
    this.shared = SharedService.getInstance();
  }

  ngOnInit() {
    let id:string = this.route.snapshot.params['id'];
    if(id != undefined){
      this.findById(id);
    }
  }

  findById(id:string){
    this.ticketService.findById(id).subscribe((respondeApi: ResponseApi) => {
      this.ticket = respondeApi.data;
      console.log('image',respondeApi.data)
      this.ticket.date = new Date(this.ticket.date).toISOString();
    }, err => {
      this.showMessage({
        type: 'error',
        text: err['error']['errors'][0]
      })
    });
  }

  changeStatus(status:string) : void {
    this.ticketService.changeStatus(status,this.ticket).subscribe((respondeApi: ResponseApi) => {
      this.ticket = respondeApi.data;
      this.ticket.date = new Date(this.ticket.date).toISOString();
      this.showMessage({
        type: 'sucess',
        text: 'Sucessfully changed status'
      });
    },err => {
      this.showMessage({
        type: 'error',
        text: err['error']['errors'][0]
      });
    });
  }
  private showMessage(message: {type: string, text: string}) : void {
    this.message = message;
    this.buildClasses(message.type);
    setTimeout(() => {
      this.message = undefined;
    }, 3000);
  }

  private buildClasses(type: string):void{
    this.classCss = {
      'alert' : true
    }
    this.classCss['alert-'+type] = true;
  }

}
