package ru.job4j;

import org.junit.Assert;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BlackBishopTest {
    @Test
    public void positionTest() {
        BishopBlack b = new BishopBlack(Cell.C1);
        assertThat(b.position(),is(Cell.C1));
    }

    @Test
    public void copyPositionTest() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        bishop = (BishopBlack) bishop.copy(Cell.E6);
        Assert.assertThat(bishop.position(), is(Cell.E6));
    }

    @Test
    public void wayTest() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] start = bishop.way(bishop.position(), Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertThat(start, is (expected));
    }

}
