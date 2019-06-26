package com.seo;

import org.junit.Assert;
import org.junit.Test;


public class BlockTest {


    @Test
    public void testBlock4thRow7ThCol() {
        Assert.assertEquals(getBlock("4:7").getLowerRight().getX(), 800);
        Assert.assertEquals(getBlock("4:7").getLowerRight().getY(), 600);
    }

    @Test
    public void testBlock5thRow6ThCol() {
        Assert.assertEquals(getBlock("5:6").getLowerRight().getX(), 700);
        Assert.assertEquals(getBlock("5:6").getLowerRight().getY(), 500);
    }

    private Block getBlock(String c) {
        int ROW = Integer.parseInt(c.split("\\:")[0]);
        int COL = Integer.parseInt(c.split("\\:")[1]);
        System.out.println("ROW:COL:---->" + ROW + ":" + COL);
        ROW = ROW >= 9 ? 8 : ROW;
        COL = COL >= 9 ? 8 : COL;
        ROW = ROW <= 0 ? 1 : ROW;
        COL = COL <= 0 ? 1 : COL;
        Block b = new Block((COL) * 100, (10 - ROW - 1) * 100, (COL + 1) * 100, (10 - ROW) * 100, TYPE.NONE, COLOR.WHITE);
        b.setColor(COLOR.BLACK);
        return b;
    }
}
