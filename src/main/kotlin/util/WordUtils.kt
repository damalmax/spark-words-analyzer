package util

import java.util.*
import java.util.regex.Pattern

/**
 * @author Maksim Dadzerkin (aka damal).
 * @since 21.5.16 23.43
 */
fun getWords(line: String): List<String> {
    val pattern = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS)
    val matcher = pattern.matcher(line)
    val result = ArrayList<String>()
    while (matcher.find()) {
        result.add(matcher.group())
    }
    return result
}
