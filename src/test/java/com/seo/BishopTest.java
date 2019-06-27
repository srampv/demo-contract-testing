package com.seo;

import org.junit.Assert;
import org.junit.Test;

public class BishopTest {

    @Test
    public void getMovesTest1() {
        Bishop Bishop = new Bishop();
        Assert.assertTrue(Bishop.getMoves("a1").stream().filter(p -> p.contains("h8")).findAny().isPresent());
    }

    @Test
    public void getMovesTest2() {
        Bishop Bishop = new Bishop();
        Assert.assertTrue(Bishop.getMoves("d4").stream().filter(p -> p.contains("f6")).findAny().isPresent());
    }

    @Test
    public void getMovesTest3() {
        Bishop Bishop = new Bishop();
        Assert.assertFalse(Bishop.getMoves("h1").stream().filter(p -> p.contains("i0")).findAny().isPresent());
    }

    @Test
    public void getMovesTest4() {
        Bishop bishop = new Bishop();
        System.out.println("COUNT:--->" + bishop.getMoves("c4").stream().count());
        Assert.assertTrue(bishop.getMoves("c4").stream().count() == 12);
    }
}
