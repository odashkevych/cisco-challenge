package cisco.java.challenge.literals;

import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertTrue;

public class RegexpWordCounterTest {

    private WordCounter wordCounter = new RegexpWordCounter();

    @Test
    public void testBlankText() {
        String text = "             \n  \t \r\n";

        Map<String, Integer> result = wordCounter.count(text);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testNullText() {
        Map<String, Integer> result = wordCounter.count(null);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testSmallTextWithSeparatorsAndCommaBetweenWords() {
        String text = "I felt happy because I saw the others were happy and because I knew I should feel happy, but I wasn’t really happy.";

        Map<String, Integer> result = wordCounter.count(text);

        assertThat(result.size()).isEqualTo(15);
        assertThat(result.get("i")).isEqualTo(5);
        assertThat(result.get("happy")).isEqualTo(4);
        assertThat(result.get("because")).isEqualTo(2);
        assertThat(result.get("really")).isEqualTo(1);
        assertThat(result.get("wasn’t")).isEqualTo(1);
        assertThat(result.get("should")).isEqualTo(1);
        assertThat(result.get("others")).isEqualTo(1);
        assertThat(result.get("felt")).isEqualTo(1);
        assertThat(result.get("knew")).isEqualTo(1);
        assertThat(result.get("feel")).isEqualTo(1);
        assertThat(result.get("saw")).isEqualTo(1);
        assertThat(result.get("the")).isEqualTo(1);
        assertThat(result.get("were")).isEqualTo(1);
        assertThat(result.get("and")).isEqualTo(1);
        assertThat(result.get("but")).isEqualTo(1);

    }
}
