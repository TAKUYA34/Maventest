package projava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {
    @Test
      void add() {
        assertEquals(6, new Calc().add(2, 4), "2 + 4 = 8");
        // assertEquals(期待値, 実際の値()[テストを表すメッセージ])
    }
}