package hotel;

import hotel.enums.*;
import hotel.model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // --- PhongLienThong ---
        PhongLienThong lt = new PhongLienThong("P003", "P004");
        System.out.println(lt);
        try {
            new PhongLienThong("P003", "P003");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        // --- KhachHang ---
        KhachHang kh = new KhachHang("KH002", "Trần Thị Bình", Phai.NU, LocalDate.of(1995, 8, 20),
                "001095004321", "0912345678", null, "Hà Nội", "Việt Nam");
        System.out.println(kh);
        System.out.println(kh.getEmail().orElse("(không có email)"));
        System.out.println(kh.getDiaChi().orElse("(không có địa chỉ)"));
        try {
            new KhachHang("KH099", "Khách tương lai", Phai.NAM, LocalDate.of(2999, 1, 1),
                    "123", "0900000000", null, null, "Việt Nam");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        // --- NhanVien ---
        NhanVien ql = new NhanVien("NV001", "Hoàng Thị Lan", Phai.NU, LocalDate.of(1980, 2, 14),
                "TP.HCM", "0901000001", ChucVu.QUAN_LY, 20000000, null);
        NhanVien nv = new NhanVien("NV002", "Đặng Văn Hùng", Phai.NAM, LocalDate.of(1993, 6, 1),
                "TP.HCM", "0901000002", ChucVu.LE_TAN, 9000000, "NV001");
        System.out.println(ql);
        System.out.println(nv);
        System.out.println(ql.getMaQuanLy().isPresent());   // false: quản lý cao nhất
        System.out.println(nv.getMaQuanLy().get());         // NV001
        try {
            new NhanVien("NV009", "Tự quản", Phai.NAM, LocalDate.of(1990, 1, 1),
                    null, "0900000009", ChucVu.BAO_VE, 5000000, "NV009");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}