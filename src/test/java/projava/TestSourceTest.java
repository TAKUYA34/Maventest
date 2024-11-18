package projava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
class TestSourceTest {

    @Test
    void 近代オリンピック開始以前() throws IllegalAccessException {
        assertFalse(new TestSource().isSummerOlympicYear(1888), "1888年");
        assertFalse(new TestSource().isSummerOlympicYear(1892), "1892年");
        assertFalse(new TestSource().isSummerOlympicYear(1895), "1895年");
        // 近代オリンピック初回開催
        assertTrue(new TestSource().isSummerOlympicYear(1896), "1896年");
    }

    @Test
    void 四年周期の一般的な開催年() throws IllegalAccessException {
        int[] years = {1900, 1920, 1964, 1936, 2000};
        for (int year : years) {
            assertTrue(new TestSource().isSummerOlympicYear(year), year + "年");
        }
    }
    @Test
    void 四年周期から外れる非開催年() throws IllegalAccessException {
        int[] years = {1905, 1907, 1925, 1967, 2001};
        for (int year : years) {
            assertFalse(new TestSource().isSummerOlympicYear(year), year + "年");
        }
    }

    @Test
    void 戦争またはパンデミックで中止となった年() throws IllegalAccessException {
        int[] years = {1916, 1940, 1944, 2020};
        for (int year : years) {
            assertFalse(new TestSource().isSummerOlympicYear(year), year + "年");
        }
    }
    @Test
    void 四年開催ではない例外的な開催年() throws IllegalAccessException {
        // 新型コロナウイルスにより延期開催
        assertTrue(new TestSource().isSummerOlympicYear(2021), "2021年");
    }

    @Test
    void 境界値上限() throws IllegalAccessException {
        assertDoesNotThrow(() -> new TestSource().isSummerOlympicYear(2031));
        assertDoesNotThrow(() -> new TestSource().isSummerOlympicYear(2032));
        // 開催が決定している2032年よりも後の年は例外発生
        assertThrows(IllegalAccessException.class,
                () -> new TestSource().isSummerOlympicYear(2033), "2033年");
        assertThrows(IllegalAccessException.class,
                () -> new TestSource().isSummerOlympicYear(2054), "2054年");
    }
}