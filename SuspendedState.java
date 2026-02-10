class SuspendedState implements AccountState {
    @Override
    public void activate(Account account) {
        System.out.println("Account is activated!");
        account.setState(account.getActiveState());
    }

    @Override
    public void suspend(Account account) {
        System.out.println("Account is already suspended!");
    }

    @Override
    public void close(Account account) {
        System.out.println("Account is closed!");
        account.setState(account.getClosedState());
    }

    @Override
    public void deposit(Account account, double amount) {
        System.out.println("You cannot deposit on a suspended account!");
        System.out.println(account);
    }

    @Override
    public void withdraw(Account account, double amount) {
        System.out.println("You cannot withdraw on a suspended account!");
        System.out.println(account);
    }
}