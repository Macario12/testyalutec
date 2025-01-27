import { Body, Controller, Get, Param, Post, Put, Delete } from '@nestjs/common';
import { ApiTags, ApiOperation, ApiParam, ApiBody, ApiResponse } from '@nestjs/swagger';
import { ProductosService } from './productos.service';
import { CreateProductDto } from './dto/create-product.dto';
import { ProductIdParamDto } from './dto/productid.dto';


@ApiTags('Productos')
@Controller('api/productos')
export class ProductosController {
    constructor(private readonly productosServices: ProductosService){}

    @Get()
    @ApiOperation({ summary: 'Obtiene todos los pruductos registrados en base de datos' })
    @ApiResponse({
        status: 200,
        description: 'Lista de productos',
        example: [{ id: 123213, nombre: 'Producto A',precio: 1231.1,cantidad: 21, },],})
    async getAllProducts(){
        return this.productosServices.getAllProductos();
    }

    @Post()
    @ApiOperation({ summary: 'Registra un producto en base de datos' })
    @ApiResponse({
        status: 200,
        description: 'Respuesta esperada',
        example: {codigo:123,mensaje:"procesado correctamente"},})
    async createProduct(@Body() producto: CreateProductDto){
            return this.productosServices.createProducto(producto);
    }

    @Put(':id')
    @ApiOperation({ summary: 'Actualizado un producto por medio del id en base de datos.' })
    @ApiParam({ name: 'id', description: 'El ID del producto', type: 'string' })
    @ApiResponse({
        status: 200,
        description: 'Respuesta esperada',
        example: {codigo:123,mensaje:"actualizado correctamente"},})
    async updateProduct(@Param('id') id: string, @Body() producto: CreateProductDto){
        return this.productosServices.updateProducto(id, producto);
    }

    @Delete(':id')
    @ApiOperation({ summary: 'Elimina un producto por medio del id en base de datos.' })
    @ApiResponse({
        status: 200,
        description: 'Respuesta esperada',
        example: {codigo:123,mensaje:"eliminado correctamente"},})
    @ApiParam({ name: 'id', description: 'El ID del producto', type: 'string' })
    async deleteProduct(@Param('id') id: string){
        return this.productosServices.deleteProducto(id);
    }
}
