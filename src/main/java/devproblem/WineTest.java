package devproblem;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


public class WineTest {

	public static void main(String[] args) {

		Wine w = new Wine("11YVCHAR001", 1000);
		w.setDescription("2011 Yarra Valley Chardonnay");
		w.setTankCode("T25-01");
		w.setProductState("Ready for bottling");
		w.setOwnerName("YV Wines Pty Ltd");
		
		
		w.getComponents().add(new GrapeComponent(80D, 2011, "Chardonnay", "Yarra Valley"));
		w.getComponents().add(new GrapeComponent(10D, 2010, "Chardonnay", "Macedon"));
		w.getComponents().add(new GrapeComponent(5D, 2011, "Pinot Noir", "Mornington"));
		w.getComponents().add(new GrapeComponent(5D, 2010, "Pinot Noir", "Macedon"));

		printYearBreakdown(w);
		System.out.println("\n");
		printVarietyBreakdown(w);
		System.out.println("\n");
		printRegionBreakdown(w);
		System.out.println("\n");
		printYearAndVarietyBreakdown(w);
		System.out.println("\n");
	}

	private static void printVarietyBreakdown(Wine w) {

		Map <String,Double> varietyBd =  w.getComponents().stream()
			.collect(Collectors.groupingBy(GrapeComponent::getVariety, Collectors.summingDouble(GrapeComponent::getPercentage)))
			.entrySet().stream()
			.sorted( Map.Entry.<String, Double>comparingByValue().reversed())
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		printMap(varietyBd);
	}

	private static void printYearBreakdown(Wine w) {
		TreeMap treeMap =  new TreeMap<Integer,Double>( w.getComponents().stream()
				.collect(Collectors.groupingBy(GrapeComponent::getYear, Collectors.summingDouble(GrapeComponent::getPercentage))));
		Map<Integer, Double> otherTreeMap = new TreeMap<Integer, Double>(
				Comparator.reverseOrder()
		);
		otherTreeMap.putAll(treeMap);
		printMap(otherTreeMap);

	}
	
	private static void printRegionBreakdown(Wine w) {
		Map <String,Double> regionBd;
		regionBd = w.getComponents().stream()
				.collect(Collectors.groupingBy(GrapeComponent::getRegion, Collectors.summingDouble(GrapeComponent::getPercentage)))
				.entrySet().stream()
				.sorted( Map.Entry.<String, Double>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		printMap(regionBd);
	}
	
	private static void printYearAndVarietyBreakdown(Wine w) {
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


//	public static Map<Integer, Object> asFlattendMap(Map<Integer, Map<String, List<GrapeComponent>>> map) {
//		return map.entrySet().stream()
//				.flatMap(WineTest::flatten)
//				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//	}
//
//	private static Stream<Map.Entry<Integer, ?>> flatten(Map.Entry<Integer, ?> entry) {
//		if (entry.getValue() instanceof Map) {
//			return ((Map<Integer,?>) entry.getValue()).entrySet().stream().flatMap(WineTest::flatten);
//		}
//		return Stream.of(entry);
//	}


}
