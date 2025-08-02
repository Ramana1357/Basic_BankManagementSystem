fun main() {
    val manager = BankAccountManager()
    while(true){
        println("Welcome to Bank Management System")
        println("1. Create Account")
        println("2. Get Account Details")
        println("3. Delete Account")
        println("4. Deposit Money")
        println("5. Withdraw Money")
        println("6. Change Bank")
        println("7. Exit")

        when(readLine()?.toIntOrNull()) {
            1 -> {
                println("Select bank (1. SBI, 2. HDFC, 3. Canara, 4. Union, 5. Punjab):")
                val bankChoice = readLine()?.toIntOrNull() ?: 0
                val bank = when(bankChoice) {
                    1 -> Banks.SBI
                    2 -> Banks.HDFC
                    3 -> Banks.Canara
                    4 -> Banks.Union
                    5 -> Banks.Punjab
                    else -> {
                        println("Invalid bank choice.")
                        continue
                    }
                }

                // here we will generate a random account number for the user

                val accountNumber = manager.generateAccountNumber(bank)
                println("Generated Account Number: $accountNumber")
                println("Enter password:")

                // Here we should must take the password from the user
                val password = readLine() ?: ""
                if (password.isBlank()) {
                    println("Password cannot be empty. Please try again.")
                    continue
                }
                manager.createAccount(accountNumber, bank, password)
            }
            2 -> {
                println("Enter account number:")
                val accountNumber = readLine() ?: ""
                println("Enter password:")
                val password = readLine() ?: ""
                manager.getAccount(accountNumber, password)
            }
            3 -> {
                println("Enter account number:")
                val accountNumber = readLine() ?: ""
                println("Enter password:")
                val password = readLine() ?: ""
                manager.deleteAccount(accountNumber, password)
            }
            4 -> {
                println("Enter account number:")
                val accountNumber = readLine() ?: ""
                println("Enter password:")
                val password = readLine() ?: ""
                println("Enter amount to deposit:")
                val amount = readLine()?.toDoubleOrNull() ?: 0.0
                manager.deposit(accountNumber, password, amount)
            }
            5 -> {
                println("Enter account number:")
                val accountNumber = readLine() ?: ""
                println("Enter password:")
                val password = readLine() ?: ""
                println("Enter amount to withdraw:")
                val amount = readLine()?.toDoubleOrNull() ?: 0.0
                manager.withdraw(accountNumber, password, amount)
            }

            6 -> {
                println("Enter account number:")
                val accountNumber = readLine() ?: ""
                println("Enter password:")
                val password = readLine() ?: ""
                println("Select new bank (1. SBI, 2. HDFC, 3. Canara, 4. Union, 5. Punjab):")
                val bankChoice = readLine()?.toIntOrNull() ?: 0
                val newBank = when(bankChoice) {
                    1 -> Banks.SBI
                    2 -> Banks.HDFC
                    3 -> Banks.Canara
                    4 -> Banks.Union
                    5 -> Banks.Punjab
                    else -> {
                        println("Invalid bank choice.")
                        continue
                    }
                }
                manager.changeBank(accountNumber, newBank, password)
            }
            7 -> {
                println("Exiting...")
                return
            }
            else -> {
                println("Invalid option. Please try again.")
            }
        }
    }
}
