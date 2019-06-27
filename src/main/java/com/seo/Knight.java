package com.seo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Knight implements Piece {


    public Set<String> getMoves(String position) {
        List<String> moves = new ArrayList<>();
        char c[] = position.toLowerCase().toCharArray();
        int val1 = ChessUtil.getIntValue(c[0] + "".trim());
        int val2 = Integer.parseInt(c[1] + "".trim());
        System.out.println("MOVE1:-->" + ChessUtil.getCharValue(val1 + 1) + (val2 + 2) + "".trim());
        System.out.println("MOVE2:-->" + ChessUtil.getCharValue(val1 - 1) + (val2 + 2) + "".trim());
        System.out.println("MOVE3:-->" + ChessUtil.getCharValue(val1 + 1) + (val2 - 2) + "".trim());
        System.out.println("MOVE4:-->" + ChessUtil.getCharValue(val1 - 1) + (val2 - 2) + "".trim());

        System.out.println("MOVE5:-->" + ChessUtil.getCharValue(val1 + 2) + (val2 + 1) + "".trim());
        System.out.println("MOVE6:-->" + ChessUtil.getCharValue(val1 - 2) + (val2 + 1) + "".trim());
        System.out.println("MOVE7:-->" + ChessUtil.getCharValue(val1 + 2) + (val2 - 1) + "".trim());
        System.out.println("MOVE8:-->" + ChessUtil.getCharValue(val1 - 2) + (val2 - 1) + "".trim());

        moves.add(ChessUtil.getCharValue(val1 + 1) + (val2 + 2));
        moves.add(ChessUtil.getCharValue(val1 - 1) + (val2 + 2));
        moves.add(ChessUtil.getCharValue(val1 + 1) + (val2 - 2));
        moves.add(ChessUtil.getCharValue(val1 - 1) + (val2 - 2));

        moves.add(ChessUtil.getCharValue(val1 + 2) + (val2 + 1));
        moves.add(ChessUtil.getCharValue(val1 - 2) + (val2 + 1));
        moves.add(ChessUtil.getCharValue(val1 + 2) + (val2 - 1));
        moves.add(ChessUtil.getCharValue(val1 - 2) + (val2 - 1));
        moves.add(position);

        return moves.stream().filter(p -> p.trim().length() == 2 && !p.contains("0") && !p.contains("-1") && !p.contains("9")).collect(Collectors.toSet());
    }


}
