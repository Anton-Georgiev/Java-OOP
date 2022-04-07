package ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
       setLength(length);
       setWidth(width);
       setHeight(height);
    }

    public double calculateVolume(){
        return length*width*height;
    }

    public double calculateLateralArea(){
        return 2*length*height + 2*width*height;
    }
    public double calculateSurfaceArea(){
        return 2*length*width + 2*length*height + 2* width*height;
    }

    private void setLength(double length) {
        validateSide(length);
        this.length = length;
    }

    private void setWidth(double width) {
        validateSide(width);
        this.width = width;
    }

    private void setHeight(double height) {
        validateSide(height);
        this.height = height;
    }


    private void validateSide(double length) {
        if (length <=0){
            throw new IllegalArgumentException("side must be a positive number!");
        }
    }

}
