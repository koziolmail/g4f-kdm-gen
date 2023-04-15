package pl.g4f.g4fkdmgen.distributor

import org.springframework.data.jpa.repository.JpaRepository

interface DistributorRepository: JpaRepository<Distributor, String> {
}