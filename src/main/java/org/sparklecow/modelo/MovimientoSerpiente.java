package org.sparklecow.modelo;

import java.util.ArrayList;
import java.util.List;

public class MovimientoSerpiente {

    public List<int[]> snake = new ArrayList<>();
    public MovimientoSerpiente(int cantidad){
        int[] a = {cantidad / 2 - 1, cantidad / 2 - 1};
        int[] b = {cantidad / 2, cantidad / 2 - 1};
        snake.add(a);
        snake.add(b);
    }
}
