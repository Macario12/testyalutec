import {  IsMongoId, IsString } from 'class-validator';

export class ProductIdParamDto {
  @IsMongoId()
  id: string;
}
