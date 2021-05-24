/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinhVienforThay;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MyDate {
    // Khai bao thuoc tinh
	private int ngay;
	private int thang;
	private int nam;
	// Ham xay dung
	public MyDate() {
		ngay = 1; thang = 1; nam = 2000;
	}
	public MyDate(int d, int m, int y) {
		ngay = d; thang = m; nam = y;
	}
	public MyDate(MyDate d) {		// Ham xay dung sao chep
		ngay = d.ngay;
		thang = d.thang;
		nam = d.nam;
	}

	// Ham sao chep sau
	public void makeCopy(MyDate d) {
		ngay = d.ngay;
		thang = d.thang;
		nam = d.nam;
	}

	// Cac phuong thuc
	public void hienThi() {
		System.out.print(ngay + "/" + thang + "/" + nam);
	}
	public String toString() {
		String ketqua = ngay + "/" + thang + "/" + nam;
		return ketqua;
	}
	public void nhap() {
		while(true) {
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap ngay: ");
			ngay = kb.nextInt();
			System.out.print("Nhap thang: ");
			thang = kb.nextInt();
			System.out.print("Nhap nam: ");
			nam = kb.nextInt();
			if(hopLe())		break;
			System.out.println("Ngay nhap khong hop le - Nhap lai.");
		}
	}
	public boolean hopLe() {
		if(ngay<=0 || thang<=0 || thang>12)
			return false;
		if(thang==2 && nam%4==0)
			return (ngay<=29);
		int songaymax[] = { 0,31,28,31,30,31,30,31,31,30,31,30,31 };
		return (ngay<=songaymax[ thang ]);
	}
	public MyDate ngayHomSau() {
		if(ngay==28 && thang==2 && nam%4==0)
			return new MyDate(29,2,nam);
		MyDate kq = new MyDate(ngay+1,thang,nam);
		int songaymax[] = { 0,31,28,31,30,31,30,31,31,30,31,30,31 };
		if(kq.ngay > songaymax[kq.thang]) {
			kq.thang++;
			kq.ngay=1;
		}
		if(kq.thang>12) {
			kq.nam++;
			kq.thang=1;
		}
		return kq;
	}
	public MyDate cong(int n) {
		MyDate kq = new MyDate(this);
		for(int i=0; i<n; i++)
			kq = kq.ngayHomSau();
		return kq;
	}

}
