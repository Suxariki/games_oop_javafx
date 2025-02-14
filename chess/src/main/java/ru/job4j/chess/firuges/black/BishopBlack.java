package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(source.x - dest.x);
        Cell[] steps = new Cell[size];
        int deltaX = source.x - dest.x;
        int deltaY = source.y - dest.y;
        int xStep = deltaX > 0 ? -1 : 1;
        int yStep = deltaY > 0 ? -1 : 1;
        for (int index = 0; index < size; index++) {
            int first = source.x + xStep * (index + 1);
            int second = source.y + yStep * (index + 1);
            steps[index] = Cell.values()[first * 8 + second];
        }
        return steps;
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        int resultX = Math.abs(source.x - dest.x);
        int resultY = Math.abs(source.y - dest.y);
        if (resultX == resultY) {
            result = true;
        }
        return result;
    }


    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}