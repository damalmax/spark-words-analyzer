package words

import org.apache.spark.api.java.JavaRDD
import java.io.Serializable

/**
 * @author Maksim Dadzerkin (aka damal).
 * @since 21.5.16 23.08
 */
interface PopularWordsService : Serializable {
    fun topX(lines: JavaRDD<String>, x: Int): List<String>
}
