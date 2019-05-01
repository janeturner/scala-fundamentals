package App.models

final class SavingsAccount(accountNumber: String, balance: BigDecimal) extends BankAccount(accountNumber, balance) {

  override def withdraw(amount: Double): BankAccount = {
    val newBalance: BigDecimal = balance - amount
    new SavingsAccount(this.accountNumber, newBalance)
    if ((balance - amount) < 0) {
      println(s"You have insufficient funds")
      this
    } else {
      val deducted = balance - amount
      println(s"Balance after deductions: $deducted")
      new SavingsAccount(accountNumber, deducted)
    }
  }

  override def deposit(amount: Double): BankAccount = {
    new SavingsAccount(accountNumber, balance + amount)
  }

}
