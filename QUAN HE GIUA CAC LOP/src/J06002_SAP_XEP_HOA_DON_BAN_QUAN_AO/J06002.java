package J06002_SAP_XEP_HOA_DON_BAN_QUAN_AO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class J06002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SanPham> sp = new ArrayList<>();
        while (n-- > 0) {
            SanPham x = new SanPham(sc.nextLine().trim(), sc.nextLine().trim(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
            sp.add(x);
        }
        ArrayList<HoaDon> res = new ArrayList<>();
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= m; i++) {
            String[] hd = (sc.nextLine()).trim().split("\\s+");
            String maSP = hd[0].substring(0, hd[0].length() - 1);
            String loaiSP = hd[0].substring(hd[0].length() - 1);
            long soLuong = Long.parseLong(hd[1]);
            for (SanPham h : sp) {
                if (h.getMaSP().equals(maSP)) {
                    long giamGia = 0;
                    long thanhTien = 0;
                    if (loaiSP.equals("1")) {
                        thanhTien += soLuong * h.getGiaLoai1();
                    } else {
                        thanhTien += soLuong * h.getGiaLoai2();
                    }
                    if (soLuong >= 150) {
                        giamGia += Math.round(50.0 / 100.0 * thanhTien);
                    } else if (soLuong >= 100) {
                        giamGia += Math.round(30.0 / 100.0 * thanhTien);
                    } else if (soLuong >= 50) {
                        giamGia += Math.round(15.0 / 100.0 * thanhTien);
                    }
                    long tongTien = thanhTien - giamGia;
                    String tmp = hd[0] + "-" + String.format("%03d", i);
                    res.add(new HoaDon(tmp, h.getTenSP(), giamGia, tongTien));
                    break;
                }
            }
        }
        Collections.sort(res, new Comparator<HoaDon>() {
            @Override
            public int compare(HoaDon o1, HoaDon o2) {
                if (o1.getTongTien() < o2.getTongTien()) return 1;
                else return -1;
            }
        });
        for (HoaDon hd : res) {
            System.out.println(hd);
        }
    }
}
