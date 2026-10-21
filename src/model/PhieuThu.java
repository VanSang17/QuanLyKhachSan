package model;

import enums.HinhThucThanhToan;
import enums.LoaiPhieuThu;

import java.time.LocalDate;

public final class PhieuThu {
    private final String soPhieuThu;            // khóa chính
    private final LocalDate ngayThu;
    private final String hoTenNguoiNop;
    private final double soTien;
    private final LoaiPhieuThu loaiPhieu;
    private final HinhThucThanhToan hinhThuc;
    private final DatPhong datPhong;            // khóa ngoài
    private final NhanVien nhanVien;            // người lập

    public PhieuThu(String soPhieuThu, LocalDate ngayThu, String hoTenNguoiNop,
                    double soTien, LoaiPhieuThu loaiPhieu, HinhThucThanhToan hinhThuc,
                    DatPhong datPhong, NhanVien nhanVien) {
        this.soPhieuThu = KiemTra.chuoiKhongRong(soPhieuThu, "soPhieuThu");
        this.ngayThu = KiemTra.khongNull(ngayThu, "ngayThu");
        this.hoTenNguoiNop = KiemTra.chuoiKhongRong(hoTenNguoiNop, "hoTenNguoiNop");
        if (soTien <= 0)
            throw new IllegalArgumentException("soTien phải > 0");
        this.soTien = soTien;
        this.loaiPhieu = KiemTra.khongNull(loaiPhieu, "loaiPhieu");
        this.hinhThuc = KiemTra.khongNull(hinhThuc, "hinhThuc");
        this.datPhong = KiemTra.khongNull(datPhong, "datPhong");
        this.nhanVien = KiemTra.khongNull(nhanVien, "nhanVien");
    }

    public String getSoPhieuThu() { return soPhieuThu; }
    public LocalDate getNgayThu() { return ngayThu; }
    public String getHoTenNguoiNop() { return hoTenNguoiNop; }
    public double getSoTien() { return soTien; }
    public LoaiPhieuThu getLoaiPhieu() { return loaiPhieu; }
    public HinhThucThanhToan getHinhThuc() { return hinhThuc; }
    public DatPhong getDatPhong() { return datPhong; }
    public NhanVien getNhanVien() { return nhanVien; }
    public String getMaDatPhong() { return datPhong.getMaDatPhong(); }
    public String getMaNV() { return nhanVien.getMaNV(); }

    @Override
    public String toString() {
        return "PhieuThu{soPhieuThu=" + soPhieuThu + ", ngayThu=" + ngayThu
                + ", nguoiNop=" + hoTenNguoiNop + ", soTien=" + soTien
                + ", loaiPhieu=" + loaiPhieu + ", hinhThuc=" + hinhThuc
                + ", maDatPhong=" + getMaDatPhong() + ", maNV=" + getMaNV() + "}";
    }
}
