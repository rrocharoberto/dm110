package br.inatel.dm110.interfaces.example;

import br.inatel.dm110.api.example.HelloInterface;
import jakarta.ejb.Remote;

@Remote
public interface HelloRemote extends HelloInterface
{

}
