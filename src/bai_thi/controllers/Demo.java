package bai_thi.controllers;
import bai_thi.commons.LuuFileCSV;
import bai_thi.commons.Regex;
import bai_thi.commons.Them;
import bai_thi.models.ChinhHang;
import bai_thi.models.Mobile;
import libs.SPException;

import java.util.List;
import java.util.Scanner;

public class Demo {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int luaChon;
        do {
            System.out.println("\n----- CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI -----" +
                    "\nChọn chức năng theo số (để tiếp tục): " +
                    "\n1. Thêm mới" +
                    "\n2. Xóa" +
                    "\n3. Xem danh sách" +
                    "\n4. Tìm kiếm" +
                    "\n5. Thoát");
            System.out.print("Chọn chức năng : ");
            String nhapLuaChon = scanner.nextLine();
            if (Regex.kiemTraNhapSoNguyen(nhapLuaChon)) {
                luaChon = Integer.parseInt(nhapLuaChon);
                switch (luaChon) {
                    case 1:
                        themSanPham();
                        break;
                    case 2:
                        xoaSanPham();
                        break;
                    case 3:
                        hienThi();
                        break;
                    case 4:
                        timKiem();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không tồn tại !");
                }
            } else System.out.println("Lựa chọn không hợp lệ !");
        } while (true);
    }

    public static void themSanPham() {
        int luaChon;
        do {
            System.out.println("==================================" +
                    "\nMenu: " +
                    "\n1. Thêm điện thoại chính hãng" +
                    "\n2. Thêm điện thoại xách tay" +
                    "\n3. Quay về menu chính" +
                    "\n4. Thoát\n" +
                    "==================================");
            System.out.print("Chọn thao tác muốn thực hiện : ");
            String nhapLuaChon = scanner.nextLine();
            if (Regex.kiemTraNhapSoNguyen(nhapLuaChon)) {
                luaChon = Integer.parseInt(nhapLuaChon);
                switch (luaChon) {
                    case 1:
                        Them.themdienthoaiChinhHang();
                        break;
                    case 2:
                        Them.themDienThoaiXachTay();
                        break;
                    case 3:
                        menu();
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không tồn tại !");
                }
            } else System.out.println("Lựa chọn không hợp lệ !");
        } while (true);
    }

    public static void xoaSanPham() {
        List<Mobile> list = LuuFileCSV.docFile();
        if (!list.isEmpty()) {
            do {
                try {
                    System.out.print("Nhập mã sản phẩm cần xóa : ");
                    String nhap = scanner.nextLine();
                    for (int i = 0; i < list.size(); i++) {
                        if (nhap.equals(list.get(i).getId())) {
                            do {
                                System.out.println("Bạn có thực sự muốn xóa sản phẩm này không ?!\nNhập Yes nếu muốn xóa !" +
                                        "\nNếu không thì nhập No :");
                                String chon = scanner.nextLine();
                                if (chon.equals("Yes")) {
                                    list.remove(i);
                                    LuuFileCSV.capNhatFile(list);
                                    hienThi();
                                    return;
                                }
                                if (chon.equals("No")) return;
                            } while (true);
                        }
                    }
                    throw new SPException();
                } catch (SPException n) {
                    n.getMassage();
                    System.out.println("Bạn có muốn quay về menu chính hay không ?! Ấn Enter để quay về ! Nhập No nếu muốn xóa tiếp !");
                    String luaChon = scanner.nextLine();
                    if (luaChon.equals("")) return;
                }
            } while (true);
        } else System.out.println("Hiện tại chưa có sản phẩm nào !");
    }

    public static void hienThi() {
        List<Mobile> list = LuuFileCSV.docFile();
        if (!list.isEmpty()) {
            int bienDem = 1;
            System.out.println("Danh sách các sản phẩm hiện tại là :");
            for (Mobile dienThoai : list) {
                System.out.println("Sản phẩm " + bienDem + dienThoai);
                bienDem++;
            }
        } else System.out.println("Hiện tại chưa có sản phẩm nào !");
    }

    public static void timKiem() {
        List<Mobile> list = LuuFileCSV.docFile();
        if (!list.isEmpty()) {
            System.out.print("Nhập mã hoặc tên của sản phẩm bạn muốn tìm kiếm : ");
            String nhap = scanner.nextLine();
            boolean kiemTra = true;
            int bienDem = 1;
            for (Mobile dienThoai : list) {
                if (dienThoai.getTenDienThoai().contains(nhap) || dienThoai.getNhaSanXuat().contains(nhap)) {
                    kiemTra = false;
                    System.out.println("Sản phẩm " + bienDem + dienThoai);
                    bienDem++;
                }
            }
            if (kiemTra) System.out.println("Không tồn tại sản phẩm nào khớp với thông tin bạn nhập !");
        } else System.out.println("Hiện tại chưa có sản phẩm nào !");
    }
    
    
}

