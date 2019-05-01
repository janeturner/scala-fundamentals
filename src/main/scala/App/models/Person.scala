package App.models

class Person(name : String, age : Int, val bankAccounts: Seq[BankAccount]) {
  private val excluded = List("adam", "daniel")
  //secondary constructor
  def this(name : String, age : Int) = this(name, age, Seq(new SavingsAccount("12345", 0.0)))

  def speak() : String = {

    val years: String = if(age > 1) "years" else "year"
    if (excluded.contains(name)) {
      s"G'day"
    } else {
      s"Hello $name, you are $age $years old. Your account details are $bankAccounts"
    }

  }

def calculateHowMuchDoshIHave: BigDecimal =  bankAccounts.foldLeft(BigDecimal(0))((runningTotal, account) => {
    runningTotal + account.balance
  })

}
