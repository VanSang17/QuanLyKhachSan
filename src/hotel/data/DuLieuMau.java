package hotel.data;

import hotel.enums.*;
import hotel.model.*;

import java.time.LocalDate;

/**
 * Nạp dữ liệu mẫu. Mỗi người một phương thức riêng để Git ít xung đột:
 * napDuLieuSang (5 bảng của Sang) và napDuLieuToan (6 bảng của Toàn).
 */
public final class DuLieuMau {

    private DuLieuMau() { }   // chặn new DuLieuMau(): lớp này chỉ chứa hàm static

    public static void napDuLieuSang(KhoDuLieu kho) {
        // Nạp bảng "một" (LoaiPhong) trước bảng "nhiều" (Phong) cho đúng thói quen khóa ngoài

        // ---- LoaiPhong ----
        kho.themLoaiPhong(new LoaiPhong("LP01", "Standard Single", 1, 500000, "1 giường đơn"));
        kho.themLoaiPhong(new LoaiPhong("LP02", "Deluxe Double", 2, 900000, "1 giường đôi, ban công"));
        kho.themLoaiPhong(new LoaiPhong("LP03", "Suite Family", 4, 1800000, null));

        // ---- Phong ----
        kho.themPhong(new Phong("P001", "101", 1, TinhTrangPhong.TRONG,   "LP01"));
        kho.themPhong(new Phong("P002", "102", 1, TinhTrangPhong.DANG_O,  "LP01"));
        kho.themPhong(new Phong("P003", "201", 2, TinhTrangPhong.DANG_O,  "LP02"));
        kho.themPhong(new Phong("P004", "202", 2, TinhTrangPhong.TRONG,   "LP02"));
        kho.themPhong(new Phong("P005", "203", 2, TinhTrangPhong.BAO_TRI, "LP02"));
        kho.themPhong(new Phong("P006", "301", 3, TinhTrangPhong.DANG_O,  "LP03"));
        kho.themPhong(new Phong("P007", "302", 3, TinhTrangPhong.TRONG,   "LP03"));
        kho.themPhong(new Phong("P008", "303", 3, TinhTrangPhong.DON_DEP, "LP02"));

        // ---- PhongLienThong (lưu HAI CHIỀU) ----
        kho.themPhongLienThong(new PhongLienThong("P003", "P004"));
        kho.themPhongLienThong(new PhongLienThong("P004", "P003"));
        kho.themPhongLienThong(new PhongLienThong("P006", "P007"));
        kho.themPhongLienThong(new PhongLienThong("P007", "P006"));

        // ---- KhachHang ----
        kho.themKhachHang(new KhachHang("KH001", "Nguyễn Văn An", Phai.NAM, LocalDate.of(1990, 5, 12),
                "079090001234", "0901234567", "an.nguyen@mail.com", "TP.HCM", "Việt Nam"));
        kho.themKhachHang(new KhachHang("KH002", "Trần Thị Bình", Phai.NU, LocalDate.of(1995, 8, 20),
                "001095004321", "0912345678", null, "Hà Nội", "Việt Nam"));
        kho.themKhachHang(new KhachHang("KH003", "Lê Hoàng Cường", Phai.NAM, LocalDate.of(1988, 11, 2),
                "048088005678", "0987654321", "cuong.le@mail.com", "Đà Nẵng", "Việt Nam"));
        kho.themKhachHang(new KhachHang("KH004", "Phạm Thu Dung", Phai.NU, LocalDate.of(2000, 1, 15),
                "092200007890", "0933445566", "dung.pham@mail.com", "Cần Thơ", "Việt Nam"));
        kho.themKhachHang(new KhachHang("KH005", "John Smith", Phai.NAM, LocalDate.of(1985, 3, 30),
                "P1234567", "0909888777", "john.smith@mail.com", "London", "Anh"));
        kho.themKhachHang(new KhachHang("KH006", "Võ Minh Em", Phai.NAM, LocalDate.of(1992, 7, 7),
                "046092001111", "0977111222", null, "Huế", "Việt Nam"));

        // ---- NhanVien ---- (NV001 là quản lý cao nhất: maQuanLy = null)
        kho.themNhanVien(new NhanVien("NV001", "Hoàng Thị Lan", Phai.NU, LocalDate.of(1980, 2, 14),
                "TP.HCM", "0901000001", ChucVu.QUAN_LY, 20000000, null));
        kho.themNhanVien(new NhanVien("NV002", "Đặng Văn Hùng", Phai.NAM, LocalDate.of(1993, 6, 1),
                "TP.HCM", "0901000002", ChucVu.LE_TAN, 9000000, "NV001"));
        kho.themNhanVien(new NhanVien("NV003", "Bùi Thị Mai", Phai.NU, LocalDate.of(1996, 9, 9),
                "Bình Dương", "0901000003", ChucVu.LE_TAN, 9000000, "NV001"));
        kho.themNhanVien(new NhanVien("NV004", "Ngô Quốc Khánh", Phai.NAM, LocalDate.of(1990, 12, 25),
                "TP.HCM", "0901000004", ChucVu.BUONG_PHONG, 7000000, "NV001"));
        kho.themNhanVien(new NhanVien("NV005", "Trịnh Thanh Nga", Phai.NU, LocalDate.of(1991, 4, 18),
                "Đồng Nai", "0901000005", ChucVu.KE_TOAN, 12000000, "NV001"));
    }
}