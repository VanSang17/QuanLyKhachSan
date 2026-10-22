package hotel.model;

import hotel.enums.ChucVu;
import hotel.enums.Phai;

import java.time.LocalDate;
import java.util.Optional;

/** Nhân viên khách sạn. Mỗi nhân viên (trừ quản lý cao nhất) có một quản lý là nhân viên khác. */
public final class NhanVien {

    private final String maNV;          // PK
    private final String hoTen;
    private final Phai phai;
    private final LocalDate ngaySinh;
    private final String diaChi;        // AN
    private final String soDienThoai;
    private final ChucVu chucVu;
    private final double luong;
    private final String maQuanLy;      // FK -> chính NhanVien; AN (quản lý cao nhất = null)

    public NhanVien(String maNV, String hoTen, Phai phai, LocalDate ngaySinh,
                    String diaChi, String soDienThoai, ChucVu chucVu,
                    double luong, String maQuanLy) {
        if (maNV == null || maNV.isBlank())
            throw new IllegalArgumentException("maNV không được rỗng");
        if (hoTen == null || hoTen.isBlank())
            throw new IllegalArgumentException("hoTen không được rỗng");
        if (phai == null)
            throw new IllegalArgumentException("phai không được null");
        if (ngaySinh == null)
            throw new IllegalArgumentException("ngaySinh không được null");
        if (soDienThoai == null || soDienThoai.isBlank())
            throw new IllegalArgumentException("soDienThoai không được rỗng");
        if (chucVu == null)
            throw new IllegalArgumentException("chucVu không được null");
        if (luong < 0)
            throw new IllegalArgumentException("luong phải >= 0");
        if (maQuanLy != null && maQuanLy.isBlank())
            throw new IllegalArgumentException("maQuanLy nếu có thì không được rỗng");
        if (maNV.equals(maQuanLy))      // equals(null) trả false, không gây lỗi
            throw new IllegalArgumentException("Nhân viên không thể tự quản lý chính mình: " + maNV);

        this.maNV = maNV;
        this.hoTen = hoTen;
        this.phai = phai;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.chucVu = chucVu;
        this.luong = luong;
        this.maQuanLy = maQuanLy;
    }

    public String getMaNV()        { return maNV; }
    public String getHoTen()       { return hoTen; }
    public Phai getPhai()          { return phai; }
    public LocalDate getNgaySinh() { return ngaySinh; }
    public String getSoDienThoai() { return soDienThoai; }
    public ChucVu getChucVu()      { return chucVu; }
    public double getLuong()       { return luong; }

    public Optional<String> getDiaChi()   { return Optional.ofNullable(diaChi); }
    public Optional<String> getMaQuanLy() { return Optional.ofNullable(maQuanLy); }

    @Override
    public String toString() {
        return "NhanVien{" + maNV + ", " + hoTen + ", " + chucVu + ", quản lý=" + maQuanLy + "}";
    }
}