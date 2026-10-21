package model;

import java.util.Optional;

public final class NhomDichVu {
    private final String maNhomDV;   // khóa chính
    private final String tenNhom;
    private final String noiDung;    // cho phép null

    public NhomDichVu(String maNhomDV, String tenNhom, String noiDung) {
        this.maNhomDV = KiemTra.chuoiKhongRong(maNhomDV, "maNhomDV");
        this.tenNhom = KiemTra.chuoiKhongRong(tenNhom, "tenNhom");
        this.noiDung = noiDung;
    }

    public String getMaNhomDV() { return maNhomDV; }
    public String getTenNhom() { return tenNhom; }
    public Optional<String> getNoiDung() { return Optional.ofNullable(noiDung); }

    @Override
    public String toString() {
        return "NhomDichVu{maNhomDV=" + maNhomDV + ", tenNhom=" + tenNhom
                + ", noiDung=" + noiDung + "}";
    }
}
