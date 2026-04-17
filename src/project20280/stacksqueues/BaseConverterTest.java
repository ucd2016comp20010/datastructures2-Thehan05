package project20280.stacksqueues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseConverterTest {

    static String convertToBinary(long dec_num) {
        if (dec_num == 0) return "0";
        ArrayStack<Long> stack = new ArrayStack<>();
        while (dec_num > 0) {
            stack.push(dec_num % 2);
            dec_num /= 2;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
    }

    @Test
    void testConvertToBinary() {
        assertEquals("10111", convertToBinary(23));
        assertEquals(
                "111001000000101011000010011101010110110001100010000000000000",
                convertToBinary(1027010000000000000L)
        );
    }
}