import { Body, Controller, Get, Param, Post, Put, Delete } from '@nestjs/common';
import { ApiTags, ApiOperation, ApiParam, ApiBody, ApiResponse } from '@nestjs/swagger';
import { EventosService } from './eventos.service';


@ApiTags('Eventos')
@Controller('api/eventos')
export class EventosController {
    constructor(private readonly eventosServices: EventosService){}
    
        @Get()
        @ApiOperation({ summary: 'Obtiene todos los eventos registrados en base de datos' })
        @ApiResponse({
            status: 200,
            description: 'Lista de eventos',
            example: [{evento: 'evento pruebas'},{evento: 'evento pruebas1'}],})
        async getAllProducts(){
            return this.eventosServices.getAllEventos();
        }
}
