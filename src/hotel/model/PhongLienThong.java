package hotel.model;

/**
 * Quan hệ liên thông giữa hai phòng. Khóa ghép 2 trường: (maPhong, maPhongLienThong).
 * Dữ liệu mẫu lưu HAI CHIỀU: có cả (P003,P004) lẫn (P004,P003).
 */
public final class PhongLienThong {

    private final String maPhong;            // PK 1/2, FK -> Phong
    private final String maPhongLienThong;   // PK 2/2, FK -> Phong

    public PhongLienThong(String maPhong, String maPhongLienThong) {
        if (maPhong == null || maPhong.isBlank())
            throw new IllegalArgumentException("maPhong không được rỗng");
        if (maPhongLienThong == null || maPhongLienThong.isBlank())
            throw new IllegalArgumentException("maPhongLienThong không được rỗng");
        if (maPhong.equals(maPhongLienThong))
            throw new IllegalArgumentException("Một phòng không thể liên thông với chính nó: " + maPhong);

        this.maPhong = maPhong;
        this.maPhongLienThong = maPhongLienThong;
    }

    public String getMaPhong()          { return maPhong; }
    public String getMaPhongLienThong() { return maPhongLienThong; }

    @Override
    public String toString() {
        return "PhongLienThong{" + maPhong + " <-> " + maPhongLienThong + "}";
    }
}