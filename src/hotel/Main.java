package hotel;

import hotel.data.DuLieuMau;
import hotel.data.KhoDuLieu;

public class Main {
    public static void main(String[] args) {
        KhoDuLieu kho = new KhoDuLieu();
        DuLieuMau.napDuLieuSang(kho);

        System.out.println(kho.getLoaiPhong().size());        // 3
        System.out.println(kho.getPhong().size());            // 8
        System.out.println(kho.getPhongLienThong().size());   // 4
        System.out.println(kho.getKhachHang().size());        // 6
        System.out.println(kho.getNhanVien().size());         // 5

        kho.getPhong().forEach(System.out::println);          // in mỗi phòng một dòng
        System.out.println(kho.timNhanVien("NV003").get());
    }
}