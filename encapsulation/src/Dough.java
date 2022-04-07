public class Dough {
   private String flourType;
   private String bakingTechnique;
   private double weight;


   public Dough(String flourType, String bakingTechnique, double weight){
       this.setFlourType(flourType);
       this.setBakingTechnique(bakingTechnique);
       this.setWeight(weight);
   }

   public double calculateCalories(){
       double flourTypeModifier = getFlourTypeModifier(this.flourType);
       double bakingTechniqueModifier= getBakingTechniqueModifier(this.bakingTechnique);
       return (2*weight) * flourTypeModifier;
   }

    private double getBakingTechniqueModifier(String bakingTechnique) {

        switch (bakingTechnique){
            case "Crispy": return 0.9;
            case "Chewy": return 1.1;
            default: return 0;
        }
    }

    private double getFlourTypeModifier(String flourType) {
        switch (flourType){
            case "White": return    1.5;
            case "WholeGrain": return 1.0;
            default: return 0;
        }
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }else
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique){
            case "Crispy":
            case "Chewy":
            case "Homemade":
                this.bakingTechnique = bakingTechnique;
                break;
            default: throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight>0 && weight <200){
            this.weight = weight;
        } else throw new IllegalArgumentException("Dough weight should be\n" +
                "in the range [1..200].");
    }


}
