package co.crud.service;

import co.crud.dto.ProductDto;
import co.crud.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductService {

    public List<Product> listProduct(){
        return Product.listAll();
    }
    @Transactional
    public Product saveProduct(ProductDto dto){
        Product product=new Product();
        product.setName(dto.getName());
        product.setStock(dto.getStock());
        product.setPrice(dto.getPrice());
        product.persist();
        return product;
    }
    @Transactional
    public void updateProduct(Long id, ProductDto dto){
        Product product= new Product();
        Optional<Product> productOp =Product.findByIdOptional(id);
        if (productOp.isEmpty()){
            throw  new NullPointerException("Product not found");
        }
        product= productOp.get();
        product.setName(dto.getName());
        product.setStock(dto.getStock());
        product.setPrice(dto.getPrice());
        product.persist();
    }
    @Transactional
    public void removeProduct(Long id){
        Optional<Product> productOp= Product.findByIdOptional(id);
        if (productOp.isEmpty()){
            throw  new NullPointerException("Product not found");
        }
        Product product = productOp.get();
        product.delete();
    }
}
