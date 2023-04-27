package com.crio.starter.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.crio.starter.exchangeDTO.MemeResponse;
import com.crio.starter.exchangeDTO.Memes;
import com.crio.starter.service.MemeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;

@AutoConfigureMockMvc
@SpringBootTest
public class MemeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemeService memeService;

    @Test
    @DisplayName("First test")
    public void getMemesFromRestApi() throws Exception{
        Memes meme = new Memes("1", "shivansh", "get memes method test", "xyz.com");
        List<Memes>memeList = new ArrayList<>();
        memeList.add(meme);        
    //given
        when(memeService.findMemes()).thenReturn(memeList);


    //when
        URI uri = UriComponentsBuilder
        .fromPath("/memes/")
        .queryParam("name","shivansh")
        .queryParam("caption", "memes")
        .queryParam("url", "xyz.com")
        .build().toUri();

        MockHttpServletResponse memeMocking = mockMvc.perform(get(uri.toString()).accept(APPLICATION_JSON_VALUE)).andReturn().getResponse();
    
        
    //then
        String memeString = memeMocking.getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        List<Memes> memes = mapper.readValue(memeString,new TypeReference<List<Memes>>(){});
        assertEquals(memes,memeList );
        Mockito.verify(memeService,Mockito.times(1)).findMemes();





        
    }





    
}
