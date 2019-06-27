package com.seo;

import org.junit.Assert;
import org.junit.Test;

public class KnightTest {

    @Test
    public void getMovesTest1() {
        Knight knight = new Knight();
        Assert.assertTrue(knight.getMoves("c4").stream().filter(p -> p.contains("d6")).findAny().isPresent());
    }

    @Test
    public void getMovesTest2() {
        Knight knight = new Knight();
        Assert.assertTrue(knight.getMoves("c4").stream().filter(p -> p.contains("d2")).findAny().isPresent());
    }

    @Test
    public void getMovesTest3() {
        Knight knight = new Knight();
        Assert.assertFalse(knight.getMoves("h8").stream().filter(p -> p.contains("i10")).findAny().isPresent());
    }

    @Test
    public void getMovesTest4() {
        Knight knight = new Knight();
        System.out.println("COUNT:--->" + knight.getMoves("c4").stream().count());
        Assert.assertTrue(knight.getMoves("c4").stream().count() == 9);
    }
}
