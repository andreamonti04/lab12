package it.unibo.es3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LogicsImpl implements Logics {

    private final int size;
    final Random randomic = new Random();
    private List<Pair<Integer, Integer>> but = new ArrayList<>();

    public LogicsImpl(int size) {
        this.size = size;
        while(but.size() < 3) {
            this.but.add(new Pair<Integer,Integer>(randomic.nextInt(this.size), randomic.nextInt(this.size)));
        }
    }

    @Override
    public void toStart() {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size; j++) {
                var p1 = new Pair<>(i, j);
                if (but.stream().anyMatch(p2 -> neighbours(p1, p2))) {
                    list.add(p1);
                }
            }
        }
        
        list.forEach(e -> {
            if(!but.contains(e)){
                but.add(e);
            }
        });
    }

    private boolean neighbours(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
        return Math.abs(p1.getX() - p2.getX()) <= 1 && Math.abs(p1.getY() - p2.getY()) <= 1 && !p1.equals(p2);
    }

    @Override
    public boolean toQuit() {
        return this.but.size() == this.size * this.size;
    }

    @Override
    public List<Pair<Integer, Integer>> getPos() {
        return Collections.unmodifiableList(this.but);
    }



}
