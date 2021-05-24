/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Diem;

import java.util.Scanner;

/**
 *
 * @author student
 */
public class Diem {
    //Cài đặt thuộc tính 
    private int x; 
    private int y;
    //Hàm xây dựng mặc nhiên 
    Diem(){
        //Khởi tạo x,y = 0
        x = y = 0;
    }
    //Hàm xây dựng hai tham số
    Diem(int x, int y){
        //con trỏ this, tham chiếu đến đối tượng
        this.x = x; 
        this.y = y;
    }
    
    public void nhapDiem(){
        Scanner s = new Scanner(System.in);
        System.out.println("Nhap vap hoang do x: ");
        x = s.nextInt();
        System.out.println("Nhap vao tung do y: ");
        y = s.nextInt();
    }
    //Hiển thị tọa độ
    public void hienThi(){
        System.out.println("(" + x + "," + y + ")");
    }
    //Hàm dời điểm
    public void doiDiem(int dx, int dy){
        x += dx;
        y += dy;
    }
    //Hàm lấy ra giá trị
    public int giaTriX(){
        return x;
    }
    public int giaTriY(){
        return y;
    }

    public float khoangCach(){
        return (float) Math.sqrt( x * x + y * y);
    }
    public float khoangCach(Diem d){
        return (float) Math.sqrt((x - d.x) *(x - d.x) + (y - d.y) * (y - d.y));
        
    }
    
    
}
