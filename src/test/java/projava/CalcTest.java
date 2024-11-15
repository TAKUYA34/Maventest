package projava;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ALL")
class CalcTest {
    @Test
    @DisplayName("add()")
      void 正の数同士の計算() {
        assertEquals(6, new Calc().add(2, 4), "2 + 4 = 8");
        // assertEquals(期待値, 実際の値()[テストを表すメッセージ])

        // 例外 NumberFormatException が投げられることを期待するテスト
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("￥10,000"), "￥や,が入っているのでパースできない");

        // 例外が投げられないことを期待するテスト
        assertDoesNotThrow(() -> new Calc().add(-100, 10), "負の値を渡しても例外はでない");

        // 複数のアサーションメソッドを必ず実行するテスト
        assertAll(() -> assertEquals(4, new Calc().add(2, 2), "2 + 2 = 4"),
                () -> assertEquals(6, new Calc().add(2, 4), "2 + 4 = 6")
        );
    }
}