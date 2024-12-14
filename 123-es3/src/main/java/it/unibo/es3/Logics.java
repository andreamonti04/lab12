package it.unibo.es3;

import java.util.List;

public interface Logics {
    
    void toStart();

    boolean toQuit();

    List<Pair<Integer, Integer>> getPos();
    
}
