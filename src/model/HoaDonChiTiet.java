/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author thaitv
 */
public class HoaDonChiTiet {

    private Integer idHDCT, idSanPham, gia, soLuong, tongTien, giaGiam, thanhTien, idSPCT;

    private String tenSP;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(Integer idHDCT, Integer idSanPham, Integer gia, Integer soLuong, Integer tongTien, Integer giaGiam, Integer thanhTien, String tenSP) {
        this.idHDCT = idHDCT;
        this.idSanPham = idSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.giaGiam = giaGiam;
        this.thanhTien = thanhTien;
        this.tenSP = tenSP;
    }

    public Integer getIdSPCT() {
        return idSPCT;
    }

    public void setIdSPCT(Integer idSPCT) {
        this.idSPCT = idSPCT;
    }

    public Integer getIdHDCT() {
        return idHDCT;
    }

    public void setIdHDCT(Integer idHDCT) {
        this.idHDCT = idHDCT;
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getTongTien() {
        return tongTien;
    }

    public void setTongTien(Integer tongTien) {
        this.tongTien = tongTien;
    }

    public Integer getGiaGiam() {
        return giaGiam;
    }

    public void setGiaGiam(Integer giaGiam) {
        this.giaGiam = giaGiam;
    }

    public Integer getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Integer thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "idHDCT=" + idHDCT + ", idSanPham=" + idSanPham + ", gia=" + gia + ", soLuong=" + soLuong + ", tongTien=" + tongTien + ", giaGiam=" + giaGiam + ", thanhTien=" + thanhTien + ", idSPCT=" + idSPCT + ", tenSP=" + tenSP + '}';
    }

    

}
