package pl.g4f.g4fkdmgen.cinema

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cinema")
class CinemaController(
    private val cinemaServiceImpl: CinemaServiceImpl
) {
    @GetMapping
    fun cinemas(name: String?): List<CinemaDto> {
        return cinemaServiceImpl.cinemas(name)
    }
}