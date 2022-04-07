public class Light {
    private Color color;

    @Override
    public String toString() {
        return color.name();
    }

    public Light(Color color){
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public void changeColor(){
        switch (this.color){
            case RED:
                this.color = Color.GREEN;
                break;
            case GREEN:
                this.color = Color.YELLOW;
                break;
            case YELLOW:
                this.color = Color.RED;
                break;
        }
    }

}
