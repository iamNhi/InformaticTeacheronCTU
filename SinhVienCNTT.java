/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinhVienCNTT;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class SinhVienCNTT extends SinhVien {
	private String taikhoan;
	private String matkhau;
	private String email;
	// Ham xay dung
	public SinhVienCNTT() {
		super();
		taikhoan = new String();
		matkhau = new String();
		email = new String();
	}
	// Ham xay dung sao chep
	public SinhVienCNTT(SinhVienCNTT a) {
		super(a);
		taikhoan = new String(a.taikhoan);
		matkhau = new String(a.matkhau);
		email = new String(a.email);
	}
	// Ham sao chep sau
	public void makeCopy(SinhVienCNTT a) {
		super.makeCopy(a);
		taikhoan = a.taikhoan;
		matkhau = a.matkhau;
		email = a.email;
	}
	// Cac ham (phuong thuc) khac
	public void nhap() {
		super.nhapThongTin();
		super.nhapDiem();
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhap tai khoan Elcit: ");
		taikhoan = kb.nextLine();
		System.out.print("Nhap mat khau Elcit: ");
		matkhau = kb.nextLine();
		System.out.print("Nhap email: ");
		email = kb.nextLine();
	}

	public void hienThi() {
		System.out.println(super.toString());
		System.out.println("Tai khoan: " + taikhoan);
		System.out.println("Mat khau: " + matkhau);
		System.out.println("Email: " + email);
	}

    public String getTaikhoan() {
        return taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public String getEmail() {
        return email;
    }
    
    public void doiMatKhau(String newpass){
        this.matkhau = newpass;
    }
    
        @Override
    public String toString(){
        String re;
        re = super.toString();
        re += ("+ Tài khoản Elcit: " + taikhoan + "\n");
        re += ("+ Mật khẩu elcit: " + matkhau + "\n");
        re += ("+ Email SV: "+ email + "\n");
        
        return re;
    }
    
    public String hienThiKQHT(){
        String res = "";
        res += "+ Tài khoản elcit" + taikhoan + "\n";
        
        return res;
    }

}

