package com.chess.engine.classic.player.ai;

import com.chess.engine.classic.board.Board;
import com.chess.engine.classic.pieces.Piece;
import com.chess.engine.classic.player.Player;
import com.chess.engine.classic.player.ai.KingSafetyAnalyzer.KingDistance;

public final class StandardBoardEvaluator
        implements BoardEvaluator {

    private final static int CHECK_MATE_BONUS = 10000;
    private final static int CHECK_BONUS = 20;
    private final static int CASTLE_BONUS = 25;

    @Override
    public int evaluate(final Board board,
                        final int depth) {
        return scorePlayer(board, board.whitePlayer(), depth) - scorePlayer(board, board.blackPlayer(), depth);
    }

    private static int scorePlayer(final Board board,
                                   final Player player,
                                   final int depth) {
        final int score = mobility(player) +
                          checkmate(player, depth) +
                          check(player) +
                          castling(player) +
                          pawnStructure(player) +
                          pieceValuation(player);
                          //rookStructure(board, player);
                          //+ kingSafety(player);
        return score;
    }

    private static int pieceValuation(final Player player) {
        int pieceValuationScore = 0;
        for (final Piece piece : player.getActivePieces()) {
            pieceValuationScore += piece.getPieceValue() + piece.locationBonus();
        }
        return pieceValuationScore;
    }

    private static int mobility(final Player player) {
        return player.getLegalMoves().size();
    }

    private static int checkmate(final Player player,
                                 final int depth) {
        return player.getOpponent().isInCheckMate() ? CHECK_MATE_BONUS  * depthBonus(depth): 0;
    }

    private static int check(final Player player) {
        return player.getOpponent().isInCheck() ? CHECK_BONUS : 0;
    }

    private static int depthBonus(final int depth) {
        return depth == 0 ? 1 : 100 * depth;
    }

    private static int castling(final Player player) {
        return player.isCastled() ? CASTLE_BONUS : 0;
    }

    private static int pawnStructure(final Player player) {
        return PawnStructureAnalyzer.get().pawnStructureScore(player);
    }

    private static int kingSafety(final Player player) {
        final KingDistance kingDistance = KingSafetyAnalyzer.get().calculateKingTropism(player);
        return ((kingDistance.getEnemyPiece().getPieceValue() / 100) * kingDistance.getDistance());
    }

    private static int rookStructure(final Board board, final Player player) {
        return RookStructureAnalyzer.get().rookStructureScore(board, player);
    }

}
