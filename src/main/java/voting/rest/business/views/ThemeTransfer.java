package voting.rest.business.views;

public class ThemeTransfer {
   
    private String name;
    
    private double average;

    
    public ThemeTransfer() {
    
    }

    public ThemeTransfer( String name, double average) {
        this.name = name;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
    
    
    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }    
}
