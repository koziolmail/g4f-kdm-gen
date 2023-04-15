package pl.g4f.g4fkdmgen.distributor

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "distributor")
class Distributor (
    @Id
    var email:String,

    @Column(name = "movie_directory")
    var movieDirectory: String
)