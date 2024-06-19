/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Date;
/**
 *
 * @author le Van Vu
 */
public class Vouchermode {
    private int id;
    private int idHoaDon;
    private String tenVoucher;
    private int idNhanVien;
    private int soLuong;
    private BigDecimal giaTriToiThieu;
    private BigDecimal giaTriToiDa;
    private Timestamp ngayBatDau;
    private Timestamp ngayKetThuc;
    private String trangThai;
    private Date ngayTao;
    private String nguoiTao;
    private Date ngaySua;
    private String nguoiSua;
    private BigDecimal giatri;

    public Vouchermode() {
    }

    public Vouchermode(int id, String tenVoucher, int idNhanVien, int soLuong, BigDecimal giaTriToiThieu, BigDecimal giaTriToiDa, Timestamp ngayBatDau, Timestamp ngayKetThuc, String trangThai, Date ngayTao, String nguoiTao, Date ngaySua, String nguoiSua, BigDecimal giatri) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.tenVoucher = tenVoucher;
        this.idNhanVien = idNhanVien;
        this.soLuong = soLuong;
        this.giaTriToiThieu = giaTriToiThieu;
        this.giaTriToiDa = giaTriToiDa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.nguoiTao = nguoiTao;
        this.ngaySua = ngaySua;
        this.nguoiSua = nguoiSua;
        this.giatri = giatri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenVoucher() {
        return tenVoucher;
    }

    public void setTenVoucher(String tenVoucher) {
        this.tenVoucher = tenVoucher;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGiaTriToiThieu() {
        return giaTriToiThieu;
    }

    public void setGiaTriToiThieu(BigDecimal giaTriToiThieu) {
        this.giaTriToiThieu = giaTriToiThieu;
    }

    public BigDecimal getGiaTriToiDa() {
        return giaTriToiDa;
    }

    public void setGiaTriToiDa(BigDecimal giaTriToiDa) {
        this.giaTriToiDa = giaTriToiDa;
    }

    public Timestamp getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Timestamp ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Timestamp getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Timestamp ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public String getNguoiSua() {
        return nguoiSua;
    }

    public void setNguoiSua(String nguoiSua) {
        this.nguoiSua = nguoiSua;
    }

    public BigDecimal getGiatri() {
        return giatri;
    }

    public void setGiatri(BigDecimal giatri) {
        this.giatri = giatri;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    @Override
    public String toString() {
        return "Vouchermode{" + "id=" + id + ", idHoaDon=" + idHoaDon + ", tenVoucher=" + tenVoucher + ", idNhanVien=" + idNhanVien + ", soLuong=" + soLuong + ", giaTriToiThieu=" + giaTriToiThieu + ", giaTriToiDa=" + giaTriToiDa + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", trangThai=" + trangThai + ", ngayTao=" + ngayTao + ", nguoiTao=" + nguoiTao + ", ngaySua=" + ngaySua + ", nguoiSua=" + nguoiSua + ", giatri=" + giatri + '}';
    }
    
    
}
