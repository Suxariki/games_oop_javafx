package ru.job4j;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.*;

public class LogicTest {

    public void ChessTeam(Logic logic) {
        logic.add(new PawnBlack(Cell.G1));
        logic.add(new PawnBlack(Cell.G2));
        logic.add(new PawnBlack(Cell.G3));
        logic.add(new PawnBlack(Cell.G4));
        logic.add(new PawnBlack(Cell.G5));
        logic.add(new PawnBlack(Cell.G6));
        logic.add(new PawnBlack(Cell.G7));
        logic.add(new PawnBlack(Cell.G8));
        logic.add(new RookBlack(Cell.H8));
        logic.add(new RookBlack(Cell.H1));
        logic.add(new KingBlack(Cell.H2));
        logic.add(new KingBlack(Cell.H7));
        logic.add(new BishopBlack(Cell.H3));
        logic.add(new BishopBlack(Cell.H6));
        logic.add(new KingBlack(Cell.H4));
        logic.add(new QueenBlack(Cell.H5));
    }

    @Test
    public void wayIsDiagonalAndFree() {
        Logic logic = new Logic();
        ChessTeam(logic);
        Assert.assertThat(logic.move(Cell.H3, Cell.F5), is(true));
    }

    @Test(expected = AssertionError.class)
    public void WayIsNotDiagonal() {
            Logic logic = new Logic();
            ChessTeam(logic);
            Assert.assertThat(logic.move(Cell.H3, Cell.E3), is(true)); //is тут может быть и true и false. Нормально?
    }

    @Test(expected = AssertionError.class)
    public void WayIsDiagonalAndNotFree() {
        Logic logic = new Logic();
        ChessTeam(logic);
        Assert.assertThat(logic.move(Cell.H3, Cell.G4), is(false));
    }
}
