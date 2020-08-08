package devproblem.util;

import devproblem.GrapeComponent;
import devproblem.Tuple;
import devproblem.Wine;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public  final class Utils {
    public static void printVarietyBreakdown(Wine w) {

        Map<String,Double> varietyBd =  w.getComponents().stream()
                .collect(Collectors.groupingBy(GrapeComponent::getVariety, Collectors.summingDouble(GrapeComponent::getPercentage)))
                .entrySet().stream()
                .sorted( Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        printMap(varietyBd);
    }

    public static void printYearBreakdown(Wine w) {
        TreeMap treeMap =  new TreeMap<Integer,Double>( w.getComponents().stream()
                .collect(Collectors.groupingBy(GrapeComponent::getYear, Collectors.summingDouble(GrapeComponent::getPercentage))));
        Map<Integer, Double> otherTreeMap = new TreeMap<Integer, Double>(
                Comparator.reverseOrder()
        );
        otherTreeMap.putAll(treeMap);
        printMap(otherTreeMap);

    }

    public static void printRegionBreakdown(Wine w) {
        Map <String,Double> regionBd;
        regionBd = w.getComponents().stream()
                .collect(Collectors.groupingBy(GrapeComponent::getRegion, Collectors.summingDouble(GrapeComponent::getPercentage)))
                .entrySet().stream()
                .sorted( Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        printMap(regionBd);
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

}
