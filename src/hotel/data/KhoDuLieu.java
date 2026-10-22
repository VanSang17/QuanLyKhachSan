package hotel.data;

import hotel.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Kho dữ liệu: mỗi bảng một List. Các lớp truy vấn chỉ làm việc qua kho này.
 * (Phần 5 bảng của Sang. 6 bảng của Toàn sẽ được thêm vào sau khi có model.)
 */
public class KhoDuLieu {

    private final List<LoaiPhong> loaiPhong = new ArrayList<>();
    private final List<Phong> phong = new ArrayList<>();
    private final List<PhongLienThong> phongLienThong = new ArrayList<>();
    private final List<KhachHang> khachHang = new ArrayList<>();
    private final List<NhanVien> nhanVien = new ArrayList<>();

    // ======================= THÊM (chặn trùng khóa) =======================

    public void themLoaiPhong(LoaiPhong lp) {
        boolean daCo = loaiPhong.stream()
                .anyMatch(x -> x.getMaLoaiPhong().equals(lp.getMaLoaiPhong()));
        if (daCo) throw new IllegalArgumentException("Trùng mã loại phòng: " + lp.getMaLoaiPhong());
        loaiPhong.add(lp);
    }

    public void themPhong(Phong p) {
        boolean daCo = phong.stream()
                .anyMatch(x -> x.getMaPhong().equals(p.getMaPhong()));
        if (daCo) throw new IllegalArgumentException("Trùng mã phòng: " + p.getMaPhong());
        phong.add(p);
    }

    /** Khóa ghép 2 trường: chỉ coi là trùng khi CẢ HAI trường đều trùng. */
    public void themPhongLienThong(PhongLienThong lt) {
        boolean daCo = phongLienThong.stream()
                .anyMatch(x -> x.getMaPhong().equals(lt.getMaPhong())
                        && x.getMaPhongLienThong().equals(lt.getMaPhongLienThong()));
        if (daCo) throw new IllegalArgumentException(
                "Trùng liên thông: " + lt.getMaPhong() + " - " + lt.getMaPhongLienThong());
        phongLienThong.add(lt);
    }

    /** Kiểm tra trùng mã khách hàng VÀ trùng cccd (ràng buộc mục 6.1 của báo cáo). */
    public void themKhachHang(KhachHang kh) {
        boolean trungMa = khachHang.stream()
                .anyMatch(x -> x.getMaKH().equals(kh.getMaKH()));
        if (trungMa) throw new IllegalArgumentException("Trùng mã khách hàng: " + kh.getMaKH());

        boolean trungCccd = khachHang.stream()
                .anyMatch(x -> x.getCccd().equals(kh.getCccd()));
        if (trungCccd) throw new IllegalArgumentException("Trùng cccd: " + kh.getCccd());

        khachHang.add(kh);
    }

    public void themNhanVien(NhanVien nv) {
        boolean daCo = nhanVien.stream()
                .anyMatch(x -> x.getMaNV().equals(nv.getMaNV()));
        if (daCo) throw new IllegalArgumentException("Trùng mã nhân viên: " + nv.getMaNV());
        nhanVien.add(nv);
    }

    // ======================= TÌM THEO MÃ (trả Optional) =======================

    public Optional<LoaiPhong> timLoaiPhong(String ma) {
        return loaiPhong.stream().filter(x -> x.getMaLoaiPhong().equals(ma)).findFirst();
    }

    public Optional<Phong> timPhong(String ma) {
        return phong.stream().filter(x -> x.getMaPhong().equals(ma)).findFirst();
    }

    public Optional<KhachHang> timKhachHang(String ma) {
        return khachHang.stream().filter(x -> x.getMaKH().equals(ma)).findFirst();
    }

    public Optional<NhanVien> timNhanVien(String ma) {
        return nhanVien.stream().filter(x -> x.getMaNV().equals(ma)).findFirst();
    }

    // ======================= LẤY TOÀN BỘ (chỉ đọc) =======================

    public List<LoaiPhong> getLoaiPhong()           { return Collections.unmodifiableList(loaiPhong); }
    public List<Phong> getPhong()                   { return Collections.unmodifiableList(phong); }
    public List<PhongLienThong> getPhongLienThong() { return Collections.unmodifiableList(phongLienThong); }
    public List<KhachHang> getKhachHang()           { return Collections.unmodifiableList(khachHang); }
    public List<NhanVien> getNhanVien()             { return Collections.unmodifiableList(nhanVien); }
}
