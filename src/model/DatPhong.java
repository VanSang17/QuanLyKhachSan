package model;

import enums.TrangThaiDatPhong;

import java.time.LocalDate;
import java.util.Optional;

public final class DatPhong {
    private final String maDatPhong;            // khóa chính
    private final LocalDate ngayDat;
    private final LocalDate ngayNhanDuKien;
    private final LocalDate ngayTraDuKien;
    private TrangThaiDatPhong trangThai;        // thay đổi theo thời gian
    private final String ghiChu;                // cho phép null
    private final KhachHang khachHang;          // khóa ngoài (tham chiếu đối tượng)
    private final NhanVien nhanVien;            // người lập

    public DatPhong(String maDatPhong, LocalDate ngayDat, LocalDate ngayNhanDuKien,
                    LocalDate ngayTraDuKien, TrangThaiDatPhong trangThai, String ghiChu,
                    KhachHang khachHang, NhanVien nhanVien) {
        this.maDatPhong = KiemTra.chuoiKhongRong(maDatPhong, "maDatPhong");
        this.ngayDat = KiemTra.khongNull(ngayDat, "ngayDat");
        this.ngayNhanDuKien = KiemTra.khongNull(ngayNhanDuKien, "ngayNhanDuKien");
        this.ngayTraDuKien = KiemTra.khongNull(ngayTraDuKien, "ngayTraDuKien");
        if (ngayTraDuKien.isBefore(ngayNhanDuKien))
            throw new IllegalArgumentException("ngayTraDuKien không được trước ngayNhanDuKien");
        this.trangThai = KiemTra.khongNull(trangThai, "trangThai");
        this.ghiChu = ghiChu;
        this.khachHang = KiemTra.khongNull(khachHang, "khachHang");
        this.nhanVien = KiemTra.khongNull(nhanVien, "nhanVien");
    }

    public String getMaDatPhong() { return maDatPhong; }
    public LocalDate getNgayDat() { return ngayDat; }
    public LocalDate getNgayNhanDuKien() { return ngayNhanDuKien; }
    public LocalDate getNgayTraDuKien() { return ngayTraDuKien; }
    public TrangThaiDatPhong getTrangThai() { return trangThai; }
    public Optional<String> getGhiChu() { return Optional.ofNullable(ghiChu); }
    public KhachHang getKhachHang() { return khachHang; }
    public NhanVien getNhanVien() { return nhanVien; }

    public void setTrangThai(TrangThaiDatPhong trangThai) {
        this.trangThai = KiemTra.khongNull(trangThai, "trangThai");
    }

    @Override
    public String toString() {
        return "DatPhong{maDatPhong=" + maDatPhong + ", ngayDat=" + ngayDat
                + ", nhanDuKien=" + ngayNhanDuKien + ", traDuKien=" + ngayTraDuKien
                + ", trangThai=" + trangThai + ", ghiChu=" + ghiChu
                + ", khachHang=" + khachHang.getMaKH()
                + ", nhanVien=" + nhanVien.getMaNV() + "}";
    }
}
