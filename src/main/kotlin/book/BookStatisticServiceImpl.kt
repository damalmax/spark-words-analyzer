package book

import org.apache.spark.api.java.JavaSparkContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import words.PopularWordsService
import java.net.URI

/**
 * @author Maksim Dadzerkin (aka damal).
 * @since 22.5.16 0.41
 */
@Service
open class BookStatisticServiceImpl
@Autowired constructor(var sc: JavaSparkContext,
                       var popularWordsService: PopularWordsService,
                       var downloadService: DownloadService) : BookStatisticService {
    override fun topX(link: String, x: Int): List<String> {
        val filepath: String
        if (link.startsWith("http")) {
            val file = downloadService.download(URI(link))
            filepath = file.absolutePath
        } else {
            filepath = link
        }

        val textFile = sc.textFile(filepath)

        return popularWordsService.topX(textFile, x);
    }
}
