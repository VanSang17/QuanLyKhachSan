package hotel.model;

import hotel.enums.Phai;

import java.time.LocalDate;
import java.util.Optional;

/** Khách hàng đặt phòng. */
public final class KhachHang {

    private final String maKH;          // PK
    private final String hoTen;
    private final Phai phai;
    private final LocalDate ngaySinh;
    private final String cccd;          // duy nhất giữa các khách (KhoDuLieu sẽ kiểm tra)
    private final String soDienThoai;
    private final String email;         // AN: có thể null
    private final String diaChi;        // AN: có thể null
    private final String quocTich;

    public KhachHang(String maKH, String hoTen, Phai phai, LocalDate ngaySinh,
                     String cccd, String soDienThoai, String email,
                     String diaChi, String quocTich) {
        if (maKH == null || maKH.isBlank())
            throw new IllegalArgumentException("maKH không được rỗng");
        if (hoTen == null || hoTen.isBlank())
            throw new IllegalArgumentException("hoTen không được rỗng");
        if (phai == null)
            throw new IllegalArgumentException("phai không được null");
        if (ngaySinh == null)
            throw new IllegalArgumentException("ngaySinh không được null");
        if (ngaySinh.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("ngaySinh không được ở tương lai: " + ngaySinh);
        if (cccd == null || cccd.isBlank())
            throw new IllegalArgumentException("cccd không được rỗng");
        if (soDienThoai == null || soDienThoai.isBlank())
            throw new IllegalArgumentException("soDienThoai không được rỗng");
        if (quocTich == null || quocTich.isBlank())
            throw new IllegalArgumentException("quocTich không được rỗng");

        this.maKH = maKH;
        this.hoTen = hoTen;
        this.phai = phai;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.soDienThoai = soDienThoai;
        this.email = email;             // AN: không kiểm tra
        this.diaChi = diaChi;           // AN: không kiểm tra
        this.quocTich = quocTich;
    }

    public String getMaKH()        { return maKH; }
    public String getHoTen()       { return hoTen; }
    public Phai getPhai()          { return phai; }
    public LocalDate getNgaySinh() { return ngaySinh; }
    public String getCccd()        { return cccd; }
    public String getSoDienThoai() { return soDienThoai; }
    public String getQuocTich()    { return quocTich; }

    public Optional<String> getEmail()  { return Optional.ofNullable(email); }
    public Optional<String> getDiaChi() { return Optional.ofNullable(diaChi); }

    @Override
    public String toString() {
        return "KhachHang{" + maKH + ", " + hoTen + ", " + phai + ", " + quocTich + "}";
    }
}
