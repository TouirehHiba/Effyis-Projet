package com.example.demo.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import com.example.demo.domain.enums.Contrat;
import com.example.demo.domain.enums.Disponibilite;
import com.example.demo.domain.enums.NiveauEtude;
import com.example.demo.domain.enums.ProfilCandidat;
import com.example.demo.domain.enums.Source;
import com.example.demo.domain.FileData;





public interface FileDataRepo extends JpaRepository<FileData,Long> {
    Optional<FileData> findByName(String fileName);

    @Query("SELECT f FROM FileData f " +
            "WHERE (:contrat IS NULL OR f.contrat = :contrat) " +
            "AND (:niveauEtude IS NULL OR f.niveau = :niveauEtude) " +
            "AND (:disponibilite IS NULL OR f.disponibilite = :disponibilite) " +
            "AND (:profil IS NULL OR f.profil = :profil) " +
            "AND (:source IS NULL OR f.source = :source)")
    List<FileData> findByCriteria(
            @Param("contrat") Contrat contrat,
            @Param("niveauEtude") NiveauEtude niveauEtude,
            @Param("disponibilite") Disponibilite disponibilite,
            @Param("profil") ProfilCandidat profil,
            @Param("source") Source source
    );
}
