/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.sql.Date;

/**
 *
 * @author QHC
 */
public abstract class BaseEntity implements Serializable {

    private Date ngayTao;
    private String nguoiTao;
    private Date ngaySua;
    private String nguoiSua;

    public BaseEntity() {
    }

    public BaseEntity(Date ngayTao, String nguoiTao, Date ngaySua, String nguoiSua) {
        this.ngayTao = ngayTao;
        this.nguoiTao = nguoiTao;
        this.ngaySua = ngaySua;
        this.nguoiSua = nguoiSua;
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

    @Override
    public String toString() {
        return "BaseEntity{" + "ngayTao=" + ngayTao + ", nguoiTao=" + nguoiTao + ", ngaySua=" + ngaySua + ", nguoiSua=" + nguoiSua + '}';
    }

}
