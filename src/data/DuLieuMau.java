package data;

import enums.HinhThucThanhToan;
import enums.LoaiPhieuThu;
import enums.TrangThaiDatPhong;
import model.*;

import java.time.LocalDate;

/**
 * Phần dữ liệu mẫu của Toàn (6 bảng bên phải). Khi gộp code, dán các phương thức
 * dưới đây vào lớp DuLieuMau chung. Phải gọi napDuLieuSang(kho) TRƯỚC napDuLieuToan(kho),
 * vì DatPhong/PhieuThu/ChiTietDatPhong tham chiếu KhachHang, NhanVien, Phong của Sang.
 */
public class DuLieuMau {

    public static void napDuLieuToan(KhoDuLieu kho) {
        // ---- NhomDichVu ----
        kho.themNhomDichVu(new NhomDichVu("NDV01", "Ăn uống", "Ăn sáng, đồ uống"));
        kho.themNhomDichVu(new NhomDichVu("NDV02", "Giặt ủi", "Giặt, ủi quần áo"));
        kho.themNhomDichVu(new NhomDichVu("NDV03", "Vận chuyển", "Đưa đón, thuê xe"));

        // ---- DichVu ----
        kho.themDichVu(new DichVu("DV01", "Ăn sáng buffet", "suất", 150000, nhom(kho, "NDV01")));
        kho.themDichVu(new DichVu("DV02", "Nước suối", "chai", 20000, nhom(kho, "NDV01")));
        kho.themDichVu(new DichVu("DV03", "Giặt ủi theo ký", "kg", 50000, nhom(kho, "NDV02")));
        kho.themDichVu(new DichVu("DV04", "Ủi đồ", "món", 30000, nhom(kho, "NDV02")));
        kho.themDichVu(new DichVu("DV05", "Đưa đón sân bay", "chuyến", 300000, nhom(kho, "NDV03")));
        kho.themDichVu(new DichVu("DV06", "Thuê xe máy", "ngày", 150000, nhom(kho, "NDV03")));

        // ---- DatPhong ----
        kho.themDatPhong(new DatPhong("DP001", ngay(2026, 9, 25), ngay(2026, 9, 30), ngay(2026, 10, 3),
                TrangThaiDatPhong.DANG_O, "Đi công tác", kh(kho, "KH001"), nv(kho, "NV002")));
        kho.themDatPhong(new DatPhong("DP002", ngay(2026, 9, 28), ngay(2026, 10, 1), ngay(2026, 10, 5),
                TrangThaiDatPhong.DANG_O, null, kh(kho, "KH005"), nv(kho, "NV003")));
        kho.themDatPhong(new DatPhong("DP003", ngay(2026, 9, 20), ngay(2026, 9, 22), ngay(2026, 9, 24),
                TrangThaiDatPhong.DA_TRA, null, kh(kho, "KH002"), nv(kho, "NV002")));
        kho.themDatPhong(new DatPhong("DP004", ngay(2026, 10, 1), ngay(2026, 10, 10), ngay(2026, 10, 12),
                TrangThaiDatPhong.DA_DAT, "Cần phòng yên tĩnh", kh(kho, "KH003"), nv(kho, "NV003")));
        kho.themDatPhong(new DatPhong("DP005", ngay(2026, 9, 15), ngay(2026, 9, 18), ngay(2026, 9, 20),
                TrangThaiDatPhong.HUY, "Khách báo hủy", kh(kho, "KH004"), nv(kho, "NV002")));

        // ---- ChiTietDatPhong ----
        kho.themChiTietDatPhong(new ChiTietDatPhong(dp(kho, "DP001"), phong(kho, "P002"), 500000,
                ngay(2026, 9, 30), null));
        kho.themChiTietDatPhong(new ChiTietDatPhong(dp(kho, "DP001"), phong(kho, "P003"), 900000,
                ngay(2026, 9, 30), null));
        kho.themChiTietDatPhong(new ChiTietDatPhong(dp(kho, "DP002"), phong(kho, "P006"), 1800000,
                ngay(2026, 10, 1), null));
        kho.themChiTietDatPhong(new ChiTietDatPhong(dp(kho, "DP003"), phong(kho, "P001"), 500000,
                ngay(2026, 9, 22), ngay(2026, 9, 24)));
        kho.themChiTietDatPhong(new ChiTietDatPhong(dp(kho, "DP004"), phong(kho, "P004"), 900000,
                null, null));
        kho.themChiTietDatPhong(new ChiTietDatPhong(dp(kho, "DP005"), phong(kho, "P008"), 900000,
                null, null));

        // ---- SuDungDichVu ----
        kho.themSuDungDichVu(new SuDungDichVu(dp(kho, "DP001"), phong(kho, "P002"), dv(kho, "DV01"),
                ngay(2026, 10, 1), 1, 150000));
        kho.themSuDungDichVu(new SuDungDichVu(dp(kho, "DP001"), phong(kho, "P003"), dv(kho, "DV01"),
                ngay(2026, 10, 1), 2, 150000));
        kho.themSuDungDichVu(new SuDungDichVu(dp(kho, "DP001"), phong(kho, "P003"), dv(kho, "DV03"),
                ngay(2026, 10, 1), 3, 50000));
        kho.themSuDungDichVu(new SuDungDichVu(dp(kho, "DP002"), phong(kho, "P006"), dv(kho, "DV05"),
                ngay(2026, 10, 1), 1, 300000));
        kho.themSuDungDichVu(new SuDungDichVu(dp(kho, "DP002"), phong(kho, "P006"), dv(kho, "DV01"),
                ngay(2026, 10, 2), 4, 150000));
        kho.themSuDungDichVu(new SuDungDichVu(dp(kho, "DP003"), phong(kho, "P001"), dv(kho, "DV02"),
                ngay(2026, 9, 23), 2, 20000));
        kho.themSuDungDichVu(new SuDungDichVu(dp(kho, "DP003"), phong(kho, "P001"), dv(kho, "DV06"),
                ngay(2026, 9, 23), 1, 150000));

        // ---- PhieuThu ----
        kho.themPhieuThu(new PhieuThu("PT001", ngay(2026, 9, 25), "Nguyễn Văn An", 1000000,
                LoaiPhieuThu.DAT_COC, HinhThucThanhToan.CHUYEN_KHOAN, dp(kho, "DP001"), nv(kho, "NV002")));
        kho.themPhieuThu(new PhieuThu("PT002", ngay(2026, 9, 28), "John Smith", 1800000,
                LoaiPhieuThu.DAT_COC, HinhThucThanhToan.THE, dp(kho, "DP002"), nv(kho, "NV003")));
        kho.themPhieuThu(new PhieuThu("PT003", ngay(2026, 9, 21), "Trần Thị Bình", 300000,
                LoaiPhieuThu.DAT_COC, HinhThucThanhToan.TIEN_MAT, dp(kho, "DP003"), nv(kho, "NV002")));
        kho.themPhieuThu(new PhieuThu("PT004", ngay(2026, 9, 24), "Trần Thị Bình", 890000,
                LoaiPhieuThu.THANH_TOAN, HinhThucThanhToan.TIEN_MAT, dp(kho, "DP003"), nv(kho, "NV005")));
        kho.themPhieuThu(new PhieuThu("PT005", ngay(2026, 10, 1), "Lê Hoàng Cường", 500000,
                LoaiPhieuThu.DAT_COC, HinhThucThanhToan.TIEN_MAT, dp(kho, "DP004"), nv(kho, "NV003")));
        kho.themPhieuThu(new PhieuThu("PT006", ngay(2026, 9, 15), "Phạm Thu Dung", 400000,
                LoaiPhieuThu.DAT_COC, HinhThucThanhToan.CHUYEN_KHOAN, dp(kho, "DP005"), nv(kho, "NV002")));
    }

    // ---------- hàm phụ: tra đối tượng để gắn khóa ngoài ----------
    private static LocalDate ngay(int nam, int thang, int ngay) {
        return LocalDate.of(nam, thang, ngay);
    }

    private static KhachHang kh(KhoDuLieu kho, String ma) {
        return kho.timKhachHang(ma).orElseThrow(
                () -> new IllegalStateException("Thiếu khách hàng " + ma + " (Sang phải nạp trước)"));
    }

    private static NhanVien nv(KhoDuLieu kho, String ma) {
        return kho.timNhanVien(ma).orElseThrow(
                () -> new IllegalStateException("Thiếu nhân viên " + ma + " (Sang phải nạp trước)"));
    }

    private static Phong phong(KhoDuLieu kho, String ma) {
        return kho.timPhong(ma).orElseThrow(
                () -> new IllegalStateException("Thiếu phòng " + ma + " (Sang phải nạp trước)"));
    }

    private static NhomDichVu nhom(KhoDuLieu kho, String ma) {
        return kho.timNhomDichVu(ma).orElseThrow(
                () -> new IllegalStateException("Thiếu nhóm dịch vụ " + ma));
    }

    private static DichVu dv(KhoDuLieu kho, String ma) {
        return kho.timDichVu(ma).orElseThrow(
                () -> new IllegalStateException("Thiếu dịch vụ " + ma));
    }

    private static DatPhong dp(KhoDuLieu kho, String ma) {
        return kho.timDatPhong(ma).orElseThrow(
                () -> new IllegalStateException("Thiếu đặt phòng " + ma));
    }
}
