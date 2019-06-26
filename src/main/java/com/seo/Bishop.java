package com.seo;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Bishop {


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


        return moves.stream().filter(p -> p.trim().length() == 2 && !p.contains("0") && !p.contains("-1") && !p.contains("9")).collect(Collectors.toSet());
    }


}