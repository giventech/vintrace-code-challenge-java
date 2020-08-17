package devproblem.restapi;

import devproblem.Wine;
import devproblem.exception.ErrorCode;
import devproblem.exception.WineException;
import devproblem.model.CompositionType;
import devproblem.services.WineService;
import devproblem.util.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "*")
public class WineController {

    @Autowired
    WineService wineService;

    @Operation(summary = "Response code ", description = "Get wine content", tags = {"load wine from profile"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Wine.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiError.class))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = {@Content(mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "422", description = "Unprocessable entity", content = {@Content(mediaType = APPLICATION_JSON_VALUE)}),
    })
    @GetMapping("/details/{aWineId}")
    @ResponseBody
    public ResponseEntity<Wine> getWineComponent(@PathVariable String aWineId) {
        Wine loadedWine = wineService.loadWineFromFile(aWineId + ".json");
        return ResponseEntity.ok(loadedWine);
    }

    @Operation(summary = "Response code ", description = "Get composition", tags = {"load composition based on composition type requested"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Object.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiError.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiError.class))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = {@Content(mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "422", description = "Unprocessable entity", content = {@Content(mediaType = APPLICATION_JSON_VALUE)}),
    })

    @GetMapping("/composition/{compositionType}/{aWineId}")
    @ResponseBody
    public ResponseEntity<Map<?, ?>> getComposition(@PathVariable String compositionType, @PathVariable String aWineId) {
        Optional<CompositionType> optionalCompositionType = Arrays.stream(CompositionType.values()).filter(value -> value.getCompositionType().equals(compositionType)).findAny();
        if (optionalCompositionType.isPresent()) {

            Wine loadedWine = wineService.loadWineFromFile(aWineId + ".json");
            if (compositionType.equals(CompositionType.REGION.getCompositionType())) {
                return ResponseEntity.ok(Utils.getRegionBreakDown(loadedWine));
            } else if (compositionType.equals(CompositionType.YEAR.getCompositionType())) {
                return ResponseEntity.ok(Utils.getYearBreadown(loadedWine));
            } else if (compositionType.equals(CompositionType.VARIETY.getCompositionType())) {
                return ResponseEntity.ok(Utils.getVarietyBreakdown(loadedWine));
            }  else if (compositionType.equals(CompositionType.YEAR_VARIETY.getCompositionType())) {
               return ResponseEntity.ok(Utils.getStringifiedYearAndVarietyBreakdown(loadedWine));
            }  else {
               throw new WineException("Composition Type does not exist", ErrorCode.INVALID_COMPOSITION_TYPE);
            }
        }
        throw new WineException("Wine composition  is invalid", ErrorCode.NO_COMPOISTION_FOR_WINE_ID);
        }
    }


