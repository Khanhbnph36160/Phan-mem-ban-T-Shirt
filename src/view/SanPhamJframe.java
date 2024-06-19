/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Model.ChatLieu;
import Model.MauSac;
import Model.SanPham;
import Model.SanPhamChiTiet;
import Model.Size;
import Model.ThuongHieu;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.BaseService;
import service.SanPhamService;
import service.impl.ChatLieuServiceImpl;
import service.impl.MauSacServiceImpl;
import service.impl.SanPhamChiTietServiceImpl;
import service.impl.SanPhamServiceImpl;
import service.impl.SizeServiceImpl;
import service.impl.ThuongHieuServiceImpl;
import view.SanPhamChiTietView;
import view.SanPhamView;

/**
 *
 * @author QHC
 */
public class SanPhamJframe extends javax.swing.JFrame {

    private BaseService<SanPham> sanPhamService;
    private SanPhamService getAllSanPham;
    private BaseService<SanPhamChiTiet> sanPhamChiTietService;
    private SanPhamChiTietServiceImpl getAllSanPhamCT;
    private BaseService<MauSac> baseServiceMauSac;
    private BaseService<ChatLieu> baseServiceChatLieu;
    private BaseService<Size> baseServiceSize;
    private BaseService<ThuongHieu> baseServiceThuongHieu;
    private ViewBanHang viewBanHang = new ViewBanHang(null);
    private String idSanPham = null;

    public SanPhamJframe() {
        initComponents();
        this.setLocationRelativeTo(null);
        sanPhamService = new SanPhamServiceImpl();
        getAllSanPham = new SanPhamServiceImpl();
        sanPhamChiTietService = new SanPhamChiTietServiceImpl();
        getAllSanPhamCT = new SanPhamChiTietServiceImpl();
        baseServiceMauSac = new MauSacServiceImpl();
        baseServiceChatLieu = new ChatLieuServiceImpl();
        baseServiceSize = new SizeServiceImpl();
        baseServiceThuongHieu = new ThuongHieuServiceImpl();
        loadFormSanPham(null);
        loadFormSanPhamChiTiet(null);
        loadComboboxMauSac(baseServiceMauSac.findAll(null));
        loadComboboxChatLieu(baseServiceChatLieu.findAll(null));
        loadComboboxHang(baseServiceThuongHieu.findAll(null));
        loadComboboxSize(baseServiceSize.findAll(null));
        loadFormProperties(null);
        clearFormProperties();
        clearSP();
        clearSPCT();
        cbTrangThai.setSelected(true);
    }

