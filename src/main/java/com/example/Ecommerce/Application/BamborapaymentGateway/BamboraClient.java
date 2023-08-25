package com.example.Ecommerce.Application.BamborapaymentGateway;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import lombok.Data;

@Data
public class BamboraClient {

    private CloseableHttpClient httpClient;
    private String merchantId;
    private String username;
    private String password;

    public BamboraClient() {
        httpClient = HttpClients.createDefault();
    }

    public String sendGetRequest(String url) throws Exception {
        HttpGet request = new HttpGet(url);
        
        HttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        
        String responseBody = EntityUtils.toString(entity);
        
        return responseBody;
    }
    
   
    
    public void authenticate() throws Exception {
          
            AuthenticationRequest authenticationRequest = new AuthenticationRequest(merchantId, username, password);
    
            // Make the authentication request to Bambora
            AuthenticationResponse authenticationResponse = makeAuthenticationRequest(authenticationRequest);
    
            // Check the authentication response
            if (authenticationResponse.isSuccessful()) {
                // Authentication successful, store the access token or any other required authentication details
                String accessToken = authenticationResponse.getAccessToken();
                // Store the accessToken for future API requests
            }
             else {
                // Authentication failed, handle the error accordingly
                throw new Exception("Bambora authentication failed");
            }
        }
    
        private AuthenticationResponse makeAuthenticationRequest(AuthenticationRequest request) {
            // Code to make the actual authentication API request to Bambora
            // This can include using an HTTP client library or Bambora SDK
            
            // Example code to demonstrate the authentication API request
            // Replace this with the actual code to make the request and handle the response
    
            // Send the request to Bambora and obtain the authentication response
            // Here, we assume that the response is received in the form of an AuthenticationResponse object
            AuthenticationResponse response = new AuthenticationResponse();
    
            // Populate the response with the appropriate values
            // Here, we assume a successful authentication with an access token
            response.setSuccessful(true);
            response.setAccessToken("081C30C74A364E1C980C3DE98174FC22");
    
            return response;
        }
    
        // Other methods for API requests can be added here


    

   

    public String makePaymentRequest(String paymentData) throws Exception {
        String url = "https://api.bambora.com/v1/payments"; // Replace with the actual payment API endpoint

        // Create a POST request
        HttpPost request = new HttpPost(url);

        // Set the request body
        StringEntity stringEntity = new StringEntity(paymentData);
        request.setEntity(stringEntity);

        // Set the necessary headers
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Authorization", "Bearer " + "Passcode"); // Include the access token in the Authorization header

        // Execute the request and process the response
        HttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        String responseBody = EntityUtils.toString(entity);

        return responseBody;
    }
}


    
    // Add other methods for different API requests (POST, PUT, etc.)


