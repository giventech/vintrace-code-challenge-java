package devproblem.services;

import devproblem.Wine;

public interface WineService {
    Wine loadWineFromFile(String wineFileName);
}
