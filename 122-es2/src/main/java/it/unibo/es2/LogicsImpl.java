package it.unibo.es2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LogicsImpl implements Logic{

    private final List<List<Boolean>> map;
    private final int size;

    public LogicsImpl(int size) {
        this.size = size;
        this.map = new ArrayList<>();
        for(int i = 0; i < size; i++){
            List <Boolean> list = new ArrayList<>();
            this.map.add(list);
            for(int j = 0; j < size ; j++){
                list.add(false);
            }
        }
    }

    @Override
    public boolean hit(Pair<Integer, Integer> pos) {
       boolean variable = !this.map.get(pos.getX()).get(pos.getY());
       this.map.get(pos.getX()).set(pos.getY(), variable);
       return variable;

    }

    @Override
    public boolean quitRows() {
       return map.stream().anyMatch(r -> r.stream().allMatch(b -> b));
       //anyMatch -> controlla se almeno una riga soddisfa una condizione
       //verifica che ogni valore b nella riga sia true
    }

    @Override
    public boolean quitCol() {
        return IntStream.range(0, this.size)
            .anyMatch(i -> map.stream() //i rappresenta l'indice di una colonna
                .allMatch(l -> l.get(i))        //verifico se tutte le righe l contengono true nella colonna i
            );
    }

   

}
