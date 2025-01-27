import { Injectable } from '@nestjs/common';
import { HttpService } from '@nestjs/axios';
import { ConfigService } from '@nestjs/config';

@Injectable()
export class EventosService {
    private readonly apiBaseUrl: string;
        constructor( private readonly httpService: HttpService, private readonly configService: ConfigService) {
            this.apiBaseUrl = this.configService.get<string>('EVENTOS_URI') || "";
        }

    async getAllEventos(){
        const response = await this.httpService.get(`${this.apiBaseUrl}/eventos`).toPromise();

        return response?.data;
    }
}
