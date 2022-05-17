
public class GreenCrud {

    private int growsEvery = 5;  // the green crud population grows every five days

    public int calPopulation(int initialSize, int days) {

        if (days / growsEvery <= 1) {
            return initialSize;
        } else {
            return calPopulation(initialSize, days - growsEvery) + calPopulation(initialSize, days - growsEvery * 2);  // recursively calculates Fibonacci sequence
        }
    }
}
