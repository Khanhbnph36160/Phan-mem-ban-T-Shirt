/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author QHC
 */
public class SanPham extends BaseEntity {

    private Integer id;
    private String tenSanPham;
    private Integer soLuong;
    private Integer trangThai;

    public SanPham() {
    }

    public SanPham(Integer id, String tenSanPham, Integer soLuong, Integer trangThai) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanPham{" + "id=" + id + ", tenSanPham=" + tenSanPham + ", soLuong=" + soLuong + ", trangThai=" + trangThai + '}';
    }

}
