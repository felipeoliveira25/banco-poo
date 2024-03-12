package entidades;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> accounts = new ArrayList<>();


    public void addConta(Conta account) {
        accounts.add(account);
    }
    
    public Conta encontraContaPeloNumero(int number) throws ContaNaoEncontrada {
        return accounts.stream()
                .filter(a -> a.getNumero() == number)
                .findFirst()
                .orElseThrow(() -> new ContaNaoEncontrada("Conta não encontrada."));
    }
    
    public void removeAccount(Conta account) {
        accounts.remove(account);
    }
    
    public void depositInAccount(int number, double amount) throws ContaNaoEncontrada {
        Conta account = encontraContaPeloNumero(number);
        account.deposito(amount);
    }
    
    public void withdrawFromAccount(int number, double amount) throws ContaNaoEncontrada, FundosInsuficientes {
        Conta account = encontraContaPeloNumero(number);
        account.withdraw(amount);
    }
    
    public List<Conta> getAccounts() {
        return accounts;
    }
}
