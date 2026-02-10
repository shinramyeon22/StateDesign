class ActiveState implements AccountState {
    @Override
    public void activate(Account account) {
        System.out.println("Account is already activated!");
    }

    @Override
    public void suspend(Account account) {
        System.out.println("Account is suspended!");
        account.setState(account.getSuspendedState());
    }

    @Override
    public void close(Account account) {
        System.out.println("Account is closed!");
        account.setState(account.getClosedState());
    }

    @Override
    public void deposit(Account account, double amount) {
        account.balance += amount;
        System.out.println(account);  // calls toString()
    }

    @Override
    public void withdraw(Account account, double amount) {
        if (amount <= account.balance) {
            account.balance -= amount;
            System.out.println(account);  // calls toString()
        } else {
            System.out.println("Insufficient funds! Current balance: " + account.balance);
        }
    }
}