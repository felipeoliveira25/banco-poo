package application;

import java.util.Scanner;

import entidades.Banco;
import entidades.Conta;
import entidades.ContaNaoEncontrada;
import entidades.FundosInsuficientes;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco bank = new Banco();

        
        bank.addConta(new Conta(1, "Alice"));
        bank.addConta(new Conta(2, "Bob"));
        bank.addConta(new Conta(3, "Charlie"));

        
        try {
            bank.depositInAccount(1, 1000);
            bank.withdrawFromAccount(1, 300);
        } catch (ContaNaoEncontrada | FundosInsuficientes e) {
            System.out.println(e.getMessage());
        }

        
        System.out.println("Dados das contas após operações:");
        bank.getAccounts().forEach(System.out::println);

        
        try {
            System.out.println("Digite o número da conta para depósito:");
            int accountNumber = sc.nextInt();

            System.out.println("Digite o valor do depósito:");
            double depositValue = sc.nextDouble();
            bank.depositInAccount(accountNumber, depositValue);

            System.out.println("Digite o número da conta para saque:");
            accountNumber = sc.nextInt();
            System.out.println("Digite o valor do saque:");
            double withdrawValue = sc.nextDouble();
            bank.withdrawFromAccount(accountNumber, withdrawValue);
        } catch (ContaNaoEncontrada | FundosInsuficientes e) {
            System.out.println(e.getMessage());
        }

        
        System.out.println("Dados das contas após as operações:");
        bank.getAccounts().forEach(System.out::println);

        sc.close();
    }
}
