package hotel.model;

import java.util.Optional;

/** Loại phòng: Standard Single, Deluxe Double, Suite Family... */
public final class LoaiPhong {

    private final String maLoaiPhong;   // khóa chính (PK)
    private final String tenLoai;
    private final int soNguoiToiDa;
    private final double giaCoBan;
    private final String moTa;          // AN: được phép null

    public LoaiPhong(String maLoaiPhong, String tenLoai, int soNguoiToiDa,
                     double giaCoBan, String moTa) {
        // 1. KIỂM TRA trước
        if (maLoaiPhong == null || maLoaiPhong.isBlank())
            throw new IllegalArgumentException("maLoaiPhong không được rỗng");
        if (tenLoai == null || tenLoai.isBlank())
            throw new IllegalArgumentException("tenLoai không được rỗng");
        if (soNguoiToiDa < 1)
            throw new IllegalArgumentException("soNguoiToiDa phải >= 1");
        if (giaCoBan <= 0)
            throw new IllegalArgumentException("giaCoBan phải > 0");

        // 2. Hợp lệ hết rồi mới GÁN
        this.maLoaiPhong = maLoaiPhong;
        this.tenLoai = tenLoai;
        this.soNguoiToiDa = soNguoiToiDa;
        this.giaCoBan = giaCoBan;
        this.moTa = moTa;               // không kiểm tra: được phép null
    }

    public String getMaLoaiPhong() { return maLoaiPhong; }
    public String getTenLoai()     { return tenLoai; }
    public int getSoNguoiToiDa()   { return soNguoiToiDa; }
    public double getGiaCoBan()    { return giaCoBan; }

    /** Thuộc tính AN: trả Optional để người gọi buộc phải xử lý trường hợp vắng. */
    public Optional<String> getMoTa() { return Optional.ofNullable(moTa); }

    @Override
    public String toString() {
        return "LoaiPhong{" + maLoaiPhong + ", " + tenLoai + ", tối đa " + soNguoiToiDa
                + " người, giá cơ bản " + giaCoBan + ", mô tả=" + moTa + "}";
    }
}
