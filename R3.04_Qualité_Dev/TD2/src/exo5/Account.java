package exo5;

public class Account {
    int balance = 100;

    private void withdraw(int amount) {
        if (amount>=balance){
            balance-=amount;
        } else {
            System.out.println("Not enought money");
        }

    }
}
