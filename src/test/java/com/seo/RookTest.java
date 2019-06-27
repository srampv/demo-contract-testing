package com.seo;

import org.junit.Assert;
import org.junit.Test;

public class RookTest {

    @Test
    public void getMovesTest1() {
        Rook Rook = new Rook();
        Assert.assertTrue(Rook.getMoves("c4").stream().filter(p -> p.contains("d4")).findAny().isPresent());
    }

    @Test
    public void getMovesTest2() {
        Rook Rook = new Rook();
        Assert.assertTrue(Rook.getMoves("c4").stream().filter(p -> p.contains("c7")).findAny().isPresent());
    }

    @Test
    public void getMovesTest3() {
        Rook Rook = new Rook();
        Assert.assertFalse(Rook.getMoves("h8").stream().filter(p -> p.contains("i10")).findAny().isPresent());
    }

    @Test
    public void getMovesTest4() {
        Rook rook = new Rook();
        System.out.println("COUNT:--->" + rook.getMoves("a1").stream().count());
        Assert.assertTrue(rook.getMoves("a1").stream().count() == 15);
    }
}
