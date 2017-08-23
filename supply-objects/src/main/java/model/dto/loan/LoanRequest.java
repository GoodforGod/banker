package model.dto.loan;

public class LoanRequest {

    private Long balance;
    private Long amount;

    public LoanRequest() { }

    public LoanRequest(Integer balance, Integer amount) {
        this.balance = (long)balance;
        this.amount = (long)amount;
    }

    public LoanRequest(Long balance, Long amount) {
        this.balance = balance;
        this.amount = amount;
    }

    public Long getBalance() {
        return balance;
    }

    public Long getAmount() {
        return amount;
    }
}
