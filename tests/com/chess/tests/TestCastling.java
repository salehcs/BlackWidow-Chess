package com.chess.tests;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import com.chess.engine.classic.player.ai.StockAlphaBeta;
import org.junit.Test;

import com.chess.engine.classic.board.Board;
import com.chess.engine.classic.board.BoardUtils;
import com.chess.engine.classic.board.Move;
import com.chess.engine.classic.board.MoveTransition;

public class TestCastling {

    @Test
    public void testWhiteKingSideCastle() {

        final Board board = Board.createStandardBoard();
        final MoveTransition t1 = board.currentPlayer()
                .makeMove(Move.MoveFactory.createMove(board, BoardUtils.getCoordinateAtPosition("e2"),
                        BoardUtils.getCoordinateAtPosition("e4")));

        assertTrue(t1.getMoveStatus().isDone());

        final MoveTransition t2 = t1.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t1.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("e7"),
                        BoardUtils.getCoordinateAtPosition("e5")));

        assertTrue(t2.getMoveStatus().isDone());

        final MoveTransition t3 = t2.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t2.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("g1"),
                        BoardUtils.getCoordinateAtPosition("f3")));

        assertTrue(t3.getMoveStatus().isDone());

        final MoveTransition t4 = t3.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t3.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("d7"),
                        BoardUtils.getCoordinateAtPosition("d6")));

        assertTrue(t4.getMoveStatus().isDone());

        final MoveTransition t5 = t4.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t4.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("f1"),
                        BoardUtils.getCoordinateAtPosition("e2")));

        assertTrue(t5.getMoveStatus().isDone());

        final MoveTransition t6 = t5.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t5.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("d6"),
                        BoardUtils.getCoordinateAtPosition("d5")));

        assertTrue(t6.getMoveStatus().isDone());

        final Move wm1 = Move.MoveFactory
                .createMove(t6.getTransitionBoard(), BoardUtils.getCoordinateAtPosition(
                        "e1"), BoardUtils.getCoordinateAtPosition("g1"));

        assertTrue(t6.getTransitionBoard().currentPlayer().getLegalMoves().contains(wm1));

        final MoveTransition t7 = t6.getTransitionBoard().currentPlayer().makeMove(wm1);

        assertTrue(t7.getMoveStatus().isDone());
        assertTrue(t7.getTransitionBoard().whitePlayer().isCastled());

    }

    @Test
    public void testWhiteQueenSideCastle() {

        final Board board = Board.createStandardBoard();
        final MoveTransition t1 = board.currentPlayer()
                .makeMove(Move.MoveFactory.createMove(board, BoardUtils.getCoordinateAtPosition("e2"),
                        BoardUtils.getCoordinateAtPosition("e4")));

        assertTrue(t1.getMoveStatus().isDone());

        final MoveTransition t2 = t1.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t1.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("e7"),
                        BoardUtils.getCoordinateAtPosition("e5")));

        assertTrue(t2.getMoveStatus().isDone());

        final MoveTransition t3 = t2.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t2.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("d2"),
                        BoardUtils.getCoordinateAtPosition("d3")));

        assertTrue(t3.getMoveStatus().isDone());

        final MoveTransition t4 = t3.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t3.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("d7"),
                        BoardUtils.getCoordinateAtPosition("d6")));

        assertTrue(t4.getMoveStatus().isDone());

        final MoveTransition t5 = t4.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t4.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("c1"),
                        BoardUtils.getCoordinateAtPosition("d2")));

        assertTrue(t5.getMoveStatus().isDone());

        final MoveTransition t6 = t5.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t5.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("d6"),
                        BoardUtils.getCoordinateAtPosition("d5")));

        assertTrue(t6.getMoveStatus().isDone());

        final MoveTransition t7 = t6.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t6.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("d1"),
                        BoardUtils.getCoordinateAtPosition("e2")));

        assertTrue(t7.getMoveStatus().isDone());

        final MoveTransition t8 = t7.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t7.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("h7"),
                        BoardUtils.getCoordinateAtPosition("h6")));

        assertTrue(t8.getMoveStatus().isDone());

        final MoveTransition t9 = t8.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t8.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("b1"),
                        BoardUtils.getCoordinateAtPosition("c3")));

        assertTrue(t9.getMoveStatus().isDone());

        final MoveTransition t10 = t9.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t9.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("h6"),
                        BoardUtils.getCoordinateAtPosition("h5")));

        assertTrue(t10.getMoveStatus().isDone());

        final Move wm1 = Move.MoveFactory
                .createMove(t10.getTransitionBoard(), BoardUtils.getCoordinateAtPosition(
                        "e1"), BoardUtils.getCoordinateAtPosition("c1"));

        assertTrue(t10.getTransitionBoard().currentPlayer().getLegalMoves().contains(wm1));

        final MoveTransition t11 = t10.getTransitionBoard().currentPlayer().makeMove(wm1);

        assertTrue(t11.getMoveStatus().isDone());
        assertTrue(t11.getTransitionBoard().whitePlayer().isCastled());
    }

    @Test
    public void testBlackKingSideCastle() {
        final Board board = Board.createStandardBoard();

        final MoveTransition t1 = board.currentPlayer()
                .makeMove(Move.MoveFactory.createMove(board, BoardUtils.getCoordinateAtPosition("e2"),
                        BoardUtils.getCoordinateAtPosition("e4")));

        assertTrue(t1.getMoveStatus().isDone());

        final MoveTransition t2 = t1.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t1.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("e7"),
                        BoardUtils.getCoordinateAtPosition("e5")));

        assertTrue(t2.getMoveStatus().isDone());

        final MoveTransition t3 = t2.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t2.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("d2"),
                        BoardUtils.getCoordinateAtPosition("d3")));

        assertTrue(t3.getMoveStatus().isDone());

        final MoveTransition t4 = t3.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t3.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("g8"),
                        BoardUtils.getCoordinateAtPosition("f6")));

        assertTrue(t4.getMoveStatus().isDone());

        final MoveTransition t5 = t4.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t4.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("d3"),
                        BoardUtils.getCoordinateAtPosition("d4")));

        assertTrue(t5.getMoveStatus().isDone());

        final MoveTransition t6 = t5.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t5.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("f8"),
                        BoardUtils.getCoordinateAtPosition("e7")));

        assertTrue(t6.getMoveStatus().isDone());

        final MoveTransition t7 = t6.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t6.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("d4"),
                        BoardUtils.getCoordinateAtPosition("d5")));

        assertTrue(t7.getMoveStatus().isDone());

        final Move wm1 = Move.MoveFactory
                .createMove(t7.getTransitionBoard(), BoardUtils.getCoordinateAtPosition(
                        "e8"), BoardUtils.getCoordinateAtPosition("g8"));

        assertTrue(t7.getTransitionBoard().currentPlayer().getLegalMoves().contains(wm1));

        final MoveTransition t8 = t7.getTransitionBoard().currentPlayer().makeMove(wm1);

        assertTrue(t8.getMoveStatus().isDone());

        assertTrue(t8.getTransitionBoard().blackPlayer().isCastled());

    }

    @Test
    public void testBlackQueenSideCastle() {

        final Board board = Board.createStandardBoard();

        final MoveTransition t1 = board.currentPlayer()
                .makeMove(Move.MoveFactory.createMove(board, BoardUtils.getCoordinateAtPosition("e2"),
                        BoardUtils.getCoordinateAtPosition("e4")));

        assertTrue(t1.getMoveStatus().isDone());

        final MoveTransition t2 = t1.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t1.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("e7"),
                        BoardUtils.getCoordinateAtPosition("e5")));

        assertTrue(t2.getMoveStatus().isDone());

        final MoveTransition t3 = t2.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t2.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("d2"),
                        BoardUtils.getCoordinateAtPosition("d3")));

        assertTrue(t3.getMoveStatus().isDone());

        final MoveTransition t4 = t3.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t3.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("d8"),
                        BoardUtils.getCoordinateAtPosition("e7")));

        assertTrue(t4.getMoveStatus().isDone());

        final MoveTransition t5 = t4.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t4.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("b1"),
                        BoardUtils.getCoordinateAtPosition("c3")));

        assertTrue(t5.getMoveStatus().isDone());

        final MoveTransition t6 = t5.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t5.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("b8"),
                        BoardUtils.getCoordinateAtPosition("c6")));

        assertTrue(t6.getMoveStatus().isDone());

        final MoveTransition t7 = t6.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t6.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("c1"),
                        BoardUtils.getCoordinateAtPosition("d2")));

        assertTrue(t7.getMoveStatus().isDone());

        final MoveTransition t8 = t7.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t7.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("d7"),
                        BoardUtils.getCoordinateAtPosition("d6")));

        assertTrue(t8.getMoveStatus().isDone());

        final MoveTransition t9 = t8.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t8.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("f1"),
                        BoardUtils.getCoordinateAtPosition("e2")));

        assertTrue(t9.getMoveStatus().isDone());

        final MoveTransition t10 = t9.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t9.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("c8"),
                        BoardUtils.getCoordinateAtPosition("d7")));

        assertTrue(t10.getMoveStatus().isDone());

        final MoveTransition t11 = t10.getTransitionBoard()
                .currentPlayer()
                .makeMove(
                        Move.MoveFactory.createMove(t10.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("g1"),
                                BoardUtils.getCoordinateAtPosition("f3")));

        assertTrue(t11.getMoveStatus().isDone());

        final Move wm1 = Move.MoveFactory
                .createMove(t11.getTransitionBoard(), BoardUtils.getCoordinateAtPosition(
                        "e8"), BoardUtils.getCoordinateAtPosition("c8"));

        assertTrue(t11.getTransitionBoard().currentPlayer().getLegalMoves().contains(wm1));

        final MoveTransition t12 = t11.getTransitionBoard().currentPlayer().makeMove(wm1);

        assertTrue(t12.getMoveStatus().isDone());

        assertTrue(t12.getTransitionBoard().blackPlayer().isCastled());
    }

    @Test
    public void testCastleBugOne() {

        final Board board = Board.createStandardBoard();

        final MoveTransition t1 = board.currentPlayer()
                .makeMove(Move.MoveFactory.createMove(board, BoardUtils.getCoordinateAtPosition("e2"),
                        BoardUtils.getCoordinateAtPosition("e4")));

        assertTrue(t1.getMoveStatus().isDone());

        final MoveTransition t2 = t1.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t1.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("d7"),
                        BoardUtils.getCoordinateAtPosition("d5")));

        assertTrue(t2.getMoveStatus().isDone());

        final MoveTransition t3 = t2.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t2.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("e4"),
                        BoardUtils.getCoordinateAtPosition("e5")));

        assertTrue(t3.getMoveStatus().isDone());

        final MoveTransition t4 = t3.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t3.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("c8"),
                        BoardUtils.getCoordinateAtPosition("f5")));

        assertTrue(t4.getMoveStatus().isDone());

        final MoveTransition t5 = t4.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t4.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("f1"),
                        BoardUtils.getCoordinateAtPosition("d3")));

        assertTrue(t5.getMoveStatus().isDone());

        final MoveTransition t6 = t5.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t5.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("f5"),
                        BoardUtils.getCoordinateAtPosition("d3")));

        assertTrue(t6.getMoveStatus().isDone());

        final MoveTransition t7 = t6.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t6.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("c2"),
                        BoardUtils.getCoordinateAtPosition("d3")));

        assertTrue(t7.getMoveStatus().isDone());

        final MoveTransition t8 = t7.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t7.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("e7"),
                        BoardUtils.getCoordinateAtPosition("e6")));

        assertTrue(t8.getMoveStatus().isDone());

        final MoveTransition t9 = t8.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t8.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("d1"),
                        BoardUtils.getCoordinateAtPosition("a4")));

        assertTrue(t9.getMoveStatus().isDone());

        final MoveTransition t10 = t9.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t9.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("d8"),
                        BoardUtils.getCoordinateAtPosition("d7")));

        assertTrue(t10.getMoveStatus().isDone());

        final MoveTransition t11 = t10.getTransitionBoard()
                .currentPlayer()
                .makeMove(
                        Move.MoveFactory.createMove(t10.getTransitionBoard(), BoardUtils.getCoordinateAtPosition("b1"),
                                BoardUtils.getCoordinateAtPosition("c3")));

        assertTrue(t11.getMoveStatus().isDone());

        t11.getTransitionBoard().currentPlayer().setMoveStrategy(new StockAlphaBeta());

        t11.getTransitionBoard().currentPlayer().getMoveStrategy().execute(t11.getTransitionBoard(), 4);


    }

