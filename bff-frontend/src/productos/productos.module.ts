import { Module } from '@nestjs/common';
import { HttpModule } from '@nestjs/axios';
import { ProductosController } from './productos.controller';
import { ProductosService } from './productos.service';

@Module({
  imports: [HttpModule],
  controllers: [ProductosController],
  providers: [ProductosService]
})
export class ProductosModule {}
