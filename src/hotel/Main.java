package hotel;

import hotel.enums.TinhTrangPhong;
import hotel.model.LoaiPhong;
import hotel.model.Phong;

public class Main {
    public static void main(String[] args) {
        LoaiPhong lp1 = new LoaiPhong("LP01", "Standard Single", 1, 500000, "1 giường đơn");
        LoaiPhong lp3 = new LoaiPhong("LP03", "Suite Family", 4, 1800000, null);
        System.out.println(lp1);
        System.out.println(lp1.getMoTa().orElse("(không có mô tả)"));
        System.out.println(lp3.getMoTa().orElse("(không có mô tả)"));

        try {
            new LoaiPhong("LP99", "Phòng lỗi", 1, -5, null);   // giá âm -> phải báo lỗi
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        Phong p = new Phong("P001", "101", 1, TinhTrangPhong.TRONG, "LP01");
        System.out.println(p);
        p.setTinhTrang(TinhTrangPhong.DANG_O);
        System.out.println(p.getTinhTrang());

        try {
            new Phong("P009", "999", -1, TinhTrangPhong.TRONG, "LP01");   // tầng âm
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
