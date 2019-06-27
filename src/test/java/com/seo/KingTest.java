package com.seo;

import org.junit.Assert;
import org.junit.Test;

public class KingTest {

    @Test
    public void getMovesTest1() {
        King King = new King();
        Assert.assertTrue(King.getMoves("c4").stream().filter(p -> p.contains("d3")).findAny().isPresent());
    }

    @Test
    public void getMovesTest2() {
        King King = new King();
        Assert.assertTrue(King.getMoves("e4").stream().filter(p -> p.contains("f5")).findAny().isPresent());
    }

    @Test
    public void getMovesTest3() {
        King King = new King();
        Assert.assertFalse(King.getMoves("h8").stream().filter(p -> p.contains("i7")).findAny().isPresent());
    }

    @Test
    public void getMovesTest4() {
        King King = new King();
        System.out.println("COUNT:--->" + King.getMoves("c4").stream().count());
        Assert.assertTrue(King.getMoves("c4").stream().count() == 9);
    }
}
