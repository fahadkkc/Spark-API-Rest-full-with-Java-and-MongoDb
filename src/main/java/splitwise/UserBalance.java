package splitwise;

public class UserBalance {
    private String userId;
    private float balance;

    public UserBalance(String userId, float balance) {
        this.userId = userId;
        this.balance = balance;
    }

    // Getters for serialization
    public String getUserId() {
        return userId;
    }

    public float getBalance() {
        return balance;
    }
}