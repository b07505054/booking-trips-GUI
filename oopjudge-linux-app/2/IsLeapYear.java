
public class IsLeapYear {
    public boolean determine(int year) {
        if (year % 400 == 0) {
            return true; // exactly divisible by 400 is a leap year
        } else if (year % 100 == 0) {
            return false; // exactly divisible by 100 is not a leap year
        } else if (year % 4 == 0) {
            return true; // exactly divisible by 4 is a leap year
        } else {
            return false;
        }
    }
}
