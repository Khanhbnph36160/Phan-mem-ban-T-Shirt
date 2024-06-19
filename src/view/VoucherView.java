/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import service.QuanLyVoucher;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Vouchermode;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author le Van Vu
 */
public class VoucherView extends javax.swing.JFrame {

    private QuanLyVoucher quanLyVoucher;
    private ViewBanHang viewBanHang;

    public VoucherView() {
        initComponents();
        quanLyVoucher = new QuanLyVoucher();
        loadDataToTable();

        txtnguoitao.addItem("Admin");
        txtnguoitao.addItem("Nhân Viên");

        txtnguoisua.addItem("Admin");
        txtnguoisua.addItem("Nhân Viên");
    }

  private void loadDataToTable() {
        DefaultTableModel model = (DefaultTableModel) tblvoucher.getModel();
        model.setRowCount(0);
        List<Vouchermode> vouchers = quanLyVoucher.getAllVouchers();
        for (Vouchermode voucher : vouchers) {
            model.addRow(new Object[]{
                voucher.getId(),
                voucher.getTenVoucher(),
                voucher.getIdNhanVien(),
                voucher.getGiatri(),
                voucher.getSoLuong(),
                voucher.getGiaTriToiThieu(),
                voucher.getGiaTriToiDa(),
                voucher.getNgayBatDau(),
                voucher.getNgayKetThuc(),
                voucher.getTrangThai(),
                voucher.getNgayTao(),
                voucher.getNguoiTao(),
                voucher.getNgaySua(),
                voucher.getNguoiSua()
            });
        }
    }

    private void clearFields() {
        txtid.setText("");
        txtten.setText("");
        txtnhanvien.setText("");
        txtsoluong.setText("");
        txtgiatritoithieu.setText("");
        txtgiatritoida.setText("");
        txtgiatri.setText("");
        detetungay.setDate(null);
        detedenngay.setDate(null);
        detengaysua.setDate(null);
        detengaytao.setDate(null);
        txtnguoitao.setSelectedIndex(-1);
        txtnguoisua.setSelectedIndex(-1);
        buttonGroup1.clearSelection();
    }

    private void updateVoucher() {
        int selectedRow = tblvoucher.getSelectedRow();
        if (selectedRow != -1) {
            try {
                int id = Integer.parseInt(txtid.getText());
                Vouchermode voucher = quanLyVoucher.getVoucherById(id, TOP_ALIGNMENT);
                if (voucher != null) {
                    voucher.setTenVoucher(txtten.getText());
                    voucher.setIdNhanVien(Integer.parseInt(txtnhanvien.getText()));
                    voucher.setGiatri(new BigDecimal(txtgiatri.getText()));
                    voucher.setSoLuong(Integer.parseInt(txtsoluong.getText()));
                    voucher.setGiaTriToiThieu(new BigDecimal(txtgiatritoithieu.getText()));
                    voucher.setGiaTriToiDa(new BigDecimal(txtgiatritoida.getText()));
                    voucher.setNgayBatDau(new Timestamp(detetungay.getDate().getTime()));
                    voucher.setNgayKetThuc(new Timestamp(detedenngay.getDate().getTime()));
                    voucher.setNgayTao(new java.sql.Date(detengaytao.getDate().getTime()));
                    voucher.setNgaySua(new java.sql.Date(detengaysua.getDate().getTime()));
                    voucher.setNguoiTao(txtnguoitao.getSelectedItem().toString());
                    voucher.setNguoiSua(txtnguoisua.getSelectedItem().toString());

                    if (hoatdong.isSelected()) {
                        voucher.setTrangThai("Hoạt động");
                    } else if (dahethan.isSelected()) {
                        voucher.setTrangThai("Hết hạn");
                    }
                    quanLyVoucher.capNhatVoucher(voucher);

                    loadDataToTable();
                    clearFields();
                    JOptionPane.showMessageDialog(this, "Cập nhật voucher thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy voucher với ID: " + id);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số cho các trường có liên quan!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để cập nhật!");
        }
    }

    public void addVoucher() {
        if (!validateInput()) {
            return;
        }
        
        Vouchermode voucher = new Vouchermode();
        voucher.setTenVoucher(txtten.getText());
        voucher.setIdNhanVien(Integer.parseInt(txtnhanvien.getText()));
        voucher.setGiatri(new BigDecimal(txtgiatri.getText()));
        voucher.setSoLuong(Integer.parseInt(txtsoluong.getText()));
        voucher.setGiaTriToiThieu(new BigDecimal(txtgiatritoithieu.getText()));
        voucher.setGiaTriToiDa(new BigDecimal(txtgiatritoida.getText()));
        voucher.setNgayBatDau(new Timestamp(detetungay.getDate().getTime()));
        voucher.setNgayKetThuc(new Timestamp(detedenngay.getDate().getTime()));
        voucher.setNgayTao(new java.sql.Date(detengaytao.getDate().getTime()));
        voucher.setNguoiTao(txtnguoitao.getSelectedItem().toString());
        voucher.setNgaySua(new java.sql.Date(detengaysua.getDate().getTime())); 
        voucher.setNguoiSua(txtnguoisua.getSelectedItem().toString());

        if (hoatdong.isSelected()) {
            voucher.setTrangThai("Hoạt động");
        } else if (dahethan.isSelected()) {
            voucher.setTrangThai("Hết hạn");
        }

        quanLyVoucher.themVoucher(voucher);
        loadDataToTable();
        clearFields();
    }

    private boolean validateInput() {
    // Kiểm tra các trường bắt buộc
    if (txtten.getText().isEmpty() || txtnhanvien.getText().isEmpty() || txtsoluong.getText().isEmpty() || txtgiatritoithieu.getText().isEmpty() || txtgiatritoida.getText().isEmpty() || detetungay.getDate() == null || detedenngay.getDate() == null || detengaytao.getDate() == null || detengaysua.getDate() == null || txtnguoitao.getSelectedIndex() == -1 || txtnguoisua.getSelectedIndex() == -1 || txtgiatri.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
        return false;
    }

    try {
        // Kiểm tra định dạng dữ liệu
        int idNhanVien = Integer.parseInt(txtnhanvien.getText());
        int soLuong = Integer.parseInt(txtsoluong.getText());
        BigDecimal giaTriToiThieu = new BigDecimal(txtgiatritoithieu.getText());
        BigDecimal giaTriToiDa = new BigDecimal(txtgiatritoida.getText());
        BigDecimal giaTri = new BigDecimal(txtgiatri.getText());

        // Kiểm tra hợp lệ của dữ liệu số
        if (soLuong <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0!");
            return false;
        }
        
        if (giaTri.compareTo(BigDecimal.ZERO) <= 0 || giaTri.compareTo(new BigDecimal("500")) > 0) {
            JOptionPane.showMessageDialog(this, "Giá trị phải lớn hơn 0 và không vượt quá 500!");
            return false;
        }
        if (giaTriToiThieu.compareTo(giaTriToiDa) > 0) {
            JOptionPane.showMessageDialog(this, "Giá trị tối thiểu không được lớn hơn giá trị tối đa!");
            return false;
        }

        if (detetungay.getDate().after(detedenngay.getDate())) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải trước ngày kết thúc!");
            return false;
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số cho các trường có liên quan!");
        return false;
    }

    return true;
}

    private void filterTableByStatus(String status) {
        DefaultTableModel model = (DefaultTableModel) tblvoucher.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tblvoucher.setRowSorter(sorter);

        List<RowFilter<Object, Object>> filters = new ArrayList<>();
        filters.add(RowFilter.regexFilter(status, 8)); // 8 là chỉ số cột của trạng thái trong bảng

        RowFilter<Object, Object> combinedFilter = RowFilter.andFilter(filters);
        sorter.setRowFilter(combinedFilter);
    }

    private void loadDataByStatus(String status) {
        DefaultTableModel model = (DefaultTableModel) tblvoucher.getModel();
        model.setRowCount(0);
        List<Vouchermode> vouchers = quanLyVoucher.getVouchersByStatus(status);
        for (Vouchermode voucher : vouchers) {
            model.addRow(new Object[]{
                voucher.getId(),
                voucher.getTenVoucher(),
                voucher.getIdNhanVien(),
                voucher.getGiatri(),
                voucher.getSoLuong(),
                voucher.getGiaTriToiThieu(),
                voucher.getGiaTriToiDa(),
                voucher.getNgayBatDau(),
                voucher.getNgayKetThuc(),
                voucher.getTrangThai(),
                voucher.getNgayTao(),
                voucher.getNguoiTao(),
                voucher.getNgaySua(),
                voucher.getNguoiSua()
            });
        }
    }

    private void displaySearchResults(List<Vouchermode> vouchers) {
        DefaultTableModel model = (DefaultTableModel) tblvoucher.getModel();
        model.setRowCount(0);
        for (Vouchermode voucher : vouchers) {
            model.addRow(new Object[]{
                voucher.getId(),
                voucher.getTenVoucher(),
                voucher.getIdNhanVien(),
                voucher.getGiatri(),
                voucher.getSoLuong(),
                voucher.getGiaTriToiThieu(),
                voucher.getGiaTriToiDa(),
                voucher.getNgayBatDau(),
                voucher.getNgayKetThuc(),
                voucher.getTrangThai(),
                voucher.getNgayTao(),
                voucher.getNguoiTao(),
                voucher.getNgaySua(),
                voucher.getNguoiSua()
            });
        }
    
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtten = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnhanvien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        detengaytao = new com.toedter.calendar.JDateChooser();
        detengaysua = new com.toedter.calendar.JDateChooser();
        txtnguoitao = new javax.swing.JComboBox<>();
        txtnguoisua = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        updata = new javax.swing.JButton();
        addeven = new javax.swing.JButton();
        clearform = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtgiatritoithieu = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtgiatritoida = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        hoatdong = new javax.swing.JRadioButton();
        dahethan = new javax.swing.JRadioButton();
        detedenngay = new com.toedter.calendar.JDateChooser();
        detetungay = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        txtgiatri = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblvoucher = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        timtrangthai = new javax.swing.JRadioButton();
        timtrangthai1 = new javax.swing.JRadioButton();
        find = new javax.swing.JTextField();
        findbuton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Voucher");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("ID : ");

        jLabel3.setText("Tên Voucher :");

        jLabel6.setText("Ngày tạo :");

        jLabel7.setText("Ngày sửa");

        jLabel16.setText("Người tạo :");

        jLabel17.setText("Người sửa :");

        jLabel4.setText("ID Nhân Viên :");

        jLabel5.setText("Số lượng :");

        txtnguoitao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));

        txtnguoisua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));
        txtnguoisua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnguoisuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(detengaytao, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnguoisua, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnguoitao, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(detengaysua, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(txtnguoitao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(txtnguoisua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(detengaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addComponent(detengaysua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        updata.setText("Updata Even");
        updata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updataMouseClicked(evt);
            }
        });

        addeven.setText("Add Even");
        addeven.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addevenMouseClicked(evt);
            }
        });
        addeven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addevenActionPerformed(evt);
            }
        });

        clearform.setText("Claer Form");
        clearform.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearformMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(addeven, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearform, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updata, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addeven, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearform, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(updata, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setText("Ngày kết thúc :");

        jLabel9.setText("Giá trị tối thiểu :");

        jLabel10.setText("Giá trị tối đa :");

        jLabel11.setText("Trạng thái :");

        jLabel13.setText("Ngày bắt đầu :");

        buttonGroup1.add(hoatdong);
        hoatdong.setText("Đang hoạt động");

        buttonGroup1.add(dahethan);
        dahethan.setText("Đã hết hạn ");

        detedenngay.setDateFormatString("yyyy-MM-dd");

        detetungay.setDateFormatString("yyyy-MM-dd");

        jLabel15.setText("Giá Trị :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(detetungay, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(detedenngay, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtgiatritoida, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(txtgiatritoithieu))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtgiatri, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hoatdong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dahethan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(detetungay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(detedenngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtgiatritoithieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(hoatdong)
                                    .addComponent(dahethan))
                                .addGap(30, 30, 30)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtgiatritoida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(txtgiatri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblvoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên Voucher", "ID Nhân Viên", "Giá Trị", "Số lượng ", "Giá trị tối thiểu", "Giá trị tối đa", "Ngày bắt đầu ", "Ngày kết thúc", "Trạng thái ", "Ngày tạo ", "Người tạo", "Ngày sửa", "Người sửa"
            }
        ));
        tblvoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblvoucherMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblvoucher);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("Danh Sách Voucher ");

        jLabel14.setText("Lọc trạng thái :");

        buttonGroup2.add(timtrangthai);
        timtrangthai.setText("Đang hoạt động ");
        timtrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timtrangthaiActionPerformed(evt);
            }
        });

        buttonGroup2.add(timtrangthai1);
        timtrangthai1.setText("Đã hết hạn");
        timtrangthai1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timtrangthai1ActionPerformed(evt);
            }
        });

        find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findActionPerformed(evt);
            }
        });

        findbuton.setText("Tìm kiếm :");
        findbuton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findbutonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(620, 620, 620))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(274, 274, 274)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timtrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(timtrangthai1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(findbuton)
                                .addGap(18, 18, 18)
                                .addComponent(find, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(timtrangthai)
                    .addComponent(timtrangthai1)
                    .addComponent(find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findbuton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updataMouseClicked
        if (validateInput()) {
            updateVoucher();
        }

    }//GEN-LAST:event_updataMouseClicked

    private void addevenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addevenMouseClicked
        addVoucher();

        if (viewBanHang != null) {
            viewBanHang.loadcboVoucher();
        }
    }//GEN-LAST:event_addevenMouseClicked

    private void clearformMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearformMouseClicked
        clearFields();
    }//GEN-LAST:event_clearformMouseClicked

    private void tblvoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblvoucherMouseClicked
      int row = tblvoucher.getSelectedRow(); 
    if (row != -1) { 
        String id = tblvoucher.getValueAt(row, 0).toString();
        String tenVoucher = tblvoucher.getValueAt(row, 1).toString();
        String idNhanVien = tblvoucher.getValueAt(row, 2).toString();
        String giaTri = tblvoucher.getValueAt(row, 3).toString(); // Cột giá trị mới
        String soLuong = tblvoucher.getValueAt(row, 4).toString();
        String giaTriToiThieu = tblvoucher.getValueAt(row, 5).toString();
        String giaTriToiDa = tblvoucher.getValueAt(row, 6).toString();
        String ngayBatDau = tblvoucher.getValueAt(row, 7).toString();
        String ngayKetThuc = tblvoucher.getValueAt(row, 8).toString();
        String trangThai = tblvoucher.getValueAt(row, 9).toString();
        String ngayTao = tblvoucher.getValueAt(row, 10).toString();
        String nguoiTao = tblvoucher.getValueAt(row, 11).toString();
        String ngaySua = tblvoucher.getValueAt(row, 12).toString();
        String nguoiSua = tblvoucher.getValueAt(row, 13).toString();
        
        txtid.setText(id);
        txtten.setText(tenVoucher);
        txtnhanvien.setText(idNhanVien);
        txtgiatri.setText(giaTri); // Gán giá trị mới vào text field
        txtsoluong.setText(soLuong);
        txtgiatritoithieu.setText(giaTriToiThieu);
        txtgiatritoida.setText(giaTriToiDa);
        
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày tháng của bạn
            detetungay.setDate(df.parse(ngayBatDau));
            detedenngay.setDate(df.parse(ngayKetThuc));
            detengaytao.setDate(df.parse(ngayTao));
            detengaysua.setDate(df.parse(ngaySua));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        txtnguoitao.setSelectedItem(nguoiTao);
        txtnguoisua.setSelectedItem(nguoiSua);
        
        if (trangThai.equalsIgnoreCase("Hoạt động")) {
            hoatdong.setSelected(true);
        } else if (trangThai.equalsIgnoreCase("Hết hạn")) {
            dahethan.setSelected(true);
        }
    }
    }//GEN-LAST:event_tblvoucherMouseClicked

    private void timtrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timtrangthaiActionPerformed
        loadDataByStatus("Hoạt động");
    }//GEN-LAST:event_timtrangthaiActionPerformed

    private void timtrangthai1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timtrangthai1ActionPerformed
        loadDataByStatus("Hết hạn");
    }//GEN-LAST:event_timtrangthai1ActionPerformed

    private void findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findActionPerformed

    }//GEN-LAST:event_findActionPerformed

    private void findbutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findbutonActionPerformed
        String searchKeyword = find.getText().trim();

        if (!searchKeyword.isEmpty()) {
            List<Vouchermode> foundVouchers = quanLyVoucher.timVoucherTheoTuKhoa(searchKeyword); // Tìm kiếm voucher theo từ khóa
            if (!foundVouchers.isEmpty()) {
                displaySearchResults(foundVouchers);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả phù hợp!");
            }
        } else {
            loadDataToTable();
        }
    }//GEN-LAST:event_findbutonActionPerformed

    private void addevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addevenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addevenActionPerformed

    private void txtnguoisuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnguoisuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnguoisuaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VoucherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoucherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoucherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoucherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VoucherView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addeven;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton clearform;
    private javax.swing.JRadioButton dahethan;
    private com.toedter.calendar.JDateChooser detedenngay;
    private com.toedter.calendar.JDateChooser detengaysua;
    private com.toedter.calendar.JDateChooser detengaytao;
    private com.toedter.calendar.JDateChooser detetungay;
    private javax.swing.JTextField find;
    private javax.swing.JButton findbuton;
    private javax.swing.JRadioButton hoatdong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblvoucher;
    private javax.swing.JRadioButton timtrangthai;
    private javax.swing.JRadioButton timtrangthai1;
    private javax.swing.JTextField txtgiatri;
    private javax.swing.JTextField txtgiatritoida;
    private javax.swing.JTextField txtgiatritoithieu;
    private javax.swing.JTextField txtid;
    private javax.swing.JComboBox<String> txtnguoisua;
    private javax.swing.JComboBox<String> txtnguoitao;
    private javax.swing.JTextField txtnhanvien;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txtten;
    private javax.swing.JButton updata;
    // End of variables declaration//GEN-END:variables
}
