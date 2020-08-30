package com.ebay.ironbank.controllers;

import com.ebay.ironbank.services.BankService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.PostConstruct;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


/**
 * @author Evgeny Borisov
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BankController.class)
@ContextConfiguration(classes = MockBeansForWebConf.class)
@ActiveProfiles("WINTERE_IS_HERE")
//@MockBean(BankService.class)
public class BankControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ApplicationContext context;


    @Test
    public void getBalance() throws Exception {
        mockMvc.perform(
                get("/iron-bank/balance").accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("total")));
    }


      @Test
    public void loanForStark() throws Exception {
        mockMvc.perform(
                get("/iron-bank/loan?name=stark&amount=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("will not survive the winter")));
    }
    @Test
    public void loanForLanister() throws Exception {
        mockMvc.perform(
                get("/iron-bank/loan?name=lanister&amount=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("transferred")));
    }
}
