import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
class TorreDeHanoiTest {

    @Test
    void test1() {
        StringBuilder iterativoMovimentos = new StringBuilder();
        StringBuilder recursivoMovimentos = new StringBuilder();

        TorreDeHanoi.moveTorreIterativo(3, 'A', 'C', 'B', iterativoMovimentos);
        TorreDeHanoi.moveTorreRecursivo(3, 'A', 'C', 'B', recursivoMovimentos);

        assertEquals(iterativoMovimentos.toString(), recursivoMovimentos.toString());
    }
}

