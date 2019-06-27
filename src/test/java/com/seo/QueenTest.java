package com.seo;

import org.junit.Assert;
import org.junit.Test;

public class QueenTest {

    @Test
    public void getMovesTest1() {
        Queen Queen = new Queen();
        Assert.assertTrue(Queen.getMoves("c4").stream().filter(p -> p.contains("d5")).findAny().isPresent());
    }

    @Test
    public void getMovesTest2() {
        Queen Queen = new Queen();
        Assert.assertTrue(Queen.getMoves("c4").stream().filter(p -> p.contains("b3")).findAny().isPresent());
    }

    @Test
    public void getMovesTest3() {
        Queen Queen = new Queen();
        Assert.assertFalse(Queen.getMoves("h8").stream().filter(p -> p.contains("i10")).findAny().isPresent());
    }

    @Test
    public void getMovesTest4() {
        Queen queen = new Queen();
        System.out.println("COUNT:--->" + queen.getMoves("a1").stream().count());
        Assert.assertTrue(queen.getMoves("a1").stream().count() == 22);
    }
}
