package com.zoomcarseller.ZoomCarSeller.Service;

import com.zoomcarseller.ZoomCarSeller.ValueObject.Customer;
import com.zoomcarseller.ZoomCarSeller.ValueObject.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private RestTemplate restTemplate;


    public List getAllCustomers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:8080/get-all-customers", HttpMethod.GET,
                entity, List.class).getBody();

    }

    public Customer getCustomer(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:8080/customer/{id}", HttpMethod.GET,
                entity, Customer.class).getBody();

    }


    public ResponseTemplateVO saveCustomer(Customer customer,Long id) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Customer partner = restTemplate.postForObject(
                "http://localhost:8080/customer/{id}",
                customer,
                Customer.class,id);
        vo.setCustomer(partner);
        return vo;
    }
}
