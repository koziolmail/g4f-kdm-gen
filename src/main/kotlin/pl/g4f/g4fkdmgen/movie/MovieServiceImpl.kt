package pl.g4f.g4fkdmgen.movie

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.isDirectory
import kotlin.io.path.name

@Service
@ConfigurationProperties("g4f.movie")
class MovieServiceImpl {
    lateinit var path: Path
    fun movies(name: String?): List<MovieDto> =
        Files.list(path)
            .filter { it.isDirectory() }
            .filter { if (name != null) it.name.contains(name) else true }
            .map { MovieDto(it.fileName.name) }
            .toList()
}