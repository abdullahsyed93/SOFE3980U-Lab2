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
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMultiplicationWeb() throws Exception {
        mockMvc.perform(get("/")
                .param("operand1", "10")
                .param("operand2", "11")
                .param("operator", "*"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"));
    }

    @Test
    public void testBitwiseAndWeb() throws Exception {
        mockMvc.perform(get("/")
                .param("operand1", "101")
                .param("operand2", "011")
                .param("operator", "&"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"));
    }

    @Test
    public void testInvalidOperatorWeb() throws Exception {
        mockMvc.perform(get("/")
                .param("operand1", "101")
                .param("operand2", "011")
                .param("operator", "%"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"));
    }
}