/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author QHC
 */
public class SanPhamView {

    private Integer id;
    private String maSanPham;
    private String tenSanPham;
    private Integer soLuongTong;
    private Integer trangThai;

    public SanPhamView() {
    }

    public SanPhamView(Integer id, String maSanPham, String tenSanPham, Integer soLuongTong, Integer trangThai) {
        this.id = id;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.soLuongTong = soLuongTong;
        this.trangThai = trangThai;
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

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Integer getSoLuongTong() {
        return soLuongTong;
    }

    public void setSoLuongTong(Integer soLuongTong) {
        this.soLuongTong = soLuongTong;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanPhamView{" + "id=" + id + ", maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", soLuongTong=" + soLuongTong + ", trangThai=" + trangThai + '}';
    }

}
