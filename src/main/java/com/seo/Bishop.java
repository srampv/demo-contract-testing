package com.seo;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Bishop implements Piece {


    public Set<String> getMoves(String position) {
        List<String> moves = new ArrayList<>();
        char c[] = position.toLowerCase().toCharArray();
        int val1 = ChessUtil.getIntValue(c[0] + "".trim());
        int val2 = Integer.parseInt(c[1] + "".trim());

        for (int i = val1, j = val2; i >= 1; i--, j++) {
            System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (j) + "".trim());
            moves.add(ChessUtil.getCharValue(i) + (j) + "".trim());
        }

        for (int i = val1, j = val2; i >= 1; i--, j--) {
            System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (j) + "".trim());
            moves.add(ChessUtil.getCharValue(i) + (j) + "".trim());
        }

        for (int i = val1, j = val2; j <= 8; i++, j++) {
            System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (j) + "".trim());
            moves.add(ChessUtil.getCharValue(i) + (j) + "".trim());
        }

        for (int i = val1, j = val2; j >= 1; i++, j--) {
            System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (j) + "".trim());
            moves.add(ChessUtil.getCharValue(i) + (j) + "".trim());
        }


        return moves.stream().filter(p -> p.trim().length() == 2 && !p.contains("0") && !p.contains("-1") && !p.contains("9")).collect(Collectors.toSet());
    }


}