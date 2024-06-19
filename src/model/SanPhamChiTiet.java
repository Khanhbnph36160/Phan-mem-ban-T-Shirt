/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;

/**
 *
 * @author QHC
 */
public class SanPhamChiTiet extends BaseEntity {

    private Integer id;
    private Integer idMauSac;
    private Integer idSanPham;
    private Integer idHinhAnh;
    private Integer idThuongHieu;
    private Integer idChatLieu;
    private Integer idSize;
    private BigDecimal gia;
    private String trangThai;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(Integer id, Integer idMauSac, Integer idSanPham, Integer idHinhAnh, Integer idThuongHieu, Integer idChatLieu, Integer idSize, BigDecimal gia, String trangThai) {
        this.id = id;
        this.idMauSac = idMauSac;
        this.idSanPham = idSanPham;
        this.idHinhAnh = idHinhAnh;
        this.idThuongHieu = idThuongHieu;
        this.idChatLieu = idChatLieu;
        this.idSize = idSize;
        this.gia = gia;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(Integer idMauSac) {
        this.idMauSac = idMauSac;
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public Integer getIdHinhAnh() {
        return idHinhAnh;
    }

    public void setIdHinhAnh(Integer idHinhAnh) {
        this.idHinhAnh = idHinhAnh;
    }

    public Integer getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(Integer idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public Integer getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(Integer idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public Integer getIdSize() {
        return idSize;
    }

    public void setIdSize(Integer idSize) {
        this.idSize = idSize;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanPhamChiTiet{" + "id=" + id + ", idMauSac=" + idMauSac + ", idSanPham=" + idSanPham + ", idHinhAnh=" + idHinhAnh + ", idThuongHieu=" + idThuongHieu + ", idChatLieu=" + idChatLieu + ", idSize=" + idSize + ", gia=" + gia + ", trangThai=" + trangThai + '}';
    }

}
