package bai_thi.models;

public class ChinhHang extends Mobile {
    private String thoiGianBaoHanh;
    private String phamViBaoHanh;

    public ChinhHang() {
    }

    public ChinhHang(int id, String tenDienThoai, String giaBan, String soLuong, String nhaSanXuat,
                     String thoiGianBaoHanh, String phamViBaoHanh) {
        super(id, tenDienThoai, giaBan,soLuong, nhaSanXuat);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public String getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(String thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getPhamViBaoHanh() {
        return phamViBaoHanh;
    }

    public void setPhamViBaoHanh(String phamViBaoHanh) {
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String toString() {
        return "id: " + this.getId() + "tên Điện Thoại: " + this.getTenDienThoai() + "Giá Bán: " + this.getGiaBan() +
                "Nhà Sản Xuất: " + this.getNhaSanXuat() + "Thời Gian Bảo Hành: " + this. getThoiGianBaoHanh() +
                "Phạm vi bảo hành: " + this.getPhamViBaoHanh();
    }
}
