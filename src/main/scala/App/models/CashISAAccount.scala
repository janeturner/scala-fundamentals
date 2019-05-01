package App.models

final class CashISAAccount(accountNumber: String,
                           balance: BigDecimal,
                           private val depositThreshold : Double = 200.00) extends BankAccount(accountNumber, balance) {

  override def withdraw(amount: Double): BankAccount = {
    println(s"You can't withdraw yet, your money is locked in for 3 years!!! And... we've reduced your APR to 0.2%!")
    this
  }

  override def deposit(amount: Double): BankAccount = {
    if (amount > depositThreshold) {
      val difference = amount - depositThreshold
      println(s"You can't deposit more than £$depositThreshold. Excess: £$difference.")
      new CashISAAccount(accountNumber, balance + depositThreshold)
    } else {
      new CashISAAccount(accountNumber, balance + amount)
    }
  }
}
