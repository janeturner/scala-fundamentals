package App

import App.models.{BankAccount, CashISAAccount, Person}
import App.views.Prompt



object GreeterApplication extends App {

  val name = Prompt.ask("What's ya name?")
  val age = Prompt.ask("How old are ya?")


  val cashisa = new CashISAAccount("45678", 0.0, 1000.00)
  val deposited = cashisa.deposit(1000.00)
  val withdrawn = deposited.withdraw(200.00)
  val normalAccount = new CashISAAccount("12334", 100.00)
  val loyalAccountDeposited = normalAccount.deposit(300.00)
  val personAccounts: Seq[BankAccount] = Seq(loyalAccountDeposited)
  val loyal = new Person("Loyal customer", 22, personAccounts)
 Prompt.reply(loyal.speak())

  val person = new Person(name, age.toInt, Nil)
  println(person.speak())

  val nameSet = Set("adam", "daniel", "david", "adam")
  println(nameSet)

  //val account = new SavingsAccount("1", 2.3)
 // val withdrawnAccount = account.withdraw(0)
 // val depositAccount = account.deposit(5)
 // println(account.balance)
 // println(depositAccount.balance)


}
