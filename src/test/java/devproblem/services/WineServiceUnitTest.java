package devproblem.services;

import devproblem.Wine;
import devproblem.services.WineService;
import devproblem.services.WineServiceImpl;
import devproblem.util.Utils;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


@RunWith(MockitoJUnitRunner.class)
public class WineServiceUnitTest {

    public static final String YVCHAR001 = "11YVCHAR001.json";
    public static final String YVCHAR002 = "11YVCHAR002.json";
    public static final String MPPN002 = "15MPPN002-VK.json";

    public Resource loadEmployees() {
        return new ClassPathResource("11YVCHAR001.json");
    }

    @InjectMocks
    private WineServiceImpl wineService;

    @BeforeEach
    public void setUp () {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void WhenProvidedCHAR001ItShouldReturnAWineObject() throws IOException {
        Wine wine  = wineService.loadWineFromFile(YVCHAR001);
        assert ( wine != null);
        assert ( wine.getComponents() != null);
    }

    @Test
    public void WhenProvidedYVCHAR002ItShouldReturnAWineObject() throws IOException {
        Wine wine  = wineService.loadWineFromFile(YVCHAR002);
        assert ( wine != null);
        assert ( wine.getComponents() != null);
    }
    @Test
    public void WhenProvidedMPPN002ItShouldReturnAWineObject() throws IOException {
        Wine wine  = wineService.loadWineFromFile(MPPN002);
        assert ( wine != null);
        assert ( wine.getComponents() != null);
    }


}
