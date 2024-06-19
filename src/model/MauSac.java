/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author QHC
 */
public class MauSac extends BaseEntity {

    private Integer id;
    private String tenMau;

    public MauSac() {
    }

    public MauSac(Integer id, String tenMau) {
        this.id = id;
        this.tenMau = tenMau;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    @Override
    public String toString() {
        return "MauSac{" + "id=" + id + ", tenMau=" + tenMau + '}';
    }

}
