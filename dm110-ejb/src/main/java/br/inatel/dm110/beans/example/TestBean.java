package br.inatel.dm110.beans.example;

import br.inatel.dm110.interfaces.example.TestInterface;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;

@Stateful
public class TestBean implements TestInterface {

    private int valor;

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
