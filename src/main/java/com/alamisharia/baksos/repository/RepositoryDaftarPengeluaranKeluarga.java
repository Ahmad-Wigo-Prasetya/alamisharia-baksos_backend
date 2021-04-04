package com.alamisharia.baksos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.alamisharia.baksos.model.DaftarPengeluaranKeluarga;

@Repository
public interface RepositoryDaftarPengeluaranKeluarga extends JpaRepository<DaftarPengeluaranKeluarga, Long> {
    public List<DaftarPengeluaranKeluarga> findAllByOrderByIdAsc();
}