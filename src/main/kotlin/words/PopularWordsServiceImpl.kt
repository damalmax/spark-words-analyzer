package words

import config.UserConfig
import org.apache.commons.lang.math.NumberUtils
import org.apache.spark.api.java.JavaRDD
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import scala.Tuple2
import util.getWords

/**
 * @author Maksim Dadzerkin (aka damal).
 * @since 21.5.16 23.18
 */
@Service
open class PopularWordsServiceImpl @Autowired constructor(val userConfig: UserConfig) : PopularWordsService {

    override fun topX(lines: JavaRDD<String>, x: Int): List<String> {
        return lines.map({ it.toLowerCase() })
                .flatMap({ getWords(it) })
                // remove numbers from processing
                .filter { !NumberUtils.isNumber(it) }
                .filter { !userConfig.russianStopWords.contains(it) }
                .mapToPair({ Tuple2<String, Int>(it, 1) })
                .reduceByKey { a, b -> a + b }
                .mapToPair { it.swap() }
                .sortByKey(false)
                .map({ it._2 })
                .take(x)
    }
}
