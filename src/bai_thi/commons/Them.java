package bai_thi.commons;

import bai_thi.models.ChinhHang;
import bai_thi.models.Mobile;
import bai_thi.models.XachTay;

import java.util.List;
import java.util.Scanner;

public class Them {
    public static Scanner scanner = new Scanner(System.in);

    public static int capNhatBienDem() {
        int bienDemID;
        List<Mobile> list = LuuFileCSV.docFile();
        if (list.isEmpty()) bienDemID = 1;
        else {
            int id = list.get(list.size() - 1).getId();
            bienDemID = id + 1;
        }
        return bienDemID;
    }

    public static void themdienthoaiChinhHang() {
        int id = capNhatBienDem();
        String tenDienThoai = Regex.kiemTraNhapChu("tên điện thoại");
        String giaBan = Regex.kiemTraNhapSo("giá bán");
        String soLuong = Regex.kiemTraNhapSo("số lượng");
        String tenNhaSanXuat = Regex.kiemTraNhapChu("tên nhà sản xuất");
        String thoiGianBaoHanh = Regex.kiemTraThoiGianBaoHanh("thời gian bảo hành");
        String phamViBaoHanh = Regex.kiemTraBaoHanh("phạm vi bảo hành");
        Mobile dienthoai = new ChinhHang(id, tenDienThoai, giaBan, soLuong, tenNhaSanXuat, thoiGianBaoHanh, phamViBaoHanh);
        LuuFileCSV.ghiFile(dienthoai, "thêm");
        System.out.println("Thêm sản phẩm chính hãng thành công !");
    }

    public static void themDienThoaiXachTay() {
        int id = capNhatBienDem();
        String tenSanPham = Regex.kiemTraNhapChu("tên sản phẩm");
        String giaBan = Regex.kiemTraNhapSo("giá bán");
        String soLuong = Regex.kiemTraNhapSo("số lượng");
        String tenNhaSanXuat = Regex.kiemTraNhapChu("tên nhà sản xuất");
        String quocGiaXachTay = Regex.kiemTraQuocGia("tên Quốc Gia xách tay");
        String trangThai = Regex.kiemTraTrangThai("trạng thái");
        Mobile dienThoai = new XachTay(id, tenSanPham, giaBan, soLuong, tenNhaSanXuat, quocGiaXachTay, trangThai);
        LuuFileCSV.ghiFile(dienThoai, "thêm");
        System.out.println("Thêm sản phẩm xách tay thành công !");
    }
}

