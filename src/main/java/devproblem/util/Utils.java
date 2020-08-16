package devproblem.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import devproblem.GrapeComponent;
import devproblem.Tuple;
import devproblem.Wine;
import devproblem.exception.ErrorCode;
import devproblem.exception.WineException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public  class Utils {

    public static void printVarietyBreakdown(Wine w) {

        Map<String,Double> varietyBd =  w.getComponents().stream()
                .collect(Collectors.groupingBy(GrapeComponent::getVariety, Collectors.summingDouble(GrapeComponent::getPercentage)))
                .entrySet().stream()
                .sorted( Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        printMap(varietyBd);
    }

    public static Map <Integer, Double> getYearBreadown(Wine w) {
        TreeMap treeMap =  new TreeMap<Integer,Double>( w.getComponents().stream()
                .collect(Collectors.groupingBy(GrapeComponent::getYear, Collectors.summingDouble(GrapeComponent::getPercentage))));
        Map<Integer, Double> otherTreeMap = new TreeMap<Integer, Double>(
                Comparator.reverseOrder()
        );
        otherTreeMap.putAll(treeMap);
        return  otherTreeMap;

    }

    public static void printYearBreakdown(Wine w) {

        printMap(Utils.getYearBreadown(w));

    }

    public static void printRegionBreakdown(Wine w) {

        printMap(Utils.getRegionBreakDown(w));
    }

    public static Map <String,Double> getRegionBreakDown(Wine w) {
        Map <String,Double> regionBd;
        regionBd = w.getComponents().stream()
                .collect(Collectors.groupingBy(GrapeComponent::getRegion, Collectors.summingDouble(GrapeComponent::getPercentage)))
                .entrySet().stream()
                .sorted( Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return regionBd;

    }

    public static void printYearAndVarietyBreakdown(Wine w) {
        Map <Tuple,Double> varietyBd = 	  w.getComponents().stream()
                .collect(groupingBy(post -> new Tuple(post.getYear(), post.getVariety()),
                        Collectors.summingDouble(GrapeComponent::getPercentage)))
                .entrySet().stream()
                .sorted( Map.Entry.<Tuple, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        printMap(varietyBd);

    }

    //pretty print a map
    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            Object keyObject = entry.getKey();
            if (keyObject instanceof Tuple) {
                System.out.format( entry.getValue()
                        + " -- "
                        + ((Tuple)entry.getKey()).getYear()
                        + " -- "
                        + ((Tuple)entry.getKey()).getVariety() + "\n");
            } else	{
                System.out.format(entry.getValue() + " -- "
                        + entry.getKey() + "\n");
            }
        }
    }

    public static Wine loadWineFromFile(String fileRelativePath) {
        Resource resource =  new ClassPathResource(fileRelativePath);
        ObjectMapper mapper = new ObjectMapper();
        Wine wineConverted;
        try {
             wineConverted = mapper.readValue(resource.getFile(), Wine.class);
        } catch (IOException e) {
            throw new WineException(e.getMessage(), ErrorCode.FILE_LOAD_OR_ACCESS_ERRO);
         }
        return wineConverted;

    }

}
