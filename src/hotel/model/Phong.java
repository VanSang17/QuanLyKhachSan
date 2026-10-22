package hotel.model;

import hotel.enums.TinhTrangPhong;

/** Một phòng cụ thể trong khách sạn. */
public final class Phong {

    private final String maPhong;            // PK
    private final String soPhong;            // số hiển thị trên cửa: "101", "201"...
    private final int tang;
    private TinhTrangPhong tinhTrang;        // KHÔNG final: tình trạng đổi theo thời gian
    private final String maLoaiPhong;        // FK -> LoaiPhong, giữ dạng String

    public Phong(String maPhong, String soPhong, int tang,
                 TinhTrangPhong tinhTrang, String maLoaiPhong) {
        if (maPhong == null || maPhong.isBlank())
            throw new IllegalArgumentException("maPhong không được rỗng");
        if (soPhong == null || soPhong.isBlank())
            throw new IllegalArgumentException("soPhong không được rỗng");
        if (tang < 0)
            throw new IllegalArgumentException("tang phải >= 0");
        if (tinhTrang == null)
            throw new IllegalArgumentException("tinhTrang không được null");
        if (maLoaiPhong == null || maLoaiPhong.isBlank())
            throw new IllegalArgumentException("maLoaiPhong không được rỗng");

        this.maPhong = maPhong;
        this.soPhong = soPhong;
        this.tang = tang;
        this.tinhTrang = tinhTrang;
        this.maLoaiPhong = maLoaiPhong;
    }

    public String getMaPhong()           { return maPhong; }
    public String getSoPhong()           { return soPhong; }
    public int getTang()                 { return tang; }
    public TinhTrangPhong getTinhTrang() { return tinhTrang; }
    public String getMaLoaiPhong()       { return maLoaiPhong; }

    /** Setter DUY NHẤT của lớp: chỉ tình trạng phòng thay đổi theo thời gian. */
    public void setTinhTrang(TinhTrangPhong tinhTrang) {
        if (tinhTrang == null)
            throw new IllegalArgumentException("tinhTrang không được null");
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "Phong{" + maPhong + ", số " + soPhong + ", tầng " + tang
                + ", " + tinhTrang + ", loại " + maLoaiPhong + "}";
    }
}