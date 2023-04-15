package pl.g4f.g4fkdmgen.movie

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import pl.g4f.g4fkdmgen.distributor.DistributorRepository
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.isDirectory
import kotlin.io.path.name
import kotlin.streams.toList

@Service
@ConfigurationProperties("g4f.movie")
class MovieServiceImpl(
    private val distributorRepository: DistributorRepository
) {
    lateinit var path: Path
    fun movies(name: String?, distributorEmail: String): List<MovieDto> {
        val moviePath = distributorRepository.findByIdOrNull(distributorEmail)?.movieDirectory
        if (moviePath == null)
            return emptyList()

        val distributorPath = path.resolve(moviePath)

        return Files.list(distributorPath)
            .filter { it.isDirectory() }
            .filter { if (name != null) it.name.contains(name) else true }
            .map { MovieDto(it.fileName.name) }
            .toList()
    }
}