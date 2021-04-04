package com.alamisharia.baksos.controller;

import java.util.List;

import com.alamisharia.baksos.model.DaftarPengeluaranKeluarga;
import com.alamisharia.baksos.repository.RepositoryDaftarPengeluaranKeluarga;
import com.alamisharia.baksos.rest.BaseResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/api")
public class ControllerDaftarPengeluaranKeluarga {

  @Autowired
  RepositoryDaftarPengeluaranKeluarga repositoryDaftarPengeluaranKeluarga;

  @CrossOrigin(origins = "*")
  @RequestMapping(method = RequestMethod.GET, path = "/getAllDaftarPengeluaranKeluarga")
  @ResponseBody
  public BaseResponse<List<DaftarPengeluaranKeluarga>> getAllDaftarPengeluaranKeluarga() {

    BaseResponse<List<DaftarPengeluaranKeluarga>> response = new BaseResponse<List<DaftarPengeluaranKeluarga>>();
    response.setStatus(200);
    response.setResult(repositoryDaftarPengeluaranKeluarga.findAllByOrderByIdAsc());

    if (response.getStatus() == 200) {
      System.out.println("Berhasil Retrieve Daftar PengeluaranKeluarga");
    }
    return response;
  }

  @CrossOrigin(origins = "*")
  @RequestMapping(method = RequestMethod.POST, path = "/addDaftarPengeluaranKeluarga")
  @ResponseBody
  public BaseResponse<DaftarPengeluaranKeluarga> addDaftarPengeluaranKeluarga(
      @RequestBody DaftarPengeluaranKeluarga daftarPengeluaranKeluarga, BindingResult bindingResult) {
    BaseResponse<DaftarPengeluaranKeluarga> response = new BaseResponse<DaftarPengeluaranKeluarga>();

    System.out.println("test post");
    if (bindingResult.hasErrors()) {
      response.setStatus(500);
      response.setMessage("Error");
    } else {
      DaftarPengeluaranKeluarga newDaftarPengeluaranKeluarga = new DaftarPengeluaranKeluarga();
      newDaftarPengeluaranKeluarga.setTanggal(daftarPengeluaranKeluarga.getTanggal());
      newDaftarPengeluaranKeluarga.setJudulPengeluaran(daftarPengeluaranKeluarga.getJudulPengeluaran());
      newDaftarPengeluaranKeluarga.setNilaiDalamRupiah(daftarPengeluaranKeluarga.getNilaiDalamRupiah());

      repositoryDaftarPengeluaranKeluarga.save(newDaftarPengeluaranKeluarga);

      response.setStatus(200);
      response.setMessage("Berhasil Menambah Daftar Pengeluaran Keluarga");
      response.setResult(newDaftarPengeluaranKeluarga);
    }

    return response;
  }

  @CrossOrigin(origins = "*")
  @RequestMapping(method = RequestMethod.PUT, path = "/updateDaftarPengeluaranKeluarga")
  @ResponseBody
  public BaseResponse<DaftarPengeluaranKeluarga> updateDaftarPengeluaranKeluarga(
      @RequestBody DaftarPengeluaranKeluarga daftarPengeluaranKeluarga, BindingResult bindingResult,
      @RequestParam(value = "id") long id) {
    BaseResponse<DaftarPengeluaranKeluarga> response = new BaseResponse<DaftarPengeluaranKeluarga>();

    System.out.println("test edit");
    if (bindingResult.hasErrors()) {
      response.setStatus(500);
      response.setMessage("Error");
    } else {
      DaftarPengeluaranKeluarga oldDaftarPengeluaranKeluarga = repositoryDaftarPengeluaranKeluarga.findById(id).get();
      oldDaftarPengeluaranKeluarga.setTanggal(daftarPengeluaranKeluarga.getTanggal());
      oldDaftarPengeluaranKeluarga.setJudulPengeluaran(daftarPengeluaranKeluarga.getJudulPengeluaran());
      oldDaftarPengeluaranKeluarga.setNilaiDalamRupiah(daftarPengeluaranKeluarga.getNilaiDalamRupiah());

      repositoryDaftarPengeluaranKeluarga.save(oldDaftarPengeluaranKeluarga);

      response.setStatus(200);
      response.setMessage("Berhasil Mengubah Daftar Pengeluaran Keluarga");
      response.setResult(oldDaftarPengeluaranKeluarga);
    }

    return response;
  }

  @CrossOrigin(origins = "*")
  @RequestMapping(method = RequestMethod.DELETE, path = "/deleteDaftarPengeluaranKeluarga")
  public void deleteDaftarPengeluaranKeluarga(@RequestParam(value = "id") long id) {
    System.out.println("test delete");
    repositoryDaftarPengeluaranKeluarga.deleteById(id);
  }
}
