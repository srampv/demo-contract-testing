package com.seo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class King implements Piece {
    /***
     * TODO: Enpatient has to be CODED
     * @param position
     * @return
     */
    @Override
    public Set<String> getMoves(String position) {
        List<String> moves = new ArrayList<>();
        char c[] = position.toLowerCase().toCharArray();
        int val1 = ChessUtil.getIntValue(c[0] + "".trim());
        int val2 = Integer.parseInt(c[1] + "".trim());
        System.out.println("MOVE:-->" + ChessUtil.getCharValue(val1) + (val2) + "".trim());
        System.out.println("MOVE:-->" + ChessUtil.getCharValue(val1) + (val2 - 1) + "".trim());
        System.out.println("MOVE:-->" + ChessUtil.getCharValue(val1) + (val2 + 1) + "".trim());

        System.out.println("MOVE:-->" + ChessUtil.getCharValue(val1 + 1) + (val2) + "".trim());
        System.out.println("MOVE:-->" + ChessUtil.getCharValue(val1 + 1) + (val2 - 1) + "".trim());
        System.out.println("MOVE:-->" + ChessUtil.getCharValue(val1 + 1) + (val2 + 1) + "".trim());

        System.out.println("MOVE:-->" + ChessUtil.getCharValue(val1 - 1) + (val2) + "".trim());
        System.out.println("MOVE:-->" + ChessUtil.getCharValue(val1 - 1) + (val2 - 1) + "".trim());
        System.out.println("MOVE:-->" + ChessUtil.getCharValue(val1 - 1) + (val2 + 1) + "".trim());
        moves.add(ChessUtil.getCharValue(val1) + (val2) + "".trim());
        moves.add(ChessUtil.getCharValue(val1) + (val2 - 1) + "".trim());
        moves.add(ChessUtil.getCharValue(val1) + (val2 + 1) + "".trim());

        moves.add(ChessUtil.getCharValue(val1 + 1) + (val2) + "".trim());
        moves.add(ChessUtil.getCharValue(val1 + 1) + (val2 - 1) + "".trim());
        moves.add(ChessUtil.getCharValue(val1 + 1) + (val2 + 1) + "".trim());

        moves.add(ChessUtil.getCharValue(val1 - 1) + (val2) + "".trim());
        moves.add(ChessUtil.getCharValue(val1 - 1) + (val2 - 1) + "".trim());
        moves.add(ChessUtil.getCharValue(val1 - 1) + (val2 + 1) + "".trim());

        return moves.stream().filter(p -> p.trim().length() == 2 && !p.contains("0") && !p.contains("-1") && !p.contains("9")).collect(Collectors.toSet());
    }
}
