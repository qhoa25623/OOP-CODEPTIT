package DANH_SACH_LIEN_LAC;

public class sinhVien {
    private String maSV, hoTen, lop, email, sdt;

    public sinhVien() {
    }

    public sinhVien(String maSV, String hoTen, String lop, String email, String sdt) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lop = lop;
        this.email = email;
        this.sdt = sdt;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getLop() {
        return lop;
    }

    public String toString() {
        return this.maSV + " " + this.hoTen + " " + this.lop + " " + this.email + " " + "0" + this.sdt;
    }
}
