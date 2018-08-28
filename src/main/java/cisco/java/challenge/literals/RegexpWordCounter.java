package cisco.java.challenge.literals;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpWordCounter implements WordCounter {

    private Pattern wordRegexPattern = Pattern.compile("(\\w+-?'?’?\\w*)");

    @Override
    public Map<String, Integer> count(String text) {
        if (StringUtils.isBlank(text)) {
            return Collections.emptyMap();
        }

        text = text.toLowerCase();

        Map<String, Integer> wordsCountMap = new HashMap<>();
        Matcher wordMatcher = wordRegexPattern.matcher(text);
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
