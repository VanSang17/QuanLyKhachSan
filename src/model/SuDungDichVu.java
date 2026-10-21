package model;

import java.time.LocalDate;
import java.util.Objects;

/** Liên kết 3 ngôi DatPhong – Phong – DichVu. Khóa: maDatPhong + maPhong + maDV + ngaySuDung. */
public final class SuDungDichVu {
    private final DatPhong datPhong;      // khóa 1/4
    private final Phong phong;            // khóa 2/4
    private final DichVu dichVu;          // khóa 3/4
    private final LocalDate ngaySuDung;   // khóa 4/4
    private final int soLuong;
    private final double donGia;          // đơn giá lúc dùng

    public SuDungDichVu(DatPhong datPhong, Phong phong, DichVu dichVu,
                        LocalDate ngaySuDung, int soLuong, double donGia) {
        this.datPhong = KiemTra.khongNull(datPhong, "datPhong");
        this.phong = KiemTra.khongNull(phong, "phong");
        this.dichVu = KiemTra.khongNull(dichVu, "dichVu");
        this.ngaySuDung = KiemTra.khongNull(ngaySuDung, "ngaySuDung");
        if (soLuong <= 0)
            throw new IllegalArgumentException("soLuong phải > 0");
        if (donGia < 0)
            throw new IllegalArgumentException("donGia không được âm");
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public DatPhong getDatPhong() { return datPhong; }
    public Phong getPhong() { return phong; }
    public DichVu getDichVu() { return dichVu; }
    public String getMaDatPhong() { return datPhong.getMaDatPhong(); }
    public String getMaPhong() { return phong.getMaPhong(); }
    public String getMaDV() { return dichVu.getMaDV(); }
    public LocalDate getNgaySuDung() { return ngaySuDung; }
    public int getSoLuong() { return soLuong; }
    public double getDonGia() { return donGia; }

    /** Giá trị tính toán, không lưu: soLuong × donGia. */
    public double getThanhTien() { return soLuong * donGia; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SuDungDichVu)) return false;
        SuDungDichVu that = (SuDungDichVu) o;
        return getMaDatPhong().equals(that.getMaDatPhong())
                && getMaPhong().equals(that.getMaPhong())
                && getMaDV().equals(that.getMaDV())
                && ngaySuDung.equals(that.ngaySuDung);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaDatPhong(), getMaPhong(), getMaDV(), ngaySuDung);
    }

    @Override
    public String toString() {
        return "SuDungDichVu{maDatPhong=" + getMaDatPhong() + ", maPhong=" + getMaPhong()
                + ", maDV=" + getMaDV() + ", ngaySuDung=" + ngaySuDung
                + ", soLuong=" + soLuong + ", donGia=" + donGia + "}";
    }
}
