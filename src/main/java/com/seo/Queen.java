package com.seo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Queen implements Piece {


    public Set<String> getMoves(String position) {
        List<String> moves = new ArrayList<>();
        Rook rook = new Rook();
        Set<String> rookMoves = rook.getMoves(position);
        Bishop bishop = new Bishop();
        Set<String> bishopMoves = bishop.getMoves(position);
        rookMoves.addAll(bishopMoves);
        return rookMoves.stream().filter(p -> p.trim().length() == 2 && !p.contains("0") && !p.contains("-1") && !p.contains("9")).collect(Collectors.toSet());
    }


}