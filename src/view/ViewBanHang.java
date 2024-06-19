/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Model.ChatLieu;
import Model.KhachHang;
import Model.MauSac;
import Model.SanPham;
import Model.SanPhamChiTiet;
import Model.Size;
import Model.ThuongHieu;
import Service.KhachHangService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HDCT;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.HoaDonChiTietViewModel;
import model.NhanVien;
import model.SanPhamChiTietViewBanHang;
import model.Vouchermode;
import service.BanHangService;
import service.BaseService;
import service.HoaDonChiTietService;
import service.NhanVienService;
import service.QuanLyVoucher;
import service.SanPhamChiTietService;
import service.impl.ChatLieuServiceImpl;
import service.impl.MauSacServiceImpl;
import service.impl.NhanVienServiceImpl;
import service.impl.SanPhamChiTietServiceImpl;
import service.impl.SanPhamServiceImpl;
import service.impl.SizeServiceImpl;
import service.impl.ThuongHieuServiceImpl;

/**
 *
 * @author thaitv
 */
public class ViewBanHang extends javax.swing.JFrame {

    private BanHangService banHangService = new BanHangService();
    private QuanLyVoucher quanLyVoucher = new QuanLyVoucher();
    private DefaultTableModel defaultTableModel;
    private SanPhamChiTietService sanPhamChiTietService = new SanPhamChiTietServiceImpl();
    private BaseService<SanPhamChiTiet> baseSanPhamChiTietService = new SanPhamChiTietServiceImpl();
    private BaseService<MauSac> baseMauSacService = new MauSacServiceImpl();
    private BaseService<Size> baseSizeService = new SizeServiceImpl();
    private BaseService<ThuongHieu> baseThuongHieuService = new ThuongHieuServiceImpl();
    private BaseService<ChatLieu> baseChatLieuService = new ChatLieuServiceImpl();
    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();
    private BaseService<SanPham> baseSanPhamService = new SanPhamServiceImpl();
    private KhachHangService khachHangService = new KhachHangService();
    private NhanVienService nhanVienService = new NhanVienServiceImpl();
    private DecimalFormat df = new DecimalFormat(",###");
    private Boolean isGetVoucher = Boolean.FALSE;

    /**
     * Creates new form ViewBanHang
     */
    public ViewBanHang(String layidNhanVien) {
        initComponents();
        btnInhoaDon.setEnabled(false);
        txtLayIDNhanVien.setText(layidNhanVien);
        loadcboVoucher();
        loadSanPham(banHangService.getListProduct(null));
        loadHoaDon();
        loadCbbNv();
        loadCvvKh();
        disableBtnThanhToan();
    }

    public ViewBanHang() {
        this.loadSanPham(banHangService.getListProduct(null));
    }

    private void disableBtnThanhToan() {
        String tienKhachDua = this.txtTienKhachDua.getText();

        if (tienKhachDua == null || "".equals(tienKhachDua)) {
            this.btnThanhToan.setEnabled(false);
        }
    }

    void tongTien() {
        Integer idHoaDon = Integer.parseInt(txtIDHoaDon.getText());
        int tongTien = 0;
        for (HoaDonChiTiet gioHang : banHangService.getListShoppingCart(idHoaDon)) {
//            tongTien += gioHang.getTongTien();
        }
        String a = cboVoucher.getSelectedItem().toString();
        for (Vouchermode voucher : quanLyVoucher.getAllVouchers()) {
            if (voucher.getTenVoucher().equals(a)) {
                tongTien -= Float.valueOf(voucher.getGiatri().intValue());
                break;
            }
        }

        NhanVien nv = getNhanVienByCBB();

        for (Vouchermode vc : banHangService.listVoucherClient(nv.getId())) {
            if (vc.getTenVoucher().equals(a)) {
                tongTien -= Float.valueOf(vc.getGiatri().intValue());
                break;
            }
        }
        jblTotalMoney.setText(String.valueOf(tongTien));
        txtTienKhachDua.setText("");
        jblSoTienThua.setText("");
    }

    private void displayTotalMoney(Integer idHoaDon) {
        List<HoaDonChiTiet> data = banHangService.getListShoppingCart(idHoaDon);

        if (data.isEmpty()) {
            jblTotalMoney.setText("-");
            jblSoTienGiam.setText("-");
            jblSoTienSauKhiGiam.setText("-");
            return;
        }

        double totalMoney = 0d;
        for (HoaDonChiTiet hdct : data) {
            totalMoney += hdct.getGia() * hdct.getSoLuong();
        }

        jblTotalMoney.setText(String.valueOf(totalMoney));
    }

    private void enableBtnThanhToan() {
        this.btnThanhToan.setEnabled(true);
    }

//    private ViewBanHang(){
//        
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbbNhanVien = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnTaoHoaDon = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnDeleteAllInCart = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtSearchSanPham = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        cboVoucher = new javax.swing.JComboBox<>();
        txtTienKhachDua = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        btnInhoaDon = new javax.swing.JButton();
        txtIDHoaDon = new javax.swing.JLabel();
        jblTotalMoney = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jblSoTienGiam = new javax.swing.JLabel();
        jblSoTienThua = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jblSoTienSauKhiGiam = new javax.swing.JLabel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        txtLayIDNhanVien = new javax.swing.JTextField();
        txtSearchCustomer = new javax.swing.JTextField();

        cbbNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNhanVienActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hoá đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 14))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "ID Hóa đơn", "Ngày tạo", "ID Nhân viên", "Trạng thái"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        btnTaoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuy.setText("Hủy hóa đơn");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTaoHoaDon)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnTaoHoaDon)
                        .addGap(39, 39, 39)
                        .addComponent(btnHuy)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Id sản phẩm chi tiết", "Id sản phẩm", "Tên sản phẩm", "Số lượng", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblGioHangMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(tblGioHang);

        btnDeleteAllInCart.setText("Xóa toàn bộ sản phẩm");
        btnDeleteAllInCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAllInCartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteAllInCart, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteAllInCart, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm\n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 1, 18))); // NOI18N

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Id sản phẩm chi tiết", "Id Sản phẩm", "Tên sản phẩm", "Màu sắc", "Size", "Chất liệu", "Thương hiệu", "Số lượng", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        txtSearchSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchSanPhamKeyReleased(evt);
            }
        });

        jLabel12.setText("Tìm kiếm sản phẩm theo tên:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1044, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel12)
                        .addGap(27, 27, 27)
                        .addComponent(txtSearchSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng điều khiển", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N

        jLabel1.setText("ID Hoá đơn:");

        jLabel2.setText("Ngày tạo:");

        jLabel3.setText("ID Nhân viên:");

        jLabel4.setText("ID Khách hàng:");

        jLabel5.setText("Voucher:");

        jLabel6.setText("Tổng tiền:");

        jLabel7.setText("Tiền khách đưa:");

        jLabel8.setText("Tiền trả lại:");

        cboVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboVoucherActionPerformed(evt);
            }
        });
        cboVoucher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboVoucherKeyPressed(evt);
            }
        });

        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        btnThanhToan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnInhoaDon.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnInhoaDon.setText("In hoá đơn");
        btnInhoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInhoaDonActionPerformed(evt);
            }
        });

        jblTotalMoney.setText("-");
        jblTotalMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jblTotalMoneyKeyReleased(evt);
            }
        });

        jLabel9.setText("Số tiền giảm");

        jLabel10.setText("Số tiền giảm:");

        jblSoTienGiam.setText("-");

        jblSoTienThua.setText("-");

        jLabel11.setText("Số tiền sau khi giảm");

        jblSoTienSauKhiGiam.setText("-");
        jblSoTienSauKhiGiam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jblSoTienSauKhiGiamKeyReleased(evt);
            }
        });

        cbbKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhachHangActionPerformed(evt);
            }
        });

        txtSearchCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchCustomerKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInhoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jblSoTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtTienKhachDua)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayTao)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtIDHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14))
                                    .addComponent(cboVoucher, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtLayIDNhanVien)
                            .addComponent(jblSoTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblTotalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jblSoTienSauKhiGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtIDHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLayIDNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jblSoTienGiam))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jblTotalMoney))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jblSoTienSauKhiGiam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jblSoTienThua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInhoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        int idNhanVien = Integer.parseInt(txtLayIDNhanVien.getText());
        HoaDon hd = new HoaDon();
        hd.setNgayTao(java.sql.Date.valueOf(LocalDate.now()));
        hd.setId(idNhanVien);
        hd.setTrangThai("Chờ thanh toán");

        banHangService.createHoaDon(hd);
        loadHoaDon();
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        try {
            int index = tblGioHang.getSelectedRow();
            int idHoaDon = Integer.parseInt(txtIDHoaDon.getText());
            String idSanPham = String.valueOf(tblGioHang.getValueAt(index, 2).toString());
            String idSPCT = tblGioHang.getValueAt(index, 1).toString();
            String soLuongGioHang = tblGioHang.getValueAt(index, 4).toString();

            String soLuongUpdate = JOptionPane.showInputDialog(this, "Mời nhập lại số lượng");
            if (soLuongUpdate == null || "".equals(soLuongUpdate)) {
                return;
            }

            int soLuongConLai = Integer.valueOf(soLuongGioHang) - Integer.valueOf(soLuongUpdate);
            int idSanPhamConvert = Integer.valueOf(idSanPham);
            int idSPCTConvert = Integer.valueOf(idSPCT);
            SanPham sp = baseSanPhamService.getOne(idSanPhamConvert);
            if (soLuongConLai < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng trong giỏ hàng không đủ, vui lòng nhập lại");
                return;
            } else if (Integer.valueOf(soLuongConLai) == 0) {
                System.out.println("delete product");
                banHangService.xoaGioHang(idSPCT, idHoaDon);
                banHangService.suaSanPham(sp.getSoLuong() + Integer.valueOf(soLuongUpdate) + "", idSanPhamConvert, idSPCTConvert);
                sanPhamChiTietService.updateTrangThaiSanPham(idSanPhamConvert, "Còn hàng");
            } else {
                int idHDCT = hoaDonChiTietService
                        .findIdHDCTByIdSanPhamChiTietAndIdHoaDon(idHoaDon, idSPCTConvert);
                banHangService.updateGioHang(soLuongConLai, idHDCT);
                banHangService.suaSanPham(sp.getSoLuong() + soLuongConLai + "", idSanPhamConvert, idSPCTConvert);
            }
            loadGioHang(idHoaDon);
            loadSanPham(banHangService.getListProduct(null));
            displayTotalMoney(idHoaDon);
            loadcboVoucher();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int index = tblHoaDon.getSelectedRow();
        defaultTableModel = (DefaultTableModel) tblHoaDon.getModel();

        loadGioHang(Integer.parseInt(tblHoaDon.getValueAt(index, 1).toString()));
        txtIDHoaDon.setText(tblHoaDon.getValueAt(index, 1).toString());
//        txtIdNhanVien.setText(tblHoaDon.getValueAt(index, 3).toString());
        txtNgayTao.setText(tblHoaDon.getValueAt(index, 2).toString());
        tongTien();
        displayTotalMoney(Integer.parseInt(tblHoaDon.getValueAt(index, 1).toString()));

    }//GEN-LAST:event_tblHoaDonMouseClicked

    int checkProduct() {
        if (txtIDHoaDon.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mời chọn hóa đơn !");
            return 2;
        }
        return 3;
    }
    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        if (checkProduct() == 2) {
            return;
        }
        try {
            int mouseClicked = tblSanPham.getSelectedRow();
            defaultTableModel = (DefaultTableModel) tblSanPham.getModel();
            String soLuongSanPhamCanMua = JOptionPane.showInputDialog(this, "Mời nhập số lượng cần mua:");
            Integer idSanPham = (Integer) tblSanPham.getValueAt(mouseClicked, 2);
            Integer soLuongSanPhamHienCo = (Integer) tblSanPham.getValueAt(mouseClicked, 8);
            Integer giaHienTai = (Integer) tblSanPham.getValueAt(mouseClicked, 9);
            String tenMauSac = tblSanPham.getValueAt(mouseClicked, 4).toString();
            String tenSize = tblSanPham.getValueAt(mouseClicked, 5).toString();
            String tenChatLieu = tblSanPham.getValueAt(mouseClicked, 6).toString();
            String tenThuongHieu = tblSanPham.getValueAt(mouseClicked, 7).toString();

            Integer soLuongSauKhiMua = Integer.valueOf(soLuongSanPhamHienCo) - Integer.valueOf(soLuongSanPhamCanMua);
            
            System.out.println("soLuongSauKhiMua: " + soLuongSauKhiMua);
            if (soLuongSauKhiMua == 0) {
                System.out.println("1");
                sanPhamChiTietService.updateTrangThaiSanPham(idSanPham, "Hết hàng");
            }
            
            if (soLuongSauKhiMua < 0 || Integer.valueOf(soLuongSanPhamCanMua) <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");
                return;
            }

            MauSac mauSac = baseMauSacService.findEntityByName(tenMauSac);
            Size size = baseSizeService.findEntityByName(tenSize);
            ThuongHieu thuongHieu = baseThuongHieuService.findEntityByName(tenThuongHieu);
            ChatLieu chatLieu = baseChatLieuService.findEntityByName(tenChatLieu);
            if (mauSac == null) {
                JOptionPane.showMessageDialog(this, "Màu sắc không hợp lệ");
                return;
            }

            if (size == null) {
                JOptionPane.showMessageDialog(this, "Kích cỡ không hợp lệ");
                return;
            }

            if (thuongHieu == null) {
                JOptionPane.showMessageDialog(this, "Thương hiệu không hợp lệ");
                return;
            }

            if (chatLieu == null) {
                JOptionPane.showMessageDialog(this, "Chất liệu không hợp lệ");
                return;
            }
            int idHoaDon = Integer.parseInt(txtIDHoaDon.getText());
            Integer idSPCT = sanPhamChiTietService
                    .findSPCTByMauSacAndChatLieuAndSizeAndThuongHieuAndSanPham(idSanPham,
                            mauSac.getId(), size.getId(), chatLieu.getId(), thuongHieu.getId());
            Integer idHDCT = hoaDonChiTietService.findIdHDCTByIdSanPhamChiTietAndIdHoaDon(idHoaDon, idSPCT);

            boolean isUpdated = Boolean.TRUE;
            for (HoaDonChiTiet gioHang : banHangService.getListShoppingCart(idHoaDon)) {
                System.out.println(idSPCT + " - " + gioHang.getIdSPCT());
                if (idSPCT.equals(gioHang.getIdSPCT())) {
                    Integer totalQuantityInCart = Integer.valueOf(soLuongSanPhamCanMua) + Integer.valueOf(gioHang.getSoLuong());
                    banHangService.updateGioHang(totalQuantityInCart, idHDCT);
                    isUpdated = Boolean.FALSE;
                }
            }

            if (isUpdated) {
                HoaDonChiTietViewModel hdct = new HoaDonChiTietViewModel(idSPCT, idHoaDon, giaHienTai, Integer.valueOf(soLuongSanPhamCanMua), null, null, null, null, null);
                banHangService.addGioHang(hdct);
            }

            loadGioHang(idHoaDon);
            String soLuongSauKhiMuaStr = soLuongSauKhiMua.toString();
            banHangService.suaSanPham(soLuongSauKhiMuaStr, idSanPham, idSPCT);
            loadSanPham(banHangService.getListProduct(null));
            displayTotalMoney(idHoaDon);
            this.cboVoucher.setSelectedIndex(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        int i = tblHoaDon.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Mời chọn hóa đơn cần hủy");
            return;
        }
        Integer id = (Integer) tblHoaDon.getValueAt(i, 1);
        // String trangThai = "Đã thanh toán";
        if (checkHuy(id) == 1) {
            return;
        }
        Boolean checkHuyHD = banHangService.huyHoaDon(id);
        if (checkHuyHD) {
            JOptionPane.showMessageDialog(this, "Huỷ thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Huỷ thất bại");

        }
        loadHoaDon();
        loadGioHang(id);
        tongTien();

    }//GEN-LAST:event_btnHuyActionPerformed

    int checkThanhToan() {
        try {
            long soTienThua = df.parse(jblSoTienThua.getText()).longValue();
            if (txtIDHoaDon.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Mời chọn hóa đơn");
                return 0;
            } else if (txtTienKhachDua.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Chưa có tiền khách đưa");
                return 0;
            } else if (soTienThua < 0) {
                JOptionPane.showMessageDialog(this, "Tiền khách đưa chưa đủ");
                return 0;
            }
            return 1;
        } catch (ParseException ex) {
            return 0;
        }

    }
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (checkThanhToan() == 0) {
            return;
        }
//        String idNV = this.txtIdNhanVien.getText();
        String tongTienCanTra = this.jblTotalMoney.getText();
        String tienKhachDua = this.txtTienKhachDua.getText();
        String giamGia = this.jblSoTienGiam.getText();
        String idHoaDon = this.txtIDHoaDon.getText();

        Integer idVoucher = null;
        List<Vouchermode> voucherList = quanLyVoucher.getAllVouchers();
        int indexVoucher = cboVoucher.getSelectedIndex();
        System.out.println("index: " + indexVoucher);
        if (indexVoucher != 0) {
            for (int i = 0; i < voucherList.size(); i++) {
                if (voucherList.get(i).equals(voucherList.get(indexVoucher - 1))) {
                    idVoucher = voucherList.get(i).getId();
                    break;
                }
            }

        }

        KhachHang khachHang = getKhachHangCBB();
        if (khachHang == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng");
            return;
        }

        NhanVien nv = getNhanVienByCBB();
        if (nv == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên");
            return;
        }

        double tongTienCanTraConvert = 0;
        double giamGiaConvert = 0;
        double tienKhachDuaConvert = 0d;
        try {
            tienKhachDuaConvert = Double.valueOf(tienKhachDua);
            tongTienCanTraConvert = Double.valueOf(tongTienCanTra);
            giamGiaConvert = Double.valueOf(giamGia);
        } catch (NumberFormatException ex) {
            if ("-".equals(tienKhachDua)) {
                tienKhachDuaConvert = 0;
            }

            if ("-".equals(tongTienCanTra)) {
                tongTienCanTraConvert = 0;
            }

            if ("-".equals(giamGia)) {
                giamGiaConvert = 0;
            }

        }
        double tienThuaConvert = tienKhachDuaConvert + giamGiaConvert - tongTienCanTraConvert;
        Double thanhTien = tongTienCanTraConvert - giamGiaConvert;
        System.out.println("hoaDon: " + idHoaDon);
        HoaDon hoaDon = new HoaDon();
        hoaDon.setId(Integer.parseInt(idHoaDon));
        hoaDon.setIdVoucher(Objects.isNull(idVoucher) ? null : idVoucher);
        hoaDon.setNgayTao(java.sql.Date.valueOf(LocalDate.now()));
        hoaDon.setIdKH(khachHang.getId());
        hoaDon.setIdNV(nv.getId());
        hoaDon.setTongTien(tongTienCanTraConvert);
        hoaDon.setTienThua(tienThuaConvert);
        hoaDon.setThanhTien(thanhTien);

        hoaDon.setGiamGia(giamGiaConvert);
        hoaDon.setTienKhachDua(tienKhachDuaConvert);
        if (banHangService.ThanhToan(hoaDon)) {
            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
            defaultTableModel = (DefaultTableModel) this.tblGioHang.getModel();
            defaultTableModel.setRowCount(0);
            loadGioHang(-1);
            this.txtIDHoaDon.setText("");
            this.jblSoTienGiam.setText("-");
            this.jblSoTienSauKhiGiam.setText("-");
            this.jblSoTienThua.setText("-");
            this.jblTotalMoney.setText("-");
            this.txtTienKhachDua.setText("");
            this.btnThanhToan.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Thanh toán thất bại");
        }
        loadHoaDon();
//        loadGioHang(Integer.parseInt(txtIDHoaDon.getText()));
        btnInhoaDon.setEnabled(true);
        loadcboVoucher();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void tblGioHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblGioHangMouseEntered

    private void tblSanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanPhamMouseEntered

    private void btnDeleteAllInCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAllInCartActionPerformed
        String idHoaDon = this.txtIDHoaDon.getText();

        if ("".equals(idHoaDon) || idHoaDon == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn");
            return;
        }

        int idHoaDonConvert = Integer.valueOf(idHoaDon);
        List<HoaDonChiTiet> data = banHangService.getListShoppingCart(idHoaDonConvert);

        if (data.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa có sản phẩm nào");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn xóa toàn bộ sản phẩm có trong giỏ hàng không?",
                "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            for (HoaDonChiTiet hdct : data) {
                System.out.println(hdct);
                SanPham sp = baseSanPhamService.getOne(hdct.getIdSanPham());
                banHangService.suaSanPham(sp.getSoLuong() + hdct.getSoLuong() + "",
                        hdct.getIdSanPham(), hdct.getIdSPCT());
                System.out.println(sp);
            }

            banHangService.deleteSanPhamInCart(true, idHoaDonConvert, null);
            loadGioHang(idHoaDonConvert);
            loadSanPham(banHangService.getListProduct(null));
            displayTotalMoney(idHoaDonConvert);
            loadcboVoucher();
        }

    }//GEN-LAST:event_btnDeleteAllInCartActionPerformed

    private void cboVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboVoucherActionPerformed
        int index = cboVoucher.getSelectedIndex();

        if (index == 0) {
            String tongTienString = this.jblTotalMoney.getText();
            String tienKhachDua = this.txtTienKhachDua.getText();
            
            if (!tongTienString.equals(tienKhachDua)) {
                this.btnThanhToan.setEnabled(false);
            }
                
            this.jblSoTienGiam.setText("-");
            this.jblSoTienSauKhiGiam.setText("-");
            
            return;
        }

        int row = this.tblHoaDon.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
            return;
        }

        Vouchermode vm = getVoucher(index);
        System.out.println(vm);
        if (vm == null && isGetVoucher) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy mã giảm giá");
            this.jblSoTienGiam.setText("-");
            return;
        }
        String totalMoney = this.jblTotalMoney.getText();

        if ("-".equals(totalMoney) || totalMoney == null) {
            return;
        }

        Double totalMoneyConvert;
        try {
            totalMoneyConvert = Double.parseDouble(totalMoney);
            Vouchermode vmById = quanLyVoucher.getVoucherById(vm.getId(), totalMoneyConvert);
            if (vmById == null) {
                JOptionPane.showMessageDialog(this, "Không đủ điều kiện tham gia chương trình");
                return;
            }

            System.out.println(totalMoneyConvert);
            System.out.println(Double.valueOf(String.valueOf(vmById.getGiatri())));
            double totalCurrent = totalMoneyConvert - Double.valueOf(String.valueOf(vmById.getGiatri()));
            this.jblSoTienSauKhiGiam.setText(totalCurrent + "");
            this.jblTotalMoney.setText(totalMoney);
            this.jblSoTienGiam.setText(String.valueOf(vmById.getGiatri()));
        } catch (NumberFormatException ex) {
            Logger.getLogger(ViewBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cboVoucherActionPerformed

    private void jblTotalMoneyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jblTotalMoneyKeyReleased
        // TODO add your handling code here:
        System.out.println("a");
    }//GEN-LAST:event_jblTotalMoneyKeyReleased

    private void jblSoTienSauKhiGiamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jblSoTienSauKhiGiamKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jblSoTienSauKhiGiamKeyReleased

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        String tienSauGiam = this.jblSoTienSauKhiGiam.getText();
        String tienKhachTra = this.txtTienKhachDua.getText();

        if (tienKhachTra == null || "".equals(tienSauGiam)) {
            return;
        }

        if ("-".equals(tienSauGiam) || tienSauGiam == null) {
            tienSauGiam = this.jblTotalMoney.getText();
        }

        if ("-".equals(tienSauGiam) || tienSauGiam == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn và sản phẩm");
            this.txtTienKhachDua.setText("");
            return;
        }

        try {
            double tienSauGiamConvert = Double.valueOf(tienSauGiam);
            double tienKhachTraConvert = Double.valueOf(tienKhachTra);
            double moneyPay = tienKhachTraConvert - tienSauGiamConvert;
            if (moneyPay == 0) {
                this.enableBtnThanhToan();
                this.jblSoTienThua.setText(0 + "");
            } else if (moneyPay < 0) {
                this.btnThanhToan.setEnabled(false);
                this.jblSoTienThua.setText(moneyPay + "");
            } else {
                this.enableBtnThanhToan();
                this.jblSoTienThua.setText(moneyPay + "");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Sai định dạng, vui lòng nhập chữ số");
            e.printStackTrace();
            return;
        }
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void cbbKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhachHangActionPerformed

    private void cbbNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNhanVienActionPerformed

    private void btnInhoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInhoaDonActionPerformed
        String path = "E://";
        Document document = new Document(); // Import tu lib de khoi tao hoa don
        try {
            PdfWriter.getInstance(document, new FileOutputStream(path + "Bill.pdf"));
            document.open(); // Open connect de set nhung value 
            document.add(new Paragraph("CỬA HÀNG BÁN ÁO T_SHIRT - DIORY STORE"));
            document.add(new Paragraph("ID Bill: " + txtIDHoaDon.getText()));
            document.add(new Paragraph("Địa chỉ: Phố Kiều Mai, Q.Bắc Từ Liêm, Hà Nội"));
            document.add(new Paragraph("SĐT: 0987.654.321"));
            document.add(new Paragraph(""));
            document.add(new Paragraph("Ngày tạo: " + txtNgayTao.getText()));
            document.add(new Paragraph("Id Nhân viên: " + txtLayIDNhanVien.getText()));
            document.add(new Paragraph("Id Khách hàng: " + cbbKhachHang.getSelectedItem().toString()));
            document.add(new Paragraph("Tổng tiền: " + jblTotalMoney.getText()));
            document.add(new Paragraph("Giá giảm: " + jblSoTienGiam.getText()));
            document.add(new Paragraph("Thành tiền: " + jblSoTienSauKhiGiam.getText()));
            document.add(new Paragraph("Tiền khách đưa: " + txtTienKhachDua.getText()));
            document.add(new Paragraph("Tiền trả lại: " + jblSoTienThua.getText()));
            document.add(new Paragraph(""));
            document.add(new Paragraph("Hàng mua rồi được đổi trả trong 3 ngày, nguyên vẹn tag mác"));
            document.add(new Paragraph("Cảm ơn quý khách !"));
            document.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "In thất bại !");
            return;
        }
        JOptionPane.showMessageDialog(this, "In thành công !");
//        txtIDHoaDon.setText("");
//        txtNgayTao.setText("");
//        txtLayIDNhanVien.setText("");
//        cbbKhachHang.getSelectedItem();
//        txtTienKhachDua.setText("");
    }//GEN-LAST:event_btnInhoaDonActionPerformed

    private void cboVoucherKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboVoucherKeyPressed

    }//GEN-LAST:event_cboVoucherKeyPressed

    private void txtSearchSanPhamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchSanPhamKeyReleased
        String tenSanPham = this.txtSearchSanPham.getText();

        loadSanPham(banHangService.getListProduct("".equals(tenSanPham) ? null : tenSanPham));
    }//GEN-LAST:event_txtSearchSanPhamKeyReleased

    private void txtSearchCustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchCustomerKeyReleased
        String searchId = this.txtSearchCustomer.getText();
        
        if (null == searchId || "".equals(searchId)) {
            return;
        }
        
        List<KhachHang> data = khachHangService.getAllKhachhang();
        int index = -1;
        for(int i = 0; i < data.size(); i++) {
            if(String.valueOf(data.get(i).getId()).equals(searchId)) {
                index = i;
            }
        }
        
        this.cbbKhachHang.setSelectedIndex(index);
        
    }//GEN-LAST:event_txtSearchCustomerKeyReleased

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
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteAllInCart;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnInhoaDon;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JComboBox<String> cbbNhanVien;
    private javax.swing.JComboBox<String> cboVoucher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jblSoTienGiam;
    private javax.swing.JLabel jblSoTienSauKhiGiam;
    private javax.swing.JLabel jblSoTienThua;
    private javax.swing.JLabel jblTotalMoney;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JLabel txtIDHoaDon;
    private javax.swing.JTextField txtLayIDNhanVien;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSearchCustomer;
    private javax.swing.JTextField txtSearchSanPham;
    private javax.swing.JTextField txtTienKhachDua;
    // End of variables declaration//GEN-END:variables

    public void loadSanPham(List<SanPhamChiTietViewBanHang> list) {
        defaultTableModel = (DefaultTableModel) this.tblSanPham.getModel();
        defaultTableModel.setRowCount(0);
        int i = 1;

        for (SanPhamChiTietViewBanHang sp : list) {
            defaultTableModel.addRow(new Object[]{
                i++, sp.getIdSPCT(), sp.getIdSanPham(), sp.getTenSanPham(), sp.getMau(), sp.getSize(),
                sp.getChatLieu(), sp.getThuongHieu(), sp.getSoLuong(), sp.getGia()
            });
        }
    }

    public void loadcboVoucher() {
        this.cboVoucher.removeAllItems();
        this.cboVoucher.addItem("----Mời chọn-----");
        for (Vouchermode voucher : quanLyVoucher.getAllVouchers()) {
            this.cboVoucher.addItem(voucher.getTenVoucher());
        }
    }

    private Vouchermode getVoucher(int index) {
        System.out.println(index);
        if (index == -1) {
            return null;
        }

        List<Vouchermode> data = quanLyVoucher.getAllVouchers();
        System.out.println(data.size());
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(data.get(index - 1))) {
                return data.get(i);
            }
        }
        return null;
    }

    private void loadHoaDon() {
        defaultTableModel = (DefaultTableModel) tblHoaDon.getModel();
        defaultTableModel.setRowCount(0);
        int index = 1;

        for (HoaDon hd : banHangService.listHoaDon()) {
            if (hd.getTrangThai().equals("Chờ thanh toán")) {
                defaultTableModel.addRow(new Object[]{
                    index++,
                    hd.getId(),
                    hd.getNgayTao(),
                    txtLayIDNhanVien.getText(),
                    hd.getTrangThai()
                });
            }
        }
    }

    void loadGioHang(int idHoaDon) {
        defaultTableModel = (DefaultTableModel) tblGioHang.getModel();
        defaultTableModel.setRowCount(0);
        int number = 1;

        for (HoaDonChiTiet hdct : banHangService.getListShoppingCart(idHoaDon)) {
            defaultTableModel.addRow(new Object[]{
                number++, hdct.getIdSPCT(), hdct.getIdSanPham(), hdct.getTenSP(),
                hdct.getSoLuong(), df.format(hdct.getSoLuong() * hdct.getGia())
            });
        }
    }

    private void loadCbbNv() {
        cbbNhanVien.removeAllItems();
        List<NhanVien> nhanVienList = nhanVienService.getAll();
        for (NhanVien nv : nhanVienList) {
            cbbNhanVien.addItem(nv.getHoTen());
        }
    }

    private void loadCvvKh() {
        cbbKhachHang.removeAllItems();
        List<KhachHang> khachHangList = khachHangService.getAllKhachhang();
        for (KhachHang nv : khachHangList) {
            cbbKhachHang.addItem(nv.getHoTen() + " - " + nv.getId());
        }
    }

    private NhanVien getNhanVienByCBB() {
        int index = this.cbbNhanVien.getSelectedIndex();
        List<NhanVien> nhanVienList = nhanVienService.getAll();
        for (int i = 0; i < nhanVienList.size(); i++) {
            if (nhanVienList.get(i).equals(nhanVienList.get(index))) {
                return nhanVienList.get(i);
            }
        }

        return null;
    }

    private KhachHang getKhachHangCBB() {
        int index = this.cbbKhachHang.getSelectedIndex();
        List<KhachHang> khachHangList = khachHangService.getAllKhachhang();
        for (int i = 0; i < khachHangList.size(); i++) {
            if (khachHangList.get(i).equals(khachHangList.get(index))) {
                return khachHangList.get(i);
            }
        }

        return null;
    }

    int checkHuy(int idHoaDon) {
        ArrayList<HoaDonChiTiet> list = banHangService.getListShoppingCart(idHoaDon);
        for (HoaDonChiTiet g : list) {
            if (list.size() > 0) {
                JOptionPane.showMessageDialog(this, "Mời bỏ hết sản phẩm ra giỏ hàng");
                return 1;
            }
        }

        return 2;
    }
}
