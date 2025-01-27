import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { ConfigModule } from '@nestjs/config';
import { ProductosModule } from './productos/productos.module';
import { EventosModule } from './eventos/eventos.module';

@Module({
  imports: [ProductosModule, EventosModule,
    ConfigModule.forRoot({
      isGlobal: true, // Hacer que las variables estén disponibles en todo el proyecto
    }),
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
