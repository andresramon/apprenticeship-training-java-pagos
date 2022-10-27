package org.cokaido.apprenticeship;

import java.util.Objects;

public class Player{

    private final String id;

    public Player(final String id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
