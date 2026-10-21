package dto;

/** Kết quả tính tiền phòng của một phòng trong một lần đặt. */
public final class TienPhongDTO {
    private final String maDatPhong;
    private final String maPhong;
    private final long soDem;
    private final double tien;

    public TienPhongDTO(String maDatPhong, String maPhong, long soDem, double tien) {
        this.maDatPhong = maDatPhong;
        this.maPhong = maPhong;
        this.soDem = soDem;
        this.tien = tien;
    }

    public String getMaDatPhong() { return maDatPhong; }
    public String getMaPhong() { return maPhong; }
    public long getSoDem() { return soDem; }
    public double getTien() { return tien; }

    @Override
    public String toString() {
        return "TienPhongDTO{" + maDatPhong + ", " + maPhong
                + ", soDem=" + soDem + ", tien=" + tien + "}";
    }
}
