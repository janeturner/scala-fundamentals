package App.models

abstract class BankAccount(accountNumber : String,
                           val balance: BigDecimal) {
  def withdraw(amount : Double) : BankAccount
  def deposit(amount : Double) : BankAccount
  override def toString: String = s"Account number:" +
    s"$accountNumber, balance : $balance"

}
