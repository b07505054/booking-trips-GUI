
public interface ATM_Service {

    /**
     * Helps checking whether balance in user's account is sufficient, if not,
     * throws an exception named 𝙰𝚃𝙼_𝙴𝚡𝚌𝚎𝚙𝚝𝚒𝚘𝚗 with type of
     * "BALANCE_NOT_ENOUGH"
     *
     * @param account
     * @param money
     * @return
     * @throws ATM_Exception
     */
    public boolean checkBalance(Account account, int money) throws ATM_Exception;

    /**
     * Checks if amount of money can be divided by 1000, if not, throws an exception
     * named 𝙰𝚃𝙼_𝙴𝚡𝚌𝚎𝚙𝚝𝚒𝚘𝚗 with type of "AMOUNT_INVALID"
     *
     * @param money
     * @return
     * @throws ATM_Exception
     */
    public boolean isValidAmount(int money) throws ATM_Exception;

    /**
     *
     * @param account
     * @param money
     */
    public void withdraw(Account account, int money);
}
