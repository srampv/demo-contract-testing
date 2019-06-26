package com.seo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Queen {


    public Set<String> getMoves(String position) {
        List<String> moves = new ArrayList<>();
        char c[] = position.toLowerCase().toCharArray();
        int val1 = ChessUtil.getIntValue(c[0] + "".trim());
        int val2 = Integer.parseInt(c[1] + "".trim());
        for (int i = 1; i < val1; i++, val2++) {
            System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
            moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
        }
        for (int i = val1; i <= 8; i++, val2++) {
            System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
            moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
        }

        for (int i = 1; i < val2; i++, val2--) {
            System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
            moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
        }
        for (int i = val2; i <= 8; i++, val2--) {
            System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
            moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
        }

        for (int i = 1; i < val1; i++) {
            System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
            moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
        }
        for (int i = val1; i <= 8; i++) {
            System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
            moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
        }

        for (int i = 1; i < val2; i++) {
            System.out.println("MOVE:-->" + ChessUtil.getCharValue(val1) + (i) + "".trim());
            moves.add(ChessUtil.getCharValue(val1) + (i) + "".trim());
        }
        for (int i = val2; i <= 8; i++) {
            System.out.println("MOVE:-->" + ChessUtil.getCharValue(val1) + (i) + "".trim());
            moves.add(ChessUtil.getCharValue(val1) + (i) + "".trim());
        }


        return moves.stream().filter(p -> p.trim().length() == 2 && !p.contains("0") && !p.contains("-1") && !p.contains("9")).collect(Collectors.toSet());
    }


}