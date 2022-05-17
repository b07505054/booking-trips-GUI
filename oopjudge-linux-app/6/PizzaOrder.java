
public class PizzaOrder {

    int numberPizzas;

    Pizza pizza1;
    Pizza pizza2;
    Pizza pizza3;

    /**
     * numberPizzas setter
     *
     * @param numberPizzas number of pizzas
     * @return
     */
    public boolean setNumberPizzas(int numberPizzas) {
        if (numberPizzas <= 3 && numberPizzas >= 1) {
            this.numberPizzas = numberPizzas;
            return true;
        } else {
            return false;
        }
    }

    /**
     * pizza1 setter
     *
     * @param pizza
     */
    public void setPizza1(Pizza pizza) {
        if (this.numberPizzas >= 1) {
            this.pizza1 = pizza;
        } else {
            System.out.println("[ERROR] Invalid pizza number");
        }
    }

    /**
     * pizza2 setter
     *
     * @param pizza
     */
    public void setPizza2(Pizza pizza) {
        if (this.numberPizzas >= 2) {
            this.pizza2 = pizza;
        } else {
            System.out.println("[ERROR] Invalid pizza number");
        }
    }

    /**
     * pizza3 setter
     *
     * @param pizza
     */
    public void setPizza3(Pizza pizza) {
        if (this.numberPizzas >= 3) {
            this.pizza3 = pizza;
        } else {
            System.out.println("[ERROR] Invalid pizza number");
        }
    }

    /**
     * Calculates the total cost for pizzas in order
     *
     * @return The total cost of this order
     */
    public double calcTotal() {
        if (this.numberPizzas == 1) {
            return pizza1.calcCost();
        } else if (this.numberPizzas == 2) {
            return this.pizza1.calcCost() + this.pizza2.calcCost();
        } else if (this.numberPizzas == 3) {
            return this.pizza1.calcCost() + this.pizza2.calcCost() + this.pizza3.calcCost();
        } else {
            System.out.println("[ERROR] Invalid pizza number");
            return 0;
        }
    }
}
