import { Injectable } from '@nestjs/common';
import { HttpService } from '@nestjs/axios';
import { lastValueFrom } from 'rxjs';
import { ConfigService } from '@nestjs/config';

@Injectable()
export class ProductosService {
    private readonly apiBaseUrl: string;
    constructor( private readonly httpService: HttpService, private readonly configService: ConfigService) {
        this.apiBaseUrl = this.configService.get<string>('PRODUCTOS_URI') || "";
    }

    async getAllProductos(){
        const response = await this.httpService.get(`${this.apiBaseUrl}/productos`).toPromise();

        return response?.data;
    }

    async createProducto(producto: any){
        const response = await lastValueFrom(this.httpService.post(`${this.apiBaseUrl}/productos`, producto));

        return response?.data;
    }

    async updateProducto(id: any, producto: any){
        const response = await lastValueFrom(this.httpService.put(`${this.apiBaseUrl}/productos/${id}`, producto));

        return response?.data;
    }

    async deleteProducto(id: any){
        const response = await lastValueFrom(this.httpService.delete(`${this.apiBaseUrl}/productos/${id}`));

        return response?.data;
    }
}
