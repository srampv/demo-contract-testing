package com.seo;

import org.junit.Assert;
import org.junit.Test;

public class PawnTest {

    @Test
    public void getMovesTest1() {
        Pawn pawn = new Pawn();
        Assert.assertTrue(pawn.getMoves("c4").stream().count() == 4);
    }

    @Test
    public void getMovesTest2() {
        Pawn pawn = new Pawn();
        Assert.assertTrue(pawn.getMoves("h8").stream().count() == 1);
    }

    @Test
    public void getMovesTest3() {
        Pawn pawn = new Pawn();
        Assert.assertTrue(pawn.getMoves("h1").stream().filter(p -> p.contains("h2")).findAny().isPresent());
    }

    @Test
    public void getMovesTest4() {
        Pawn pawn = new Pawn();
        Assert.assertFalse(pawn.getMoves("h1").stream().filter(p -> p.contains("i9")).findAny().isPresent());
    }

}
