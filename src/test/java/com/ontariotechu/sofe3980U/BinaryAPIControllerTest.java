package com.ontariotechu.sofe3980U;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMultiplicationAPI() throws Exception {
        mockMvc.perform(get("/binaryAPI")
                .param("operand1", "10")
                .param("operand2", "11")
                .param("operator", "*"))
                .andExpect(status().isOk());
    }

    @Test
    public void testBitwiseOrAPI() throws Exception {
        mockMvc.perform(get("/binaryAPI")
                .param("operand1", "101")
                .param("operand2", "011")
                .param("operator", "|"))
                .andExpect(status().isOk());
    }

    @Test
    public void testInvalidOperatorAPI() throws Exception {
        mockMvc.perform(get("/binaryAPI")
                .param("operand1", "101")
                .param("operand2", "011")
                .param("operator", "%"))
                .andExpect(status().isOk());
    }
}