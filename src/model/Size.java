/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author QHC
 */
public class Size extends BaseEntity {

    private Integer id;
    private String tenSize;

    public Size() {
    }

    public Size(Integer id, String tenSize) {
        this.id = id;
        this.tenSize = tenSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    @Override
    public String toString() {
        return "Size{" + "id=" + id + ", tenSize=" + tenSize + '}';
    }

}
