package bai_thi.models;

public class XachTay extends Mobile{
    private String quocGiaXachTay;
    private String trangThai;

    public XachTay(){
    }

    public XachTay(int id, String tenDienThoai, String giaBan, String soLuong, String nhaSanXuat,
                     String quocGiaXachTay, String trangThai) {
        super(id, tenDienThoai, giaBan,soLuong, nhaSanXuat);
        this.quocGiaXachTay = quocGiaXachTay;
        this.trangThai = trangThai;
    }

    public String getQuocGiaXachTay() {
        return quocGiaXachTay;
    }

    public void setQuocGiaXachTay(String quocGiaXachTay) {
        this.quocGiaXachTay = quocGiaXachTay;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "id: " + this.getId() + "tên Điện Thoại: " + this.getTenDienThoai() + "Giá Bán: " + this.getGiaBan() +
                "Nhà Sản Xuất: " + this.getNhaSanXuat() + "Quốc Gia Xách Tay: " + this. getQuocGiaXachTay() +
                "Trạng Thái: " + this.getTrangThai();
    }
}
