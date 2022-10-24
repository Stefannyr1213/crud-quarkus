package co.crud.controller;


import co.crud.dto.ProductDto;
import co.crud.entity.Product;
import co.crud.service.ProductService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    ProductService service;

    //http://localhost:8080/products
    @GET
    public Response listProducts(){
        List<Product> products=service.listProduct();
        return Response.ok(products).build();
    }
    @POST
    public Response saveProduct(ProductDto dto){
        Product product=service.saveProduct(dto);
        return Response.ok(product).status(201).build();
    }
    @PUT
    @Path("{id}")
    public Response updateProduct(@PathParam("id") Long id, ProductDto dto){
        service.updateProduct(id,dto);
        return  Response.status(204).build();
    }
    @DELETE
    @Path("{id}")
    public Response removeProduct(@PathParam("id") Long id){
        service.removeProduct(id);
        return Response.status(204).build();
    }
}
