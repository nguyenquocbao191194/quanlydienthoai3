package bai_thi.commons;

import bai_thi.models.ChinhHang;
import bai_thi.models.Mobile;
import bai_thi.models.XachTay;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LuuFileCSV {
    private static final String DAU_PHAY = ",";
    private static final String XUONG_DONG = "\n";

    public static void ghiFile(Mobile dienThoai, String cachGhi) {
        File file = new File("src/bai_thi/data/mobile.csv");
        FileWriter fileWriter = null;
        BufferedWriter bf = null;
        try {
            if (cachGhi.equals("ghi đè")) fileWriter = new FileWriter(file);
            if (cachGhi.equals("thêm")) fileWriter = new FileWriter(file, true);
            if (fileWriter != null) {
                bf = new BufferedWriter(fileWriter);
                StringBuilder stringBuilder = new StringBuilder();
                if (dienThoai instanceof ChinhHang) {
                    stringBuilder.append(dienThoai.getId()).append(DAU_PHAY).append(DAU_PHAY)
                            .append(dienThoai.getTenDienThoai()).append(DAU_PHAY).append(dienThoai.getGiaBan()).append(DAU_PHAY)
                            .append(dienThoai.getSoLuong()).append(DAU_PHAY).append(dienThoai.getNhaSanXuat()).append(DAU_PHAY)
                            .append(((ChinhHang) dienThoai).getThoiGianBaoHanh()).append(DAU_PHAY)
                            .append(((ChinhHang) dienThoai).getPhamViBaoHanh());
                } else {
                    stringBuilder.append(dienThoai.getId()).append(DAU_PHAY).append(DAU_PHAY)
                            .append(dienThoai.getTenDienThoai()).append(DAU_PHAY).append(dienThoai.getGiaBan()).append(DAU_PHAY)
                            .append(dienThoai.getSoLuong()).append(DAU_PHAY).append(dienThoai.getNhaSanXuat()).append(DAU_PHAY)
                            .append(((XachTay) dienThoai).getQuocGiaXachTay()).append(DAU_PHAY)
                            .append(((XachTay) dienThoai).getTrangThai());
                }
                bf.write("1,2,3,4,5,6,7,8,9");
                bf.append(XUONG_DONG);
                bf.flush();
            }
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    if (bf != null) bf.close();
                    fileWriter.close();
                }
            } catch (IOException i) {
                i.printStackTrace();
            }
        }
    }

    public static void capNhatFile(List<Mobile> list) {
//        File file = new File("src/bai_thi/data/mobile.csv");
//        if (file.delete())
//            System.out.println("Cập nhật file sản phẩm !");
//        try {
//            if (file.createNewFile()) System.out.println("Cập nhật thành công !");
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
        int xacNhan = 1;
        if (list.isEmpty()) {
            File file = new File("src/bai_thi/data/mobile.csv");
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(file);
                fileWriter.append("");
            } catch (FileNotFoundException f) {
                System.out.println(f.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
        } else {
            for (Mobile dienThoai : list) {
                if (xacNhan == 1) ghiFile(dienThoai, "ghi đè");
                else ghiFile(dienThoai, "thêm");
                xacNhan++;
            }
        }
    }

    public static List<Mobile> docFile() {
        List<Mobile> list = new ArrayList<>();
        File file = new File("src/bai_thi/data/mobile.csv");
        if (file.isFile()) {
            FileReader fileReader = null;
            BufferedReader br = null;
            try {
                fileReader = new FileReader(file);
                br = new BufferedReader(fileReader);
                Mobile dienThoai;
                String[] temp;
                String line;
                while ((line = br.readLine()) != null) {
                    temp = line.split(DAU_PHAY);
                    if (temp.length == 6) {
                        dienThoai = new ChinhHang(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
                        list.add(dienThoai);
                    }
                    if (temp.length == 9) {
                        dienThoai = new XachTay(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
                        list.add(dienThoai);
                    }
                }
            } catch (FileNotFoundException f) {
                System.out.println(f.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileReader != null) {
                        if (br != null) br.close();
                        fileReader.close();
                    }
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
        } else {
            try {
                if (file.createNewFile()) System.out.println("File đang trống !");
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
        return list;
    }
}

