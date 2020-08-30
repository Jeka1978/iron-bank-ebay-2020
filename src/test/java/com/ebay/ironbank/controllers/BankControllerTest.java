package com.ebay.ironbank.controllers;

import com.ebay.ironbank.services.BankService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * @author Evgeny Borisov
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
class BankControllerTest {

    static {
        System.setProperty("java.awt.headless", "false");
    }


    @Autowired
    BankService bankService;


    @Test
    void balance() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String balance = restTemplate.getForObject("http://localhost:8082/iron-bank/balance", String.class);
        System.out.println(balance);

//        mockMvc.perform(
//                get("/iron-bank/balance").accept(MediaType.APPLICATION_JSON))
//                .andExpect(content().string(containsString("total")));
    }

  /*  @Test
    void loanForStark() throws Exception {
        mockMvc.perform(
                get("/iron-bank/loan?name=stark&amount=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("will not survive the winter")));
    }*/
   /* @Test
    void loanForLanister() throws Exception {
        mockMvc.perform(
                get("/iron-bank/loan?name=lanister&amount=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("transferred")));
    }*/


}