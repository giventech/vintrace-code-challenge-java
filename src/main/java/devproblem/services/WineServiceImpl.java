package devproblem.services;

import devproblem.Wine;
import devproblem.util.Utils;
import org.springframework.stereotype.Service;

@Service
public class WineServiceImpl implements WineService {

    @Override
    public Wine loadWineFromFile(String wineFileName) {
        return Utils.loadWineFromFile(wineFileName);
    }
}
