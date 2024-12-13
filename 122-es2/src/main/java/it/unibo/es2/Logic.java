package it.unibo.es2;
public interface Logic {
    boolean hit(Pair<Integer, Integer> pos);

    boolean quitRows();

    boolean quitCol();

}
