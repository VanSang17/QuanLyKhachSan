package model;

public final class DichVu {
    private final String maDV;              // khóa chính
    private final String tenDV;
    private final String donViTinh;
    private final double donGia;
    private final NhomDichVu nhomDichVu;    // khóa ngoài (tham chiếu đối tượng)

    public DichVu(String maDV, String tenDV, String donViTinh,
                  double donGia, NhomDichVu nhomDichVu) {
        this.maDV = KiemTra.chuoiKhongRong(maDV, "maDV");
        this.tenDV = KiemTra.chuoiKhongRong(tenDV, "tenDV");
        this.donViTinh = KiemTra.chuoiKhongRong(donViTinh, "donViTinh");
        if (donGia < 0)
            throw new IllegalArgumentException("donGia không được âm");
        this.donGia = donGia;
        this.nhomDichVu = KiemTra.khongNull(nhomDichVu, "nhomDichVu");
    }

    public String getMaDV() { return maDV; }
    public String getTenDV() { return tenDV; }
    public String getDonViTinh() { return donViTinh; }
    public double getDonGia() { return donGia; }
    public NhomDichVu getNhomDichVu() { return nhomDichVu; }

    @Override
    public String toString() {
        return "DichVu{maDV=" + maDV + ", tenDV=" + tenDV + ", donViTinh=" + donViTinh
                + ", donGia=" + donGia + ", nhom=" + nhomDichVu.getTenNhom() + "}";
    }
}
