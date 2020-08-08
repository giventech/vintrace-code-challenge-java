package devproblem;


import devproblem.util.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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

		Utils.printYearBreakdown(w);
		System.out.println("\n");
		Utils.printVarietyBreakdown(w);
		System.out.println("\n");
		Utils.printRegionBreakdown(w);
		System.out.println("\n");
		Utils.printYearAndVarietyBreakdown(w);
		System.out.println("\n");

		SpringApplication.run(WineTest.class, args);
	}


}
