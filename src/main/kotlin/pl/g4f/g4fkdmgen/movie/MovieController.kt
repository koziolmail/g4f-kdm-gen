package pl.g4f.g4fkdmgen.movie

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movie")
class MovieController(
    private val movieServiceImpl: MovieServiceImpl
) {
    @GetMapping
    fun movies(name: String?, @AuthenticationPrincipal  principal: OAuth2User): List<MovieDto> {
        val distributorEmail = principal.attributes["email"] as String
        return movieServiceImpl.movies(name, distributorEmail)
    }
}