package com.example.Ecommerce.Application.controller;



import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.Ecommerce.Application.BamborapaymentGateway.BamboraApiConfig;
//i//mport com.example.Ecommerce.Application.BamborapaymentGateway.BamboraApiService;
import com.example.Ecommerce.Application.BamborapaymentGateway.BamboraClient;
import com.example.Ecommerce.Application.BamborapaymentGateway.PaymentResponse;
import com.example.Ecommerce.Application.Models.Bill;
import com.example.Ecommerce.Application.Models.Cart;
//import com.example.Ecommerce.Application.Models.Category;
import com.example.Ecommerce.Application.Models.Product;
import com.example.Ecommerce.Application.Models.PaymentRequest;
import com.example.Ecommerce.Application.Models.Sendmessage;
import com.example.Ecommerce.Application.Models.User;
import com.example.Ecommerce.Application.Repository.BillRepository;
import com.example.Ecommerce.Application.Repository.CartRepository;
import com.example.Ecommerce.Application.Repository.ProductRepository;
import com.example.Ecommerce.Application.Repository.UserRepo;
import com.example.Ecommerce.Application.Service.CartService;
import com.example.Ecommerce.Application.Service.CategoryService;
// import com.example.Ecommerce.Application.Service.PaymentService;
import com.example.Ecommerce.Application.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;





@Controller
@RequestMapping("/user")
public class Usercontroller{
      
      static List<Product> list;

      

     @Autowired
     private BillRepository billRepository;

     @Autowired
     private CartRepository cartRepository;

     @Autowired
     private UserRepo userRepo;
     
     @Autowired
     private UserService userService;
 
    @Autowired
    private CategoryService categoryService;
 
    @Autowired
    private ProductRepository productRepository;

   

    @Autowired
    private CartService cartService;
        
   
    

         @RequestMapping("/removecart/{id}")
         public String deletecart(@PathVariable int id){
           Cart cart=cartRepository.findById(id).get();
            cartRepository.delete(cart);
           // list.clear();
             return "redirect:/user/showcart";
         }
     
          String userName;
          User user;
          @RequestMapping("/dashboard")
           public String viewUserpage(Model model,Principal principal)throws Exception{
                userName=principal.getName();
                user=userRepo.findByEmail(userName);
                //model.addAttribute("size",list.size());
               model.addAttribute("categories1", categoryService.getAllcategories());
           
               model.addAttribute("Allproducts", productRepository.findAll());
                 model.addAttribute("user",user);
                
                 model.addAttribute("cartscount", cartRepository.findAllByUser_id(user.getId()).size());
                 if(user.getEmail().equals(userName)){
                          return "user_home";
                 }
                 else if(user.getEmail().equals("admin123@gmail.com")){
                       return "redirect:/admin/dashboard";
                 }



                
                return "user_home";
           }


           @RequestMapping("/dashboard/{id}")
           public String showproductsById(Model model,@PathVariable("id") int id,Principal principal) throws Exception{
               model.addAttribute("categories1", categoryService.getAllcategories());
               model.addAttribute("Allproducts", productRepository.findAllByCategory_id(id));
               //String userName=principal.getName();
               User user=userRepo.findByEmail(userName);
               model.addAttribute("user",user);
               model.addAttribute("cartscount", cartRepository.findAllByUser_id(user.getId()).size());
              //  model.addAttribute("size",list.size());
               return "user_home";

           }
           
          
        @GetMapping("/addcart/{id}")
        public String addCart(@PathVariable("id") int id, Principal principal,Model model){

          
           

          try{
             String username=principal.getName();
             User user=userRepo.findByEmail(username);
             cartService.addcart(user,id);
             model.addAttribute("cartscount", cartRepository.findAllByUser_id(user.getId()).size());
             Cart cart=cartRepository.findById(id).get();
             model.addAttribute("Allproducts", cart.getProduct());
             model.addAttribute("size",list.size());
              
          }
          catch(Exception e){
            e.printStackTrace();
          }
              return "redirect:/user/dashboard";
        }
          
        
          static int totalAmount=0;

  @RequestMapping("/showcart")
  public String addcart(Model model){
    list=new ArrayList();
    for(Cart cart:cartRepository.findAll()){
        list.add(cart.getProduct());
        
        totalAmount+=cart.getProduct().getProduct_price();
    }
        model.addAttribute("cartscount", cartRepository.findAllByUser_id(user.getId()).size());
        model.addAttribute("Allproducts",list);
        
        model.addAttribute("totalAmount", totalAmount);
          
      return "cart";
    }


  @RequestMapping("/gobill")
  public String goBill(){
      return "bill";
  }

          
  @PostMapping("/addbill")
  public String addBill(@ModelAttribute("bill") Bill bill){
      try{
        billRepository.save(bill);
      }
      catch(Exception e){
          e.printStackTrace();
      }
        return "bill";
      
  }

  @RequestMapping("/transaction")
  public String showTransaction(Model model){
    model.addAttribute("totalamount",totalAmount);
  // session.setAttribute("message", new Sendmessage("payment done successfully","success"));
      
      return "payment" ;
  }
        

    // @GetMapping("/payment")
    // public String showTransaction(@ModelAttribute PaymentRequest RequestPayment, Model model) throws Exception{
    //         PaymentResponse paymentResponse= Bamboramethod(model,RequestPayment);
    //         String orderId = paymentResponse.getOrderId();
    //         String paymentStatus = paymentResponse.getStatus();
    //         model.addAttribute("response",orderId );
    //         model.addAttribute("paymentStatus", paymentStatus);
    //          return "transaction";  
    //    }

   
    @GetMapping("/payment") 
    public String Bamboramethod(Model model,@ModelAttribute("PaymentRequest") PaymentRequest request){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer "+ "4EA2A56F40654D4A853EC21F4F976CC2");

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String url = "https://api.bambora.com/v1/payments";

       PaymentRequest paymentRequest = new PaymentRequest();
      // set payment details on the paymentRequest object
        paymentRequest.setAmount(request.getAmount());
        paymentRequest.setCvv(request.getCvv());
        paymentRequest.setCard_number(request.getCard_number());
        paymentRequest.setExpiry_date(request.getExpiry_date());

      HttpEntity<PaymentRequest> request1 = new HttpEntity<>(paymentRequest, headers);
       ResponseEntity<PaymentResponse> response = restTemplate.exchange(url, HttpMethod.GET, request1, PaymentResponse.class);
       
       
            PaymentResponse paymentResponse = response.getBody();
            
           String orderId = paymentResponse.getOrderId();
            String paymentStatus = paymentResponse.getStatus();
            model.addAttribute("response",orderId );
            model.addAttribute("paymentStatus", paymentStatus);

             return "transaction";  
            
       }
       
       
    
    

    public String convertPaymentRequestToJson(PaymentRequest RequestPayment) throws JsonProcessingException {
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.writeValueAsString(RequestPayment);
  }
}
           

      
          
    
      

