package book

/**
 * @author Maksim Dadzerkin (aka damal).
 * @since 22.5.16 0.40
 */
interface BookStatisticService {
    fun topX(link: String, x: Int): List<String>
}
