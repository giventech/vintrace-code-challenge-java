package devproblem;


import java.util.Objects;

//Tuple is used
public class Tuple implements Comparable<Tuple> {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return Objects.equals(year, tuple.year) &&
                Objects.equals(variety, tuple.variety);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, variety);
    }

    Integer year;;
    String variety;


    public Tuple(Integer year, String variety) {
        this.year = year;
        this.variety = variety;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    @Override
    public int compareTo(Tuple o) {

        return this.getYear() - o.getYear();

    }
}
