package devproblem.services;


import devproblem.GrapeComponent;
import devproblem.Wine;
import devproblem.restapi.WineController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static  org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@WebMvcTest(WineController.class)
public class WineRestControllerTest {

    Wine mappedWine;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private WineService wineServiceMock;

    @Before
    public void setUp () {
        mappedWine = new Wine("11YVCHAR001",
                new Double(1000));
        mappedWine.setDescription("2011 Yarra Valley Chardonnay");
        mappedWine.setTankCode("T25-01");
        mappedWine.setProductState("Ready for bottling");
        mappedWine.setOwnerName("YV Wines Pty Ltd");
        Set<GrapeComponent> grapeComponents = new HashSet<GrapeComponent>();
        grapeComponents.add(new GrapeComponent(80D, 2011, "Chardonnay", "Yarra Valley"));
        grapeComponents.add(new GrapeComponent(10D, 2010, "Chardonnay", "Yarra Valley"));
        mappedWine.setComponents(grapeComponents);
    }

    @Test
    public void isShouldReturnOk() throws Exception
    {
        when(wineServiceMock.loadWineFromFile(any(String.class))).thenReturn(mappedWine);
        mvc.perform( MockMvcRequestBuilders
                .get("/composition/REGION/15MPPN002-VK")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void itShouldReturnNotFound() throws Exception
    {
        when(wineServiceMock.loadWineFromFile(any(String.class))).thenReturn(mappedWine);
        mvc.perform( MockMvcRequestBuilders
                .get("/composition/REGIONRRR/15MPPN002-VK")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.debugMessage").exists())
                .andExpect(jsonPath("$.debugMessage").isNotEmpty());
    }


    @Test
    public void itShoudReturnSomeComponents() throws Exception
    {
        when(wineServiceMock.loadWineFromFile(any(String.class))).thenReturn(mappedWine);
        mvc.perform( MockMvcRequestBuilders
                .get("/details/11YVCHAR001")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.components").exists())
                .andExpect(jsonPath("$.components[*].percentage").isNotEmpty());
    }


    }


