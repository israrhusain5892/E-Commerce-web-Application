package com.example.Ecommerce.Application.Service;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ecommerce.Application.Dao.ProductDao;
import com.example.Ecommerce.Application.Models.Category;
import com.example.Ecommerce.Application.Models.Product;
import com.example.Ecommerce.Application.Repository.CategoryRepository;
import com.example.Ecommerce.Application.Repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productrepo;
    
    @Autowired
    private CategoryRepository Catrepo;

   

     public void Updateproduct(int id) throws Exception{
          Product product=productrepo.findById(id).get();
          Category category=product.getCategory();
          List<Product> products=category.getProducts();
           products.add(product);
           category.setProducts(products);
           product.setCategory(category);
            Catrepo.save(category);
     }
      public void DeleteProduct(int id) throws Exception{
          Product product=productrepo.findById(id).get();
          
          Category cat=product.getCategory();
          List<Product> prodlist=cat.getProducts();
          for(Product product1:prodlist){
                if(product1.getId()==id){
                      prodlist.remove(product1);
                      break;
                }

          }
          cat.setProducts(prodlist);
          product.setCategory(cat);
          Catrepo.save(cat);
      }

      public Product getproduct(int id) throws Exception{
         return productrepo.findById(id).get();
      }

      public List<Product> getAllProducts( int id) throws Exception{
           return productrepo.findAllByCategory_id(id);
      }
}
