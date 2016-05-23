package config;

import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Set;

/**
 * @author Maksim Dadzerkin (aka damal).
 * @since 22.5.16 2.26
 */
@Component
public class UserConfig implements Serializable {
    public Set<String> russianStopWords;

    @Value("${russian.stopwords}")
    private void setRussianStopWords(String russianStopWords) {
        try {
            String stopWordsString = new String(russianStopWords.getBytes("ISO-8859-1"), "UTF-8");
            this.russianStopWords = Sets.newHashSet(Splitter.on(",").split(stopWordsString));
        } catch (UnsupportedEncodingException e) {
            this.russianStopWords = Collections.emptySet();
        }
    }
}
