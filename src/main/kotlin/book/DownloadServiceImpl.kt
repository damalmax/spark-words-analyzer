package book

import org.apache.commons.io.FileUtils
import org.jsoup.Jsoup
import org.springframework.stereotype.Service
import java.io.File
import java.net.URI
import java.nio.file.Files

/**
 * @author Maksim Dadzerkin (aka damal).
 * @since 22.5.16 1.14
 */
@Service
class DownloadServiceImpl : DownloadService {
    override fun download(link: URI): File {
        val tempFile = Files.createTempFile(null, null).toFile()

        val text = Jsoup.connect(link.toString()).get().body().text();
        FileUtils.write(tempFile, text)
        return tempFile
    }
}
