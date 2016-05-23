package words

import config.JavaAppConfig
import org.apache.spark.api.java.JavaSparkContext
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import kotlin.properties.Delegates

/**
 * @author Maksim Dadzerkin (aka damal).
 * @since 22.5.16 0.10
 */
@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(classes = arrayOf(JavaAppConfig::class))
class PopularWordsServiceImplTest {
    @set: Autowired
    var sc: JavaSparkContext by Delegates.notNull()
    @set: Autowired
    var service: PopularWordsService by Delegates.notNull()

    @Test
    fun testTopX() {
        val rdd = sc.parallelize(listOf("java scala kotlin java kotlin groovy kotlin"))
        val top1 = service.topX(rdd, 1)
        assertEquals("kotlin", top1.get(0))
    }
}
