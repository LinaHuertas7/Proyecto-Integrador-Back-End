package com.example.proyectointegrador;

import com.example.proyectointegrador.model.Odontologo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.reactive.function.server.MockServerRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.example.proyectointegrador.util.Jsons;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionOdontologoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles="ADMIN")
    public void guardarOdontologo() throws Exception {
        Odontologo odontologo1 = new Odontologo("Viviana","Caseres",7654321);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/odontologos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Jsons.asJsonString(odontologo1)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assert.assertFalse((response.getResponse()).getContentAsString().isEmpty());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void consultarTodos() throws Exception{
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/odontologos")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assert.assertFalse((response.getResponse().getContentAsString().isEmpty()));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void consultarById() throws Exception{
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/odontologos/{id}","33")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assert.assertFalse((response.getResponse().getContentAsString().isEmpty()));
    }
/*
    @Test
    @WithMockUser(roles = "ADMIN")
    public void eliminarById() throws Exception{
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.delete("/odontologos/{id}","1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assert.assertNotEquals("1",response.getResponse());
    }*/



}
