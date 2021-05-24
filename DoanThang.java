/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoanThang;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DoanThang {
    //Thuộc tính sử dụng lớp điểm có sẳn
    private Diem d1;
    private Diem d2;
    // Các hàm xây dựng
    //Hàm xây dựng mặc nhiên
    //Khởi tạo đối tượng
    DoanThang(){
        d1 = new Diem();
        d2 = new Diem();
    }
    //Hàm xây dựng có 2 tham số
    DoanThang(Diem a, Diem b){
        d1 = new Diem(a.giaTriX(), a.giaTriY());
        d2 = new Diem(b.giaTriX(), b.giaTriY());
    }
    //Hàm xây dựng có 4 tham số
    DoanThang(int ax, int ay, int bx, int by){
        d1 = new Diem(ax, ay);
        d2 = new Diem(bx, by);
    }
    
    //Các phương thức
    //Nhập độ dài của đoạn thẳng
    public void nhapDoanThang(){
        System.out.println("Nhập tọa độ điểm d1: ");
        d1.nhapDiem();
        System.out.println("Nhập tọa độ điểm d2: ");
        d2.nhapDiem();
    }
    //Hiển thị giá trị 2 đầu mút của đoạn thẳng
    public void hienThi(){
        d1.hienThi();
        System.out.print(" ");
        d2.hienThi();
    }
    //Tịnh tuyến đoạn thẳng đi 1 độ dời (dx, dy) nào đó.
    public void tinhTuyen(int dx,int dy){
        d1.doiDiem(dx, dy);
        d2.doiDiem(dx, dy);
    }
    //Tính độ dài của đoạn thẳng
    public double tinhDoDai(){
        //Công thức tính độ dài: AB = căn bậc 2(((xB - xA) mũ 2 + (yB - yA) mũ 2))
        return Math.sqrt(Math.pow(d1.giaTriX() - d2.giaTriX(),2) + Math.pow(d1.giaTriY() - d2.giaTriY(), 2));
    }
    //Tính góc của đoạn thẳng với trục hoành (Radian)
    public double tinhGoc(){
        //Công thức tính góc của đoạn thẳng với trục hoàng
        return Math.acos(Math.abs(d2.giaTriX() - d1.giaTriX())/ this.tinhDoDai());
    }

    
}
