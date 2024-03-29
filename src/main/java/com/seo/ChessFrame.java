package com.seo;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ChessFrame extends JFrame implements ActionListener, ChangeListener, MouseListener, WindowListener, MouseMotionListener {
    private static Block blocks[][] = new Block[8][8];

    static {
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                blocks[i][j] = getBlock((i + 1) + ":" + (j + 1));
            }
        }
    }

    public ChessFrame() throws HeadlessException {
        setSize(new Dimension(1000, 1000));
        setVisible(true);
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowListener(this);

    }

    public ChessFrame(GraphicsConfiguration gc) {
        super(gc);
    }

    public ChessFrame(String title) throws HeadlessException {
        super(title);
    }

    public ChessFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int X = 100, Y = 100;
        int WIDTH = 100;
        //VERTICAL
        g.drawLine(X, Y, X, X + 8 * WIDTH);
        g.drawLine(X + WIDTH, Y, X + WIDTH, X + 8 * WIDTH);
        g.drawLine(X + 2 * WIDTH, Y, X + 2 * WIDTH, X + 8 * WIDTH);
        g.drawLine(X + 3 * WIDTH, Y, X + 3 * WIDTH, X + 8 * WIDTH);
        g.drawLine(X + 4 * WIDTH, Y, X + 4 * WIDTH, X + 8 * WIDTH);
        g.drawLine(X + 5 * WIDTH, Y, X + 5 * WIDTH, X + 8 * WIDTH);
        g.drawLine(X + 6 * WIDTH, Y, X + 6 * WIDTH, X + 8 * WIDTH);
        g.drawLine(X + 7 * WIDTH, Y, X + 7 * WIDTH, X + 8 * WIDTH);
        g.drawLine(X + 8 * WIDTH, Y, X + 8 * WIDTH, X + 8 * WIDTH);
        //HORIZONTAL
        g.drawLine(X, Y, Y + 8 * WIDTH, Y);
        g.drawLine(X, Y + WIDTH, Y + 8 * WIDTH, Y + WIDTH);
        g.drawLine(X, Y + 2 * WIDTH, Y + 8 * WIDTH, Y + 2 * WIDTH);
        g.drawLine(X, Y + 3 * WIDTH, Y + 8 * WIDTH, Y + 3 * WIDTH);
        g.drawLine(X, Y + 4 * WIDTH, Y + 8 * WIDTH, Y + 4 * WIDTH);
        g.drawLine(X, Y + 5 * WIDTH, Y + 8 * WIDTH, Y + 5 * WIDTH);
        g.drawLine(X, Y + 6 * WIDTH, Y + 8 * WIDTH, Y + 6 * WIDTH);
        g.drawLine(X, Y + 7 * WIDTH, Y + 8 * WIDTH, Y + 7 * WIDTH);
        g.drawLine(X, Y + 8 * WIDTH, Y + 8 * WIDTH, Y + 8 * WIDTH);
        g.drawString("a", 140, 920);
        g.drawString("b", 230, 920);
        g.drawString("c", 320, 920);
        g.drawString("d", 440, 920);
        g.drawString("e", 540, 920);
        g.drawString("f", 630, 920);
        g.drawString("g", 720, 920);
        g.drawString("h", 840, 920);

        g.drawString("1", 70, 850);
        g.drawString("2", 70, 752);
        g.drawString("3", 73, 652);
        g.drawString("4", 73, 548);
        g.drawString("5", 69, 452);
        g.drawString("6", 76, 348);
        g.drawString("7", 75, 254);
        g.drawString("8", 77, 150);
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                if (blocks[i][j].getColor().name().equalsIgnoreCase("BLACK")) {
                    g.setColor(Color.BLACK);
                } else if (blocks[i][j].getColor().name().equalsIgnoreCase("WHITE")) {
                    g.setColor(Color.WHITE);
                } else if (blocks[i][j].getColor().name().equalsIgnoreCase("RED")) {
                    g.setColor(Color.RED);
                } else if (blocks[i][j].getColor().name().equalsIgnoreCase("GREEN")) {
                    g.setColor(Color.GREEN);
                } else if (blocks[i][j].getColor().name().equalsIgnoreCase("BLUE")) {
                    g.setColor(Color.BLUE);
                } else {
                    g.setColor(Color.GRAY);
                }

                g.fillRect(blocks[i][j].getUpperLeft().getX(), blocks[i][j].getUpperLeft().getY(), 100, 100);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + ":" + e.getY());


        Path p = Paths.get("C:\\users\\VenkPi\\chess.properties");
        p.getFileSystem().getFileStores().forEach(c -> System.out.println(c));
        try {
            findBlock(e.getX(), e.getY());
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            repaint();
        }

    }

    private Block findBlock(int clickedLocationX, int clickedLocationY) {
        final Block[] returBlock = new Block[1];
        for (int i = 0; i < blocks.length; i++) {
            Arrays.asList(blocks[i]).stream().filter(block -> {
                return block.isValidCoOrdinates(clickedLocationX, clickedLocationY);
            }).findFirst().ifPresent(c -> {
                System.out.println("GOTCHA:---->" + c.getLowerRight());
                for (int k = 0; k < blocks.length; k++) {
                    for (int l = 0; l < blocks.length; l++) {
                        if (blocks[k][l].getLowerRight().getX() == c.getLowerRight().getX() && blocks[k][l].getLowerRight().getY() == c.getLowerRight().getY()) {
                            System.out.println("K:L:--->" + (k + 1) + ":" + (l + 1));
                            Block b = getBlock((k + 1) + ":" + (l + 1));
                            b.setType(TYPE.BISHOP);
                            Bishop bishop = new Bishop();
                            bishop.getMoves(ChessUtil.getCharValue(k + 1) + (l + 1)).stream().forEach(move -> {
                                System.out.println("BISHOP MOVES:---->" + move);
                                int val1 = ChessUtil.getIntValue(move.toCharArray()[0] + "".trim()) - 1;
                                int val2 = (Integer.parseInt(move.toCharArray()[1] + "".trim()) - 1);
                                Block tempBlock = getBlock(val1 + ":" + val2);
                                tempBlock.setColor(COLOR.RED);
                                blocks[val1 - 1][val2 - 1] = tempBlock;
                            });
                            blocks[k][l] = b;
                            System.out.printf(new com.seo.Dimension((k + 1), (l + 1)) + ":---->%s %s %s %s", b.getUpperLeft(), b.getUpperRight(), b.getLowerLeft(), b.getLowerRight());
                            returBlock[0] = b;
                        }
                    }
                }
            });
        }
        return returBlock[0];

    }

    /**
     * This method always expects index from 1 not 0
     *
     * @param c
     * @return
     */
    private static Block getBlock(String c) {
        int ROW = Integer.parseInt(c.split("\\:")[0]);
        int COL = Integer.parseInt(c.split("\\:")[1]);
        System.out.println("ROW:COL:---->" + ROW + ":" + COL);
        ROW = ROW >= 9 ? -1 : ROW;
        COL = COL >= 9 ? -1 : COL;
        ROW = ROW <= 0 ? -1 : ROW;
        COL = COL <= 0 ? -1 : COL;
        if (ROW == -1 || COL == -1) {
            return new Block(0, 0, 0, 0, TYPE.NONE, COLOR.WHITE);
        }
        Block b = new Block((COL) * 100, (10 - ROW - 1) * 100, (COL + 1) * 100, (10 - ROW) * 100, TYPE.NONE, COLOR.WHITE);
        if (ROW % 2 == 1) {
            if (COL % 2 == 1) {
                b.setColor(COLOR.WHITE);
            } else {
                b.setColor(COLOR.BLACK);
            }
        } else {
            if (COL % 2 == 1) {
                b.setColor(COLOR.BLACK);
            } else {
                b.setColor(COLOR.WHITE);
            }
        }

        blocks[ROW - 1][COL - 1] = b;
        return b;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.exit(1);
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    public static void main(String[] args) {
        new ChessFrame();
    }
}
