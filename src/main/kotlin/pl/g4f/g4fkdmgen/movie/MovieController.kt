package pl.g4f.g4fkdmgen.movie

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movie")
class MovieController(
    private val movieServiceImpl: MovieServiceImpl
) {
    @GetMapping
    fun movies(name: String?): List<MovieDto> {
        return movieServiceImpl.movies(name)
    }
}