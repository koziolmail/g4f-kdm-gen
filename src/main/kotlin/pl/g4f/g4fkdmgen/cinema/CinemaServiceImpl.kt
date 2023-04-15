package pl.g4f.g4fkdmgen.cinema

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.isDirectory
import kotlin.io.path.name
import kotlin.streams.toList

@Service
@ConfigurationProperties("g4f.cinema")
class CinemaServiceImpl {
    lateinit var path: Path
    fun cinemas(name: String?): List<CinemaDto> =
        Files.list(path)
            .filter { it.isDirectory() }
            .filter { if (name != null) it.name.contains(name) else true }
            .map { CinemaDto(it.fileName.name) }
            .toList()
}