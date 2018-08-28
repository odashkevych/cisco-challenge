package cisco.java.challenge.literals;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpWordCounter implements WordCounter {

    private Pattern wordRegexPattern = Pattern.compile("([0-9]*[a-z]+([-'’](?=[a-z]))?((?<=[-'’])[a-z]+)*)");

    @Override
    public Map<String, Integer> count(String text) {
        Map<String, Integer> wordsCountMap = new HashMap<>();

        if (StringUtils.isBlank(text)) {
            return wordsCountMap;
        }
        Matcher wordMatcher = wordRegexPattern.matcher(text.toLowerCase());

        while (wordMatcher.find()) {
            String word = wordMatcher.group();

            Integer wordCount = wordsCountMap.putIfAbsent(word, 1);
            if (wordCount != null) {
                wordsCountMap.put(word, ++wordCount);
            }
        }
        return wordsCountMap;
    }
}
