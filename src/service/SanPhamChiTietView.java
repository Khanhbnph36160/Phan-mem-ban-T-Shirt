/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.math.BigDecimal;
import java.sql.*;

/**
 *
 * @author QHC
 */
public class SanPhamChiTietView {

    private Integer id;
    private String maSanPham;
    private Date ngayNhap;
    private String mauSac;
    private String size;
    private String chatLieu;
    private String hang;
    private Integer soLuong;
    private BigDecimal gia;
    private Integer idSanPham;
    private String tenSanPham;

    public SanPhamChiTietView() {
    }

    public SanPhamChiTietView(Integer id, String maSanPham, Date ngayNhap, String mauSac, String size, 
            String chatLieu, String hang, Integer soLuong, BigDecimal gia, Integer idSanPham, String tenSanPham) {
        this.id = id;
        this.maSanPham = maSanPham;
        this.ngayNhap = ngayNhap;
        this.mauSac = mauSac;
        this.size = size;
        this.chatLieu = chatLieu;
        this.hang = hang;
        this.soLuong = soLuong;
        this.gia = gia;
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
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

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    @Override
    public String toString() {
        return "SanPhamChiTietView{" + "id=" + id + ", maSanPham=" + maSanPham + ", ngayNhap=" + ngayNhap + ", mauSac=" + mauSac + ", size=" + size + ", chatLieu=" + chatLieu + ", hang=" + hang + ", soLuong=" + soLuong + ", gia=" + gia + '}';
    }

}
