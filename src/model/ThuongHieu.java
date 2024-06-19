/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author QHC
 */
public class ThuongHieu extends BaseEntity {

    private Integer id;
    private String tenThuongHieu;

    public ThuongHieu() {
    }

    public ThuongHieu(Integer id, String tenThuongHieu) {
        this.id = id;
        this.tenThuongHieu = tenThuongHieu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    @Override
    public String toString() {
        return "ThuongHieu{" + "id=" + id + ", tenThuongHieu=" + tenThuongHieu + '}';
    }

}
