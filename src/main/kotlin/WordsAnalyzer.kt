import book.BookStatisticService
import config.JavaAppConfig
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * @author Maksim Dadzerkin (aka damal).
 * @since 21.5.16 22.13
 */
fun main(args: Array<String>) {
    val ctx = AnnotationConfigApplicationContext(JavaAppConfig::class.java)
    val bookStatisticService = ctx.getBean(BookStatisticService::class.java)

//    println(bookStatisticService.topX("<Place link here>", 100))
}
