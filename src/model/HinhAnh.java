/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author QHC
 */
public class HinhAnh extends BaseEntity {

    private Integer id;
    private String tenHinhAnh;

    public HinhAnh() {
    }

    public HinhAnh(Integer id, String tenHinhAnh) {
        this.id = id;
        this.tenHinhAnh = tenHinhAnh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenHinhAnh() {
        return tenHinhAnh;
    }

    public void setTenHinhAnh(String tenHinhAnh) {
        this.tenHinhAnh = tenHinhAnh;
    }

    @Override
    public String toString() {
        return "HinhAnh{" + "id=" + id + ", tenHinhAnh=" + tenHinhAnh + '}';
    }

}
