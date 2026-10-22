package hotel;

import hotel.enums.*;

public class Main {
    public static void main(String[] args) {
        TinhTrangPhong t = TinhTrangPhong.TRONG;
        System.out.println(t);                            // in: TRONG
        System.out.println(t == TinhTrangPhong.TRONG);    // in: true

        for (ChucVu cv : ChucVu.values()) {               // duyệt mọi giá trị
            System.out.println(cv);
        }
    }
}
