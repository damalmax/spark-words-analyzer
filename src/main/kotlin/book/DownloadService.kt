package book

import java.io.File
import java.net.URI

/**
 * @author Maksim Dadzerkin (aka damal).
 * @since 22.5.16 1.05
 */
interface DownloadService {
    /**
     * Downloads the remote file by link and store it as a temporary file. Link to the tmp copy will be returned
     * as a result.
     *
     * @param link link to the remote file.
     * @return tmp copy of the remote file.
     */
    fun download(link: URI): File
}
