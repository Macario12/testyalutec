import { IsString, Length, IsInt, Min, Max, IsNumber } from 'class-validator';
import { ApiProperty } from '@nestjs/swagger';
export class CreateProductDto {
  @ApiProperty({ description: 'El nombre del producto', example: 'Manzanas' })
  @IsString()
  @Length(3, 50)
  nombre: string;

  @ApiProperty({ description: 'El precio del producto', example: '12.60' })
  @IsNumber({ allowInfinity: false, allowNaN: false })
  precio: number;

  @ApiProperty({ description: 'La cantidad del producto', example: '50' })
  @IsInt()
  @Min(1)
  @Max(100)
  cantidad: number;
}