//    @Test
//    public void testCastleUndoBug() {
//        final Board board = Board.createStandardBoard();
//
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("e2"), Board.getCoordinateAtPosition("e4"))));
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("e7"), Board.getCoordinateAtPosition("e6"))));
//
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("d2"), Board.getCoordinateAtPosition("d4"))));
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("b8"), Board.getCoordinateAtPosition("c6"))));
//
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("g1"), Board.getCoordinateAtPosition("f3"))));
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("d7"), Board.getCoordinateAtPosition("d5"))));
//
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("e4"), Board.getCoordinateAtPosition("e5"))));
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("f7"), Board.getCoordinateAtPosition("f5"))));
//
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("b1"), Board.getCoordinateAtPosition("c3"))));
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("f8"), Board.getCoordinateAtPosition("b4"))));
//
//        //
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("c1"), Board.getCoordinateAtPosition("d2"))));
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("b4"), Board.getCoordinateAtPosition("c3"))));
//
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("d2"), Board.getCoordinateAtPosition("c3"))));
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("g8"), Board.getCoordinateAtPosition("e7"))));
//
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("f3"), Board.getCoordinateAtPosition("g5"))));
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("e8"),
//                        Board.getCoordinateAtPosition("g8"))));  //castle
//
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("d1"), Board.getCoordinateAtPosition("h5"))));
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("h7"), Board.getCoordinateAtPosition("h6"))));
//
//        assertEquals(MoveStatus.DONE, Player.makeMove(board, Move.MoveFactory
//                .createMove(board, Board.getCoordinateAtPosition("g5"), Board.getCoordinateAtPosition("h3"))));
//
//        final Player currentPlayer = board.currentPlayer();
//        currentPlayer.setMoveStrategy(new AlphaBeta());
//        board.currentPlayer().getMoveStrategy().execute(board, 4);
//
//    }
}
