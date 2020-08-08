package devproblem.restapi;

import devproblem.Wine;
import devproblem.services.WineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class WineController {

    @Autowired
    WineService wineService;


    @Operation(summary = "Login AOS", description = "Validate customer details", tags = {"Login AOS"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Wine.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiError.class))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = {@Content(mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "422", description = "Unprocessable entity", content = {@Content(mediaType = APPLICATION_JSON_VALUE)}),
    })
    @GetMapping("/wine/{wineId}")
    @ResponseBody
    public ResponseEntity<Wine> getWineComponent(@PathVariable String wineId) {
        Wine loadedWine = wineService.loadWineFromFile(wineId +".json");
        return ResponseEntity.ok(loadedWine);
    }
}
