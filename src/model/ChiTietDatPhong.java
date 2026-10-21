package model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

/** Liên kết DatPhong – Phong. Khóa ghép: maDatPhong + maPhong. */
public final class ChiTietDatPhong {
    private final DatPhong datPhong;            // khóa 1/2
    private final Phong phong;                  // khóa 2/2
    private final double giaThue;               // giá/đêm tại thời điểm đặt
    private LocalDate ngayNhanThucTe;           // cho phép null
    private LocalDate ngayTraThucTe;            // cho phép null

    public ChiTietDatPhong(DatPhong datPhong, Phong phong, double giaThue,
                           LocalDate ngayNhanThucTe, LocalDate ngayTraThucTe) {
        this.datPhong = KiemTra.khongNull(datPhong, "datPhong");
        this.phong = KiemTra.khongNull(phong, "phong");
        if (giaThue <= 0)
            throw new IllegalArgumentException("giaThue phải > 0");
        this.giaThue = giaThue;
        kiemTraNgayThucTe(ngayNhanThucTe, ngayTraThucTe);
        this.ngayNhanThucTe = ngayNhanThucTe;
        this.ngayTraThucTe = ngayTraThucTe;
    }

    private static void kiemTraNgayThucTe(LocalDate nhan, LocalDate tra) {
        if (tra != null && nhan == null)
            throw new IllegalArgumentException("Chưa nhận phòng thì không thể có ngày trả thực tế");
        if (nhan != null && tra != null && tra.isBefore(nhan))
            throw new IllegalArgumentException("ngayTraThucTe không được trước ngayNhanThucTe");
    }

    public DatPhong getDatPhong() { return datPhong; }
    public Phong getPhong() { return phong; }
    public String getMaDatPhong() { return datPhong.getMaDatPhong(); }
    public String getMaPhong() { return phong.getMaPhong(); }
    public double getGiaThue() { return giaThue; }
    public Optional<LocalDate> getNgayNhanThucTe() { return Optional.ofNullable(ngayNhanThucTe); }
    public Optional<LocalDate> getNgayTraThucTe() { return Optional.ofNullable(ngayTraThucTe); }

    public void setNgayNhanThucTe(LocalDate ngayNhanThucTe) {
        kiemTraNgayThucTe(ngayNhanThucTe, this.ngayTraThucTe);
        this.ngayNhanThucTe = ngayNhanThucTe;
    }

    public void setNgayTraThucTe(LocalDate ngayTraThucTe) {
        kiemTraNgayThucTe(this.ngayNhanThucTe, ngayTraThucTe);
        this.ngayTraThucTe = ngayTraThucTe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChiTietDatPhong)) return false;
        ChiTietDatPhong that = (ChiTietDatPhong) o;
        return getMaDatPhong().equals(that.getMaDatPhong())
                && getMaPhong().equals(that.getMaPhong());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaDatPhong(), getMaPhong());
    }

    @Override
    public String toString() {
        return "ChiTietDatPhong{maDatPhong=" + getMaDatPhong() + ", maPhong=" + getMaPhong()
                + ", giaThue=" + giaThue + ", nhanThucTe=" + ngayNhanThucTe
                + ", traThucTe=" + ngayTraThucTe + "}";
    }
}
