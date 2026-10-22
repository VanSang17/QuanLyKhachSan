package hotel;

import hotel.data.KhoDuLieu;
import hotel.enums.Phai;
import hotel.model.KhachHang;
import hotel.model.LoaiPhong;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        KhoDuLieu kho = new KhoDuLieu();
        kho.themLoaiPhong(new LoaiPhong("LP01", "Standard Single", 1, 500000, null));
        kho.themLoaiPhong(new LoaiPhong("LP02", "Deluxe Double", 2, 900000, null));

        System.out.println(kho.getLoaiPhong().size());                     // 2
        System.out.println(kho.timLoaiPhong("LP02").get().getTenLoai());   // Deluxe Double
        System.out.println(kho.timLoaiPhong("LP99").isPresent());          // false

        try {
            kho.themLoaiPhong(new LoaiPhong("LP01", "Trùng mã", 1, 100000, null));
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        try {
            kho.getLoaiPhong().clear();                                    // cố sửa từ bên ngoài
        } catch (UnsupportedOperationException e) {
            System.out.println("Không được sửa danh sách từ bên ngoài");
        }

        kho.themKhachHang(new KhachHang("KH001", "An", Phai.NAM, LocalDate.of(1990, 5, 12),
                "079090001234", "0901234567", null, null, "Việt Nam"));
        try {
            kho.themKhachHang(new KhachHang("KH002", "Bình", Phai.NU, LocalDate.of(1995, 8, 20),
                    "079090001234", "0912345678", null, null, "Việt Nam"));   // cùng cccd
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}