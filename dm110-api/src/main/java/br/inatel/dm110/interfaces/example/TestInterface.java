package br.inatel.dm110.interfaces.example;

import jakarta.ejb.Local;

@Local
public interface TestInterface {
    
    public void setValor(int valor);

    public int getValor();
}
