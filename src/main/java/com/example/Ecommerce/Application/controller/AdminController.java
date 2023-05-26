    package com.example.Ecommerce.Application.controller;

    import java.io.File;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.nio.file.StandardCopyOption;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;

    import org.springframework.web.multipart.MultipartFile;
    import com.example.Ecommerce.Application.Dao.ProductDao;
    import com.example.Ecommerce.Application.Models.Category;
    import com.example.Ecommerce.Application.Models.Product;
    import com.example.Ecommerce.Application.Models.Sendmessage;
import com.example.Ecommerce.Application.Models.User;
import com.example.Ecommerce.Application.Repository.ProductRepository;
import com.example.Ecommerce.Application.Repository.UserRepo;
import com.example.Ecommerce.Application.Service.CategoryService;
    import com.example.Ecommerce.Application.Service.ProductService;


    import jakarta.servlet.http.HttpSession;


    @RequestMapping("/admin")
    @Controller
    public class AdminController {


    public static String uploadDir=System.getProperty("user.dir")+"/src/main/resources/static/productImages";
    
    @Autowired
    private CategoryService categoryservice;

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UserRepo userrepo;
    
    @Autowired
    private ProductService productService;
     
    
    
    @RequestMapping("/dashboard")
    public String gotoAdmin(Model model) throws Exception{

        model.addAttribute("Productdao", new ProductDao());
        model.addAttribute("categories", categoryservice.getAllcategories());
        model.addAttribute("user",userrepo.findById(1).get().getUserName().toUpperCase());
        model.addAttribute("usernumber", userrepo.findAll().size());
        model.addAttribute("categorynumber",categoryservice.getAllcategories().size());
        model.addAttribute("productnumber", productRepository.findAll().size());
        return "admin";
    }

    @GetMapping("/products")
    public String product(Model model,@RequestParam("id") int id) throws Exception{
    model.addAttribute("products", productService.getAllProducts(id));
    return "redirect:/admin/dashboard";
    }


    @GetMapping("/addproduct")
    public String addproduct(Model model) throws Exception{
        
        model.addAttribute("categories", categoryservice.getAllcategories());
        return "redirect:/admin/dasboard";
    }

    @PostMapping("/addproduct")
    public String addProductBycategory(@ModelAttribute("productdao") ProductDao productdao,
                                           @RequestParam("productImage") MultipartFile file,
                                            HttpSession session) throws IOException{
    
    try
    {
        //set the dao values;
        Product product=new Product();
        product.setCategory(categoryservice.getCategory(productdao.getCategory_id()));
        product.setProduct_title(productdao.getProduct_title());
        product.setProduct_description(productdao.getProduct_description());
        product.setProduct_price(productdao.getProduct_price());
        product.setDiscount(productdao.getDiscount());
    
            //file uploading method
       if(!file.isEmpty()){
            product.setProduct_pic(file.getOriginalFilename());
            Path path=Paths.get(uploadDir+File.separator+file.getOriginalFilename());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        }

        productRepository.save(product);

        /*second method for file upoading

        FileOutputStream fos=new FileOutputStream(uploadDir);
        InputStream is=file.getInputStream();

        byte [] data=new byte[is.available()];
        is.read(data);
        fos.write(data);
        fos.close
                */
        session.setAttribute("message", new Sendmessage("product added successfully","success"));
      }
      
       catch(Exception e){
          session.setAttribute("message", new Sendmessage("product not added some wrong!! try again..","danger"));
        }
 
        return "redirect:/admin/dashboard";
    }

    //category apis
    @RequestMapping("/addcategory")
    public String addcategorytoadmin(Model model){
        model.addAttribute("category", new Category());
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/addcategory")
    public String addCategory(@ModelAttribute("category") Category category,HttpSession session) {
    try{
        categoryservice.addCategory(category);
        session.setAttribute("message", new Sendmessage("category added successfully","success"));
    }
    catch(Exception e){
        session.setAttribute("message", new Sendmessage("some thing went wrong!","danger"));
            
        }
        return "redirect:/admin/dashboard";
    }


    @RequestMapping("/logout")
    public String LogoutAdmin(){
    return "admin";
    }

}
