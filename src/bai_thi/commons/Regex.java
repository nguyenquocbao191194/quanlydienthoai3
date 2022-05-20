package bai_thi.commons;

import java.util.Scanner;

public class Regex {
    public static Scanner scanner = new Scanner(System.in);

    public static boolean kiemTraNhapSoNguyen(String nhap) {
        return nhap.matches("\\d+");
    }

    public static boolean kiemTraNhapSoThuc(String nhap) {
        return nhap.matches("\\d+(\\.\\d+)?");
    }

    public static String kiemTraNhapSo(String thongTin) {
        String nhapThongTin;
        do {
            System.out.print("Nhập " + thongTin + " : ");
            nhapThongTin = scanner.nextLine();
            if (kiemTraNhapSoThuc(nhapThongTin) && Float.parseFloat(nhapThongTin) > 0) break;
            else System.out.println("Thông tin không hợp lệ !");
        } while (true);
        return nhapThongTin;
    }

    public static String kiemTraNhapChu(String thongTin){
        String nhapThongTin ;
        do {
            System.out.print("Nhập " + thongTin + " : ");
            nhapThongTin = scanner.nextLine();
            if (nhapThongTin.equals("")) System.out.println("Thông tin không được bỏ trống !");
            else break;
        } while (true);
        return nhapThongTin;

    }

    public static String kiemTraQuocGia(String thongTin){
        String nhapThongTin ;
        do {
            System.out.print("Nhập " + thongTin + " : ");
            nhapThongTin = scanner.nextLine();
            if (nhapThongTin.equals("Viet Nam")) System.out.println("Nhap lai!");
            else break;
        } while (true);
        return nhapThongTin;
    }

    public static String kiemTraBaoHanh(String thongTin){
        String nhapThongTin ;
        do {
            System.out.print("Nhập " + thongTin + " : ");
            nhapThongTin = scanner.nextLine();
            if (nhapThongTin.equals("Toan Quoc")||nhapThongTin.equals("Quoc Te")) System.out.println("Nhap Lai!");
            else break;
        } while (true);
        return nhapThongTin;
    }

    public static String kiemTraTrangThai(String thongTin){
        String nhapThongTin ;
        do {
            System.out.print("Nhập " + thongTin + " : ");
            nhapThongTin = scanner.nextLine();
            if (nhapThongTin.equals("Da sua chua")||nhapThongTin.equals("Chua sua chua")) System.out.println("Nhap Lai!");
            else break;
        } while (true);
        return nhapThongTin;
    }

    public static String kiemTraThoiGianBaoHanh(String thongTin) {
        String nhapThongTin;
        do {
            System.out.print("Nhập " + thongTin + ": ");
            nhapThongTin = scanner.nextLine();
            if (kiemTraNhapSoThuc(nhapThongTin) && Float.parseFloat(nhapThongTin) <= 730) break;
            else System.out.println(thongTin + " < 730 days!");
        } while (true);
        return nhapThongTin;
    }
}

