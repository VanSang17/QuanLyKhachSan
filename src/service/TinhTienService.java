package service;

import data.KhoDuLieu;
import dto.TienPhongDTO;
import model.ChiTietDatPhong;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

/**
 * Tính tiền phòng và tiền dịch vụ. Dùng cho câu 12, 13, 14, 18, 19.
 * Quy ước (mục 5 kế hoạch): phòng chưa trả (ngayTraThucTe null) tính đến ngayTraDuKien.
 * Tiền phòng luôn dùng giaThue của ChiTietDatPhong (giá lúc đặt), KHÔNG dùng giaCoBan của LoaiPhong.
 */
public class TinhTienService {
    private final KhoDuLieu kho;

    public TinhTienService(KhoDuLieu kho) {
        this.kho = kho;
    }

    /** Tiền phòng của một phòng trong một lần đặt (câu 12). */
    public TienPhongDTO tinhTienPhong(String maDatPhong, String maPhong) {
        ChiTietDatPhong ct = kho.getChiTietDatPhong().stream()
                .filter(c -> c.getMaDatPhong().equals(maDatPhong) && c.getMaPhong().equals(maPhong))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Phòng " + maPhong + " không thuộc đặt phòng " + maDatPhong));
        return tinhTienPhong(ct);
    }

    /** Dùng khi đã có sẵn dòng ChiTietDatPhong (ví dụ vòng lặp câu 19). */
    public TienPhongDTO tinhTienPhong(ChiTietDatPhong ct) {
        Optional<LocalDate> nhan = ct.getNgayNhanThucTe();
        if (nhan.isEmpty()) {
            // chưa nhận phòng → chưa phát sinh tiền
            return new TienPhongDTO(ct.getMaDatPhong(), ct.getMaPhong(), 0, 0);
        }
        LocalDate tra = ct.getNgayTraThucTe().orElse(ct.getDatPhong().getNgayTraDuKien());
        long soDem = ChronoUnit.DAYS.between(nhan.get(), tra);
        return new TienPhongDTO(ct.getMaDatPhong(), ct.getMaPhong(), soDem, soDem * ct.getGiaThue());
    }

    /** Tổng tiền phòng của cả lần đặt (câu 18). */
    public double tinhTongTienPhong(String maDatPhong) {
        return kho.getChiTietDatPhong().stream()
                .filter(c -> c.getMaDatPhong().equals(maDatPhong))
                .mapToDouble(c -> tinhTienPhong(c).getTien())
                .sum();
    }

    /** Tổng tiền dịch vụ của cả lần đặt (câu 14, 18). Không có dịch vụ thì bằng 0. */
    public double tinhTienDichVu(String maDatPhong) {
        return kho.getSuDungDichVu().stream()
                .filter(s -> s.getMaDatPhong().equals(maDatPhong))
                .mapToDouble(s -> s.getThanhTien())
                .sum();
    }
}
