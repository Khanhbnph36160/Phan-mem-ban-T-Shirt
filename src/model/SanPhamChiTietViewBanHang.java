/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author thaitv
 */
public class SanPhamChiTietViewBanHang {

    private Integer idSPCT, idSanPham, soLuong, gia;

    private String tenSanPham, mau, size, chatLieu, thuongHieu;

    public SanPhamChiTietViewBanHang() {
    }

    public SanPhamChiTietViewBanHang(Integer idSPCT, Integer idSanPham, Integer soLuong, Integer gia, String tenSanPham, String mau, String size, String chatLieu, String thuongHieu) {
        this.idSPCT = idSPCT;
        this.idSanPham = idSanPham;
        this.soLuong = soLuong;
        this.gia = gia;
        this.tenSanPham = tenSanPham;
        this.mau = mau;
        this.size = size;
        this.chatLieu = chatLieu;
        this.thuongHieu = thuongHieu;
    }

    public Integer getIdSPCT() {
        return idSPCT;
    }

    public void setIdSPCT(Integer idSPCT) {
        this.idSPCT = idSPCT;
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

}