    private SanPham getDataSanPhamByForm() {
        String id = this.jblIdSP.getText();
        String tenSanPham = this.txtTenSP.getText();
        String soLuong = this.txtSoLuongSanPham.getText();
        Boolean trangThai = this.cbTrangThai.isSelected();

        if (tenSanPham == null || "".equals(tenSanPham) || tenSanPham.trim() == "") {
            JOptionPane.showMessageDialog(this, "Ten san pham khong duoc bo trong");
            return null;
        }

        if (soLuong == null || "".equals(soLuong) || soLuong.trim() == "") {
            JOptionPane.showMessageDialog(this, "So luong san pham khong duoc bo trong");
            return null;
        }

        try {
            SanPham sp = new SanPham();
            sp.setId("-".equals(id.trim()) || "".equals(id) ? null : Integer.valueOf(id));
            sp.setTenSanPham(tenSanPham);
            sp.setSoLuong(Integer.valueOf(soLuong));
            sp.setTrangThai(trangThai == true ? 1 : 0);

            return sp;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "So luong san pham khong hop le");
            return null;
        }
    }

    private void clearSP() {
        this.jblIdSP.setText("");
        this.txtTenSP.setText("");
        this.txtSoLuongSanPham.setText("");
        this.cbTrangThai.setSelected(false);
    }

    private void loadFormSanPham(String tenSanPham) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblSanPham.getModel();
        dtm.setRowCount(0);
        int count = 1;
        for (SanPhamView sp : getAllSanPham.findAllSanPham(tenSanPham)) {
            Object[] data = {
                count++,
                sp.getId(),
                sp.getTenSanPham(),
                sp.getSoLuongTong(),
                sp.getTrangThai() == 1 ? "Đang hoạt động" : "Ngưng hoạt động",};
            dtm.addRow(data);
            System.out.println(sp);

        }

    }

    private void loadFormSanPhamChiTiet(String trangThai) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblSanPhamChiTiet.getModel();
        dtm.setRowCount(0);
        int stt = 1;
        for (SanPhamChiTietView h : getAllSanPhamCT.findAllSanPhamChiTiet(idSanPham == null ? null : Integer.valueOf(idSanPham), trangThai)) {
            System.out.println(h);
            Object[] rowData = {
                h.getId(),
                h.getIdSanPham(),
                h.getTenSanPham(),
                h.getNgayNhap(),
                h.getMauSac(),
                h.getSize(),
                h.getChatLieu(),
                h.getHang(),
                h.getSoLuong(),
                h.getGia()
            };
            dtm.addRow(rowData);
            stt++;
        }
    }

    private void loadComboboxMauSac(List<MauSac> data) {
        for (MauSac ms : data) {
            cbbMauSac.addItem(ms.getTenMau());
        }
    }

    private void loadComboboxSize(List<Size> data) {
        for (Size ms : data) {
            cbbSize.addItem(ms.getTenSize());
        }
    }

    private void loadComboboxChatLieu(List<ChatLieu> data) {
        for (ChatLieu ms : data) {
            cbbChatLieu.addItem(ms.getTenChatLieu());
        }
    }

    private void loadComboboxHang(List<ThuongHieu> data) {
        for (ThuongHieu ms : data) {
            cbbHang.addItem(ms.getTenThuongHieu());
        }
    }

    private SanPhamChiTiet getDataSPCTByForm() {
        String id = this.jblIdSanPhamChitiet.getText();
        String mauSac = (String) this.cbbMauSac.getSelectedItem();
        String size = (String) this.cbbSize.getSelectedItem();
        String chatLieu = (String) this.cbbChatLieu.getSelectedItem();
        String hang = (String) this.cbbHang.getSelectedItem();
        LocalDate ngayNhap = LocalDate.now();
        String soLuong = this.txtSoLuongSPCT.getText();
        String gia = this.txtGia.getText();

        try {
            SanPhamChiTiet spct = new SanPhamChiTiet();
            spct.setId(id.equals("-") ? null : Integer.valueOf(id));
            spct.setIdMauSac(getIdMauSacCombobox(mauSac) == -1 ? null : getIdMauSacCombobox(mauSac));
            spct.setIdSize(getIdSizeCombobox(size) == -1 ? null : getIdSizeCombobox(size));
            spct.setIdChatLieu(getIdChatLieuCombobox(chatLieu) == -1 ? null : getIdChatLieuCombobox(chatLieu));
            spct.setIdThuongHieu(getIdThuongHieuCombobox(hang) == -1 ? null : getIdThuongHieuCombobox(hang));
            spct.setNgayTao(Date.valueOf(ngayNhap));
            spct.setGia(new BigDecimal(gia));
            spct.setIdSanPham(idSanPham == null ? null : Integer.valueOf(idSanPham));
            spct.setTrangThai("Còn hàng");

            return spct;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Gia khong hop le");
            e.printStackTrace();
            return null;
        }
    }

    private void loadFormProperties(String name) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblThuocTinh.getModel();
        dtm.setRowCount(0);
        int stt = 1;
        if (this.rbnMauSac.isSelected()) {
            for (MauSac h : baseServiceMauSac.findAll(name)) {
                Object[] rowData = {
                    stt,
                    h.getId(),
                    h.getTenMau(),};
                dtm.addRow(rowData);
                stt++;
            }
        }

        if (this.rbnSize.isSelected()) {
            for (Size h : baseServiceSize.findAll(name)) {
                Object[] rowData = {
                    stt,
                    h.getId(),
                    h.getTenSize(),};
                dtm.addRow(rowData);
                stt++;
            }
        }

        if (this.rbnChatLieu.isSelected()) {
            for (ChatLieu h : baseServiceChatLieu.findAll(name)) {
                Object[] rowData = {
                    stt,
                    h.getId(),
                    h.getTenChatLieu(),};
                dtm.addRow(rowData);
                stt++;
            }
        }

        if (this.rbnHang.isSelected()) {
            for (ThuongHieu h : baseServiceThuongHieu.findAll(name)) {
                Object[] rowData = {
                    stt,
                    h.getId(),
                    h.getTenThuongHieu(),};
                dtm.addRow(rowData);
                stt++;
            }
        }
    }

    private int getIdMauSacCombobox(String item) {
        int id = -1;
        DefaultComboBoxModel dcb = (DefaultComboBoxModel) this.cbbMauSac.getModel();
        List<MauSac> mauSacList = this.baseServiceMauSac.findAll(null);
        for (MauSac ms : mauSacList) {
            if (ms.getTenMau().equalsIgnoreCase(item)) {
                id = ms.getId();
            }
        }
        return id;
    }

    private int getIdSizeCombobox(String item) {
        int id = -1;
        DefaultComboBoxModel dcb = (DefaultComboBoxModel) this.cbbSize.getModel();
        List<Size> sizeList = this.baseServiceSize.findAll(null);
        for (Size ms : sizeList) {
            if (ms.getTenSize().equalsIgnoreCase(item)) {
                id = ms.getId();
            }
        }
        return id;
    }

    private int getIdChatLieuCombobox(String item) {
        int id = -1;
        DefaultComboBoxModel dcb = (DefaultComboBoxModel) this.cbbChatLieu.getModel();
        List<ChatLieu> chatLieuList = this.baseServiceChatLieu.findAll(null);
        for (ChatLieu ms : chatLieuList) {
            if (ms.getTenChatLieu().equalsIgnoreCase(item)) {
                id = ms.getId();
            }
        }
        return id;
    }

    private int getIdThuongHieuCombobox(String item) {
        int id = -1;
        DefaultComboBoxModel dcb = (DefaultComboBoxModel) this.cbbHang.getModel();
        List<ThuongHieu> thuongHieuList = this.baseServiceThuongHieu.findAll(null);
        for (ThuongHieu ms : thuongHieuList) {
            if (ms.getTenThuongHieu().equalsIgnoreCase(item)) {
                id = ms.getId();
            }
        }
        return id;
    }

    private void clearSPCT() {
        this.jblIdSanPhamChitiet.setText("-");
        this.cbbMauSac.setSelectedIndex(0);
        this.cbbSize.setSelectedIndex(0);
        this.cbbChatLieu.setSelectedIndex(0);
        this.cbbHang.setSelectedIndex(0);
        this.jblNgayNhap.setText("-");
        this.txtSoLuongSPCT.setText("");
        this.txtGia.setText("");
    }

    private String getNameProperties() {
        String name = this.txtTenThuocTinh.getText();
        return name;
    }

    private void clearFormProperties() {
        this.jblIdThuocTinh.setText("-");
        this.txtTenThuocTinh.setText("");
        this.txtTimKienThuocTinh.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSoLuongSanPham = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbTrangThai = new javax.swing.JCheckBox();
        btnAddSP = new javax.swing.JButton();
        btnUpdateSP = new javax.swing.JButton();
        btnClearSP = new javax.swing.JButton();
        jblIdSP = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPhamChiTiet = new javax.swing.JTable();
        cbMatHang = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnUpdateSPCT = new javax.swing.JButton();
        btnAddSPCT = new javax.swing.JButton();
        txtSoLuongSPCT = new javax.swing.JTextField();
        jblNgayNhap = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jblIdSanPhamChitiet = new javax.swing.JLabel();
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbSize = new javax.swing.JComboBox<>();
        cbbChatLieu = new javax.swing.JComboBox<>();
        cbbHang = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        rbnMauSac = new javax.swing.JRadioButton();
        rbnSize = new javax.swing.JRadioButton();
        rbnChatLieu = new javax.swing.JRadioButton();
        rbnHang = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        jblIdThuocTinh = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtTenThuocTinh = new javax.swing.JTextField();
        btnAddThuocTinh = new javax.swing.JButton();
        btnUpdateThuocTinh = new javax.swing.JButton();
        btnClearThuocTinh = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtTimKienThuocTinh = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblThuocTinh = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setMaximumSize(new java.awt.Dimension(35000, 32767));
        jPanel7.setPreferredSize(new java.awt.Dimension(983, 700));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));

        jLabel1.setText("ID");

        jLabel2.setText("Tên SP");

        jLabel3.setText("Số lượng tổng");

        jLabel4.setText("Trạng thái");

        cbTrangThai.setSelected(true);
        cbTrangThai.setText("Còn hàng");

        btnAddSP.setText("Add SP");
        btnAddSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSPActionPerformed(evt);
            }
        });

        btnUpdateSP.setText("Update SP");
        btnUpdateSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSPActionPerformed(evt);
            }
        });

        btnClearSP.setText("Clear");
        btnClearSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearSPActionPerformed(evt);
            }
        });

        jblIdSP.setText("-");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTrangThai)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTenSP)
                                .addComponent(txtSoLuongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jblIdSP, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddSP)
                            .addComponent(btnUpdateSP)
                            .addComponent(btnClearSP))))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnAddSP)
                    .addComponent(jblIdSP))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateSP))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSoLuongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearSP))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbTrangThai))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Bảng sản phẩm"));

        txtTimKiem.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtTimKiemInputMethodTextChanged(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtTimKiemPropertyChange(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel5.setText("Tìm kiếm:");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID Sản phẩm", "Tên sản phẩm", "Số lượng tổng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm chi tiết"));

        tblSanPhamChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID SPCT", "ID SP", "Tên sản phẩm", "Ngày nhập", "Màu sắc", "Size", "Chất liệu", "Hãng", "Số lượng", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPhamChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamChiTietMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPhamChiTiet);

        cbMatHang.setText("Đã hết");
        cbMatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMatHangActionPerformed(evt);
            }
        });

        jLabel6.setText("Mặt hàng");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(10, 10, 10)
                .addComponent(cbMatHang)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbMatHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết SP"));

        jLabel7.setText("ID:");

        jLabel8.setText("Màu sắc");

        jLabel9.setText("Size");

        jLabel10.setText("Chất liệu");

        jLabel11.setText("Hãng");

        jLabel12.setText("Ngày nhập");

        jLabel13.setText("Số lượng");

        jLabel14.setText("Giá");

        btnUpdateSPCT.setText("Update CTSP");
        btnUpdateSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSPCTActionPerformed(evt);
            }
        });

        btnAddSPCT.setText("Add CTSP");
        btnAddSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSPCTActionPerformed(evt);
            }
        });

        jblNgayNhap.setText("-");

        jblIdSanPhamChitiet.setText("-");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)))
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuongSPCT)
                            .addComponent(jblNgayNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGia, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jblIdSanPhamChitiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbSize, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbChatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnAddSPCT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdateSPCT)
                        .addGap(6, 6, 6)))
                .addGap(70, 70, 70))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jblIdSanPhamChitiet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbbHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jblNgayNhap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtSoLuongSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateSPCT)
                    .addComponent(btnAddSPCT))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60))
        );

        jTabbedPane2.addTab("San Pham ", jPanel7);

        jPanel8.setMaximumSize(new java.awt.Dimension(50000, 50000));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin thuộc tính"));

        buttonGroup1.add(rbnMauSac);
        rbnMauSac.setSelected(true);
        rbnMauSac.setText("Màu Sắc");
        rbnMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnMauSacActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbnSize);
        rbnSize.setText("Size");
        rbnSize.setToolTipText("");
        rbnSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnSizeActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbnChatLieu);
        rbnChatLieu.setText("Chất liệu");
        rbnChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnChatLieuActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbnHang);
        rbnHang.setText("Hãng");
        rbnHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnHangActionPerformed(evt);
            }
        });

        jLabel15.setText("ID thuộc tính:");

        jblIdThuocTinh.setText("-");

        jLabel17.setText("Tên thuộc tính");

        btnAddThuocTinh.setText("Add");
        btnAddThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddThuocTinhActionPerformed(evt);
            }
        });

        btnUpdateThuocTinh.setText("Update");
        btnUpdateThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateThuocTinhActionPerformed(evt);
            }
        });

        btnClearThuocTinh.setText("New");
        btnClearThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearThuocTinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnAddThuocTinh)
                        .addGap(53, 53, 53)
                        .addComponent(btnUpdateThuocTinh)
                        .addGap(55, 55, 55)
                        .addComponent(btnClearThuocTinh))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(30, 30, 30)
                                .addComponent(jblIdThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(rbnMauSac)
                                .addGap(49, 49, 49)
                                .addComponent(rbnSize)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(rbnChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel17)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbnHang, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(580, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbnMauSac)
                    .addComponent(rbnSize)
                    .addComponent(rbnChatLieu)
                    .addComponent(rbnHang))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jblIdThuocTinh)
                    .addComponent(jLabel17)
                    .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddThuocTinh)
                    .addComponent(btnUpdateThuocTinh)
                    .addComponent(btnClearThuocTinh))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách thuộc tính"));

        jLabel16.setText("Tìm kiếm: ");

        txtTimKienThuocTinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKienThuocTinhKeyReleased(evt);
            }
        });

        tblThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Id thuộc tính", "Tên thuộc tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuocTinhMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblThuocTinh);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(txtTimKienThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtTimKienThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Thuoc tinh", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMatHangActionPerformed
        boolean isSelected = this.cbMatHang.isSelected();

        this.loadFormSanPhamChiTiet(isSelected ? "Hết hàng" : "Còn hàng");
    }//GEN-LAST:event_cbMatHangActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int row = this.tblSanPham.getSelectedRow();

        if (row <= -1) {
            JOptionPane.showMessageDialog(this, "Vui long chon dong ban muon chon");
            return;
        }

        String id = this.tblSanPham.getValueAt(row, 1).toString();
        String tenSanPham = this.tblSanPham.getValueAt(row, 2).toString();
        String soLuong = this.tblSanPham.getValueAt(row, 3).toString();
        String trangThai = this.tblSanPham.getValueAt(row, 4).toString();

        this.idSanPham = id;
        this.jblIdSP.setText(id);
        this.txtTenSP.setText(tenSanPham);
        this.txtSoLuongSanPham.setText(soLuong);
        this.cbTrangThai.setSelected(trangThai.equalsIgnoreCase("Đang hoạt động"));
        this.loadFormSanPhamChiTiet(null);

    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void tblSanPhamChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamChiTietMouseClicked
        int row = this.tblSanPhamChiTiet.getSelectedRow();

        if (row <= -1) {
            JOptionPane.showMessageDialog(this, "Vui long chon dong ban muon chon");
            return;
        }

        String id = this.tblSanPhamChiTiet.getValueAt(row, 0).toString();
        String idSP = this.tblSanPhamChiTiet.getValueAt(row, 1).toString();
        String tenSP = this.tblSanPhamChiTiet.getValueAt(row, 2).toString();
        String ngayNhap = this.tblSanPhamChiTiet.getValueAt(row, 3).toString();
        String mauSac = this.tblSanPhamChiTiet.getValueAt(row, 4).toString();
        String size = this.tblSanPhamChiTiet.getValueAt(row, 5).toString();
        String chatLieu = this.tblSanPhamChiTiet.getValueAt(row, 6).toString();
        String hang = this.tblSanPhamChiTiet.getValueAt(row, 7).toString();
        String soLuong = this.tblSanPhamChiTiet.getValueAt(row, 8).toString();
        String gia = this.tblSanPhamChiTiet.getValueAt(row, 9).toString();

        this.jblIdSanPhamChitiet.setText(id);
        this.txtGia.setText(gia);
        this.jblNgayNhap.setText(ngayNhap);
        this.txtSoLuongSPCT.setText(soLuong);

        for (int i = 0; i < cbbMauSac.getItemCount(); i++) {
            if (cbbMauSac.getItemAt(i).equalsIgnoreCase(mauSac)) {
                cbbMauSac.setSelectedIndex(i);
            }
        }

        for (int i = 0; i < cbbSize.getItemCount(); i++) {
            if (cbbSize.getItemAt(i).equalsIgnoreCase(size)) {
                cbbSize.setSelectedIndex(i);
            }
        }

        for (int i = 0; i < cbbChatLieu.getItemCount(); i++) {
            if (cbbChatLieu.getItemAt(i).equalsIgnoreCase(chatLieu)) {
                cbbChatLieu.setSelectedIndex(i);
            }
        }

        for (int i = 0; i < cbbHang.getItemCount(); i++) {
            if (cbbHang.getItemAt(i).equalsIgnoreCase(hang)) {
                cbbHang.setSelectedIndex(i);
            }
        }

    }//GEN-LAST:event_tblSanPhamChiTietMouseClicked

    private void btnClearSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSPActionPerformed
        clearSP();
    }//GEN-LAST:event_btnClearSPActionPerformed

    private void btnAddSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSPActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Ban co chac muon them san pham nay khong?", "Xac nhan",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.NO_OPTION) {
            return;
        }
        SanPham sp = getDataSanPhamByForm();

        if (sp != null) {
            sanPhamService.add(sp);
            loadFormSanPham(null);
            clearSP();
        }
    }//GEN-LAST:event_btnAddSPActionPerformed

    private void btnUpdateSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSPActionPerformed
        int row = this.tblSanPham.getSelectedRow();

        if (row <= -1) {
            JOptionPane.showMessageDialog(this, "Vui long chon san pham truoc khi update");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Ban co chac muon cap nhat san pham nay khong?", "Xac nhan",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.NO_OPTION) {
            return;
        }
        SanPham sp = getDataSanPhamByForm();

        if (sp != null) {
            sanPhamService.update(sp, sp.getId());
            loadFormSanPham(null);
            clearSP();
        }
    }//GEN-LAST:event_btnUpdateSPActionPerformed

    private void btnAddSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSPCTActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Ban co chac muon them san pham chi tiet nay khong?", "Xac nhan",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.NO_OPTION) {
            return;
        }

        SanPhamChiTiet spct = getDataSPCTByForm();

        if (spct.getIdSanPham() == null) {
            JOptionPane.showMessageDialog(this, "Vui long chon san pham muon them truoc khi them san pham chi tiet");
            return;
        }

        this.sanPhamChiTietService.add(spct);
        this.loadFormSanPhamChiTiet(null);
        this.clearSPCT();
        this.clearSP();
    }//GEN-LAST:event_btnAddSPCTActionPerformed

    private void btnUpdateSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSPCTActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Ban co chac muon cap nhat san pham chi tiet nay khong?", "Xac nhan",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.NO_OPTION) {
            return;
        }
        String id = this.jblIdSanPhamChitiet.getText();

        if ("-".equals(id)) {
            JOptionPane.showMessageDialog(this, "Vui long chon san pham chi tiet muon update");
            return;
        }

        SanPhamChiTiet spct = getDataSPCTByForm();
        System.out.println(spct);
        this.sanPhamChiTietService.update(spct, spct.getId());
        this.loadFormSanPhamChiTiet(null);
        this.clearSPCT();
    }//GEN-LAST:event_btnUpdateSPCTActionPerformed

    private void btnAddThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddThuocTinhActionPerformed
        boolean isSelectedColor = this.rbnMauSac.isSelected();
        boolean isSelectedSize = this.rbnSize.isSelected();
        boolean isSelectedMaterial = this.rbnChatLieu.isSelected();
        boolean isSelectedBrand = this.rbnHang.isSelected();

        int confirm = JOptionPane.showConfirmDialog(this, "Ban co chac muon them thuoc tinh nay khong?", "Xac nhan",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.NO_OPTION) {
            return;
        }

        if (isSelectedColor) {
            MauSac ms = new MauSac();
            ms.setTenMau(getNameProperties());
            baseServiceMauSac.add(ms);
        }

        if (isSelectedSize) {
            Size s = new Size();
            s.setTenSize(getNameProperties());
            baseServiceSize.add(s);
        }

        if (isSelectedMaterial) {
            ChatLieu ms = new ChatLieu();
            ms.setTenChatLieu(getNameProperties());
            baseServiceChatLieu.add(ms);
        }

        if (isSelectedBrand) {
            ThuongHieu ms = new ThuongHieu();
            ms.setTenThuongHieu(getNameProperties());
            baseServiceThuongHieu.add(ms);
        }

        this.clearFormProperties();
        loadComboboxMauSac(baseServiceMauSac.findAll(null));
        loadComboboxChatLieu(baseServiceChatLieu.findAll(null));
        loadComboboxHang(baseServiceThuongHieu.findAll(null));
        loadComboboxSize(baseServiceSize.findAll(null));
        this.loadFormProperties(null);
    }//GEN-LAST:event_btnAddThuocTinhActionPerformed

    private void btnUpdateThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateThuocTinhActionPerformed

        boolean isSelectedColor = this.rbnMauSac.isSelected();
        boolean isSelectedSize = this.rbnSize.isSelected();
        boolean isSelectedMaterial = this.rbnChatLieu.isSelected();
        boolean isSelectedBrand = this.rbnHang.isSelected();

        String id = this.jblIdThuocTinh.getText();

        if (id == null || "-".equals(id)) {
            JOptionPane.showMessageDialog(this, "Id khong ton tai");
            return;
        }

        int convertId = Integer.valueOf(id);

        int confirm = JOptionPane.showConfirmDialog(this, "Ban co chac muon update thuoc tinh nay khong?", "Xac nhan",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.NO_OPTION) {
            return;
        }

        if (isSelectedColor) {
            MauSac ms = new MauSac();
            ms.setTenMau(getNameProperties());
            ms.setId(convertId);
            baseServiceMauSac.update(ms, convertId);
        }

        if (isSelectedSize) {
            Size s = new Size();
            s.setTenSize(getNameProperties());
            s.setId(convertId);
            baseServiceSize.update(s, convertId);
        }

        if (isSelectedMaterial) {
            ChatLieu ms = new ChatLieu();
            ms.setTenChatLieu(getNameProperties());
            ms.setId(convertId);
            baseServiceChatLieu.update(ms, convertId);
        }

        if (isSelectedBrand) {
            ThuongHieu ms = new ThuongHieu();
            ms.setTenThuongHieu(getNameProperties());
            ms.setId(convertId);
            baseServiceThuongHieu.update(ms, convertId);
        }

        this.clearFormProperties();
        loadComboboxMauSac(baseServiceMauSac.findAll(null));
        loadComboboxChatLieu(baseServiceChatLieu.findAll(null));
        loadComboboxHang(baseServiceThuongHieu.findAll(null));
        loadComboboxSize(baseServiceSize.findAll(null));
        this.loadFormProperties(null);
    }//GEN-LAST:event_btnUpdateThuocTinhActionPerformed

    private void btnClearThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearThuocTinhActionPerformed
        this.clearFormProperties();
    }//GEN-LAST:event_btnClearThuocTinhActionPerformed

    private void rbnSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnSizeActionPerformed
        this.clearFormProperties();
        this.loadFormProperties(null);
    }//GEN-LAST:event_rbnSizeActionPerformed

    private void rbnChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnChatLieuActionPerformed
        this.clearFormProperties();
        this.loadFormProperties(null);
    }//GEN-LAST:event_rbnChatLieuActionPerformed

    private void rbnHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnHangActionPerformed
        this.clearFormProperties();
        this.loadFormProperties(null);
    }//GEN-LAST:event_rbnHangActionPerformed

    private void tblThuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuocTinhMouseClicked

        int row = this.tblThuocTinh.getSelectedRow();

        if (row <= -1) {
            JOptionPane.showMessageDialog(this, "Vui long chon dong ban muon chon");
            return;
        }

        String id = this.tblThuocTinh.getValueAt(row, 1).toString();
        String name = this.tblThuocTinh.getValueAt(row, 2).toString();

        this.jblIdThuocTinh.setText(id);
        this.txtTenThuocTinh.setText(name);

    }//GEN-LAST:event_tblThuocTinhMouseClicked

    private void rbnMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnMauSacActionPerformed

        this.clearFormProperties();
        this.loadFormProperties(null);
    }//GEN-LAST:event_rbnMauSacActionPerformed

    private void txtTimKiemInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtTimKiemInputMethodTextChanged
        String searchName = this.txtTimKiem.getText();
        this.loadFormSanPham(searchName);
    }//GEN-LAST:event_txtTimKiemInputMethodTextChanged

    private void txtTimKiemPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtTimKiemPropertyChange
        String searchName = this.txtTimKiem.getText();
        System.out.println(searchName);
    }//GEN-LAST:event_txtTimKiemPropertyChange

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        String searchName = this.txtTimKiem.getText();
        this.loadFormSanPham(searchName);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtTimKienThuocTinhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKienThuocTinhKeyReleased
        String searchName = this.txtTimKienThuocTinh.getText();
        this.loadFormProperties(searchName);
    }//GEN-LAST:event_txtTimKienThuocTinhKeyReleased

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

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
            java.util.logging.Logger.getLogger(SanPhamJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPhamJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPhamJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPhamJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SanPhamJframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSP;
    private javax.swing.JButton btnAddSPCT;
    private javax.swing.JButton btnAddThuocTinh;
    private javax.swing.JButton btnClearSP;
    private javax.swing.JButton btnClearThuocTinh;
    private javax.swing.JButton btnUpdateSP;
    private javax.swing.JButton btnUpdateSPCT;
    private javax.swing.JButton btnUpdateThuocTinh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbMatHang;
    private javax.swing.JCheckBox cbTrangThai;
    private javax.swing.JComboBox<String> cbbChatLieu;
    private javax.swing.JComboBox<String> cbbHang;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbSize;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel jblIdSP;
    private javax.swing.JLabel jblIdSanPhamChitiet;
    private javax.swing.JLabel jblIdThuocTinh;
    private javax.swing.JLabel jblNgayNhap;
    private javax.swing.JRadioButton rbnChatLieu;
    private javax.swing.JRadioButton rbnHang;
    private javax.swing.JRadioButton rbnMauSac;
    private javax.swing.JRadioButton rbnSize;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblSanPhamChiTiet;
    private javax.swing.JTable tblThuocTinh;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtSoLuongSPCT;
    private javax.swing.JTextField txtSoLuongSanPham;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTenThuocTinh;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKienThuocTinh;
    // End of variables declaration//GEN-END:variables
}
