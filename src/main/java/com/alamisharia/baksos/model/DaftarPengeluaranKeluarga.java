package com.alamisharia.baksos.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "DaftarPengeluaranKeluarga")
public class DaftarPengeluaranKeluarga implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Date tanggal;

  private String judulPengeluaran;

  private Integer nilaiDalamRupiah;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getTanggal() {
    return tanggal;
  }

  public void setTanggal(Date tanggal) {
    this.tanggal = tanggal;
  }

  public String getJudulPengeluaran() {
    return judulPengeluaran;
  }

  public void setJudulPengeluaran(String judulPengeluaran) {
    this.judulPengeluaran = judulPengeluaran;
  }

  public Integer getNilaiDalamRupiah() {
    return nilaiDalamRupiah;
  }

  public void setNilaiDalamRupiah(Integer nilaiDalamRupiah) {
    this.nilaiDalamRupiah = nilaiDalamRupiah;
  }

  public DaftarPengeluaranKeluarga() {
  }

  public DaftarPengeluaranKeluarga(Long id, Date tanggal, String judulPengeluaran, Integer nilaiDalamRupiah) {
    this.id = id;
    this.tanggal = tanggal;
    this.judulPengeluaran = judulPengeluaran;
    this.nilaiDalamRupiah = nilaiDalamRupiah;
  }
}
