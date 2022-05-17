
public class Pizza {
    private String size;
    private int numberOfCheese;
    private int numberOfPepperoni;
    private int numberOfHam;

    private String smallSizeText = "small";
    private String mediumSizeText = "medium";
    private String largeSizeText = "large";

    private int smallSizePrice = 10; // Small: $10
    private int mediumSizePrice = 12; // Medium: $12
    private int largeSizePrice = 14; // Large: $14

    private int perToppingPrice = 2; // $2 per topping

    /**
     * Default constructor that set size to small, the other three instance
     * variables to 1.
     */
    public Pizza() {
        this.size = "small";
        this.numberOfCheese = 1;
        this.numberOfPepperoni = 1;
        this.numberOfHam = 1;
    }

    /**
     * Constructor that can set all of the instance variables.
     *
     * @param size              the size of the pizza.
     * @param numberOfCheese    the number of cheese of the pizza.
     * @param numberOfPepperoni the number of pepperoni of the pizza.
     * @param numberOfHam       the number of ham of the pizza.
     */
    public Pizza(String size, int numberOfCheese, int numberOfPepperoni, int numberOfHam) {
        this.size = size;
        this.numberOfCheese = numberOfCheese;
        this.numberOfPepperoni = numberOfPepperoni;
        this.numberOfHam = numberOfHam;
    }

    /**
     * size setter.
     *
     * @param size the size of the pizza.
     */
    public void setSize(String size) {
        if (size.equals(this.smallSizeText) || size.equals(this.mediumSizeText) || size.equals(this.largeSizeText)) {
            this.size = size;
        } else {
            System.out.println("[ERROR] Invalid size");
        }
    }

    /**
     * numberOfCheese setter.
     *
     * @param numberOfCheese the numberOfCheese of the pizza.
     */
    public void setNumberOfCheese(int numberOfCheese) {
        this.numberOfCheese = numberOfCheese;
    }

    /**
     * numberOfPepperoni setter.
     *
     * @param numberOfPepperoni the numberOfPepperoni of the pizza.
     */
    public void setNumberOfPepperoni(int numberOfPepperoni) {
        this.numberOfPepperoni = numberOfPepperoni;
    }

    /**
     * numberOfHam setter.
     *
     * @param numberOfHam the numberOfHam of the pizza.
     */
    public void setNumberOfHam(int numberOfHam) {
        this.numberOfHam = numberOfHam;
    }

    /**
     * size getter
     *
     * @return the size of the pizza.
     */
    public String getSize() {
        return this.size;
    }

    /**
     * numberOfCheese getter
     *
     * @return the numberOfCheese of the pizza.
     */
    public int getNumberOfCheese() {
        return this.numberOfCheese;
    }

    /**
     * numberOfPepperoni getter.
     *
     * @return the numberOfPepperoni of the pizza.
     */
    public int getNumberOfPepperoni() {
        return this.numberOfPepperoni;
    }

    /**
     * numberOfHam getter.
     *
     * @return the numberOfHam of the pizza.
     */
    public int getNumberOfHam() {
        return this.numberOfHam;
    }

    /**
     * Calculates and returns a double showing the price of the pizza.
     *
     * @return the cost of the pizza
     */
    public double calcCost() {
        double total = 0;

        if (this.size == this.smallSizeText) {
            total += this.smallSizePrice;
        } else if (this.size == this.mediumSizeText) {
            total += this.mediumSizePrice;
        } else if (this.size == this.largeSizeText) {
            total += this.largeSizePrice;
        } else {
            System.out.println("[ERROR] got invalid size");
            return 0;
        }

        total += (this.numberOfCheese + this.numberOfPepperoni + this.numberOfHam) * this.perToppingPrice;

        return total;
    }

    /**
     * Returns a string showing the information of the pizza.
     *
     * @return a string showing the information of the pizza.
     */
    @Override
    public String toString() {
        return String.format("size = %s, numOfCheese = %d, numOfPepperoni = %d, numOfHam = %d", this.size,
                this.numberOfCheese, this.numberOfPepperoni, this.numberOfHam);
    }

    /**
     * Determines whether this pizza is the same as the other one by their size, the
     * number of cheese toppings, the number of pepperoni toppings, and the number
     * of ham toppings.
     *
     * @param otherPizza
     * @return
     */
    public boolean equals(Pizza otherPizza) {
        if (!otherPizza.getSize().equals(this.size)) {
            return false;
        } else if (otherPizza.getNumberOfCheese() != this.numberOfCheese) {
            return false;
        } else if (otherPizza.getNumberOfPepperoni() != this.numberOfPepperoni) {
            return false;
        } else if (otherPizza.getNumberOfHam() != this.numberOfHam) {
            return false;
        } else {
            return true;
        }
    }
}
