package model;

/** Hàm kiểm tra dùng chung cho constructor của các lớp model. */
public final class KiemTra {
    private KiemTra() { }

    public static String chuoiKhongRong(String giaTri, String tenTruong) {
        if (giaTri == null || giaTri.isBlank())
            throw new IllegalArgumentException(tenTruong + " không được rỗng");
        return giaTri;
    }

    public static <T> T khongNull(T giaTri, String tenTruong) {
        if (giaTri == null)
            throw new IllegalArgumentException(tenTruong + " không được null");
        return giaTri;
    }
}
