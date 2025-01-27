import { Module } from '@nestjs/common';
import { HttpModule } from '@nestjs/axios';
import { EventosService } from './eventos.service';
import { EventosController } from './eventos.controller';

@Module({
  imports: [HttpModule],
  providers: [EventosService],
  controllers: [EventosController],
})
export class EventosModule {}
