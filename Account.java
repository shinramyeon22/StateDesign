public class Account {
    private String accountNumber;
    protected double balance;

    // States
    private final AccountState activeState = new ActiveState();
    private final AccountState suspendedState = new SuspendedState();
    private final AccountState closedState = new ClosedState();

    private AccountState state;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.state = activeState;   // starts in active state
    }

    // State transitions
    public void setState(AccountState state) {
        this.state = state;
    }

    public AccountState getActiveState() {
        return activeState;
    }

    public AccountState getSuspendedState() {
        return suspendedState;
    }

    public AccountState getClosedState() {
        return closedState;
    }

    // Public behavior methods (delegated to current state)
    public void activate() {
        state.activate(this);
    }

    public void suspend() {
        state.suspend(this);
    }

    public void close() {
        state.close(this);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            state.deposit(this, amount);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            state.withdraw(this, amount);
        } else {
            System.out.println("Withdrawal amount must be positive!");
        }
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber + " | Balance: ₱" + String.format("%,.2f", balance);
    }

    // For testing convenience (optional)
    public double getBalance() {
        return balance;
    }
}