package devproblem.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/v2")
public class WineController {

    @GetMapping("wine/{wineId}")
    @ResponseBody
    public void getWineComponent(@PathVariable String wineId) {



    }
}
