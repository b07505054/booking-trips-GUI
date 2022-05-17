/**
 * Instead of here, All docstrings should be written at the interface's
 * function declaration.
 */
public class Simple_ATM_Service implements ATM_Service {

    @Override
    public boolean checkBalance(Account account, int money) throws ATM_Exception {
        if (account.getBalance() < money) {
            throw new ATM_Exception(ATM_Exception.ExceptionTYPE.BALANCE_NOT_ENOUGH);
        }
        return true;
    }

    @Override
    public boolean isValidAmount(int money) throws ATM_Exception {
        if (money % 1000 != 0) {
            throw new ATM_Exception(ATM_Exception.ExceptionTYPE.AMOUNT_INVALID);
        }
        return true;
    }

    @Override
    public void withdraw(Account account, int money) {
        try {
            checkBalance(account, money);
            isValidAmount(money);

            account.setBalance(account.getBalance() - money);

        } catch (ATM_Exception atmException) {
            System.out.println(atmException.getMessage());
        }

        System.out.printf("updated balance : %d\n", account.getBalance());
    }

}
