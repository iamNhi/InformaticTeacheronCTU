/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gach;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class SDGach {
    public static void main(String []args){
        //Nhập vào
        Scanner s = new Scanner(System.in);
        int n; 
        System.out.print("Nhập số loại gạch: ");
        n = s.nextInt();
        //Khởi tạo một mảng có n phần tử (mảng các tham chiêu)
        Gach gach[] = new Gach[n];
        for(int i = 0; i < n; i++){
            //tạo ra các đối tượng gạch
            gach[i] = new Gach();
            System.out.print("Nhập vào thông tin loại gạch thứ " + (i+1) +": ");
            gach[i].nhapThongTin();
        }
        //Hiển thị thông tin của các loại gạch vừa nhập
        for(int i = 0 ; i< n; i++){
            System.out.println("Thông tin loại gạch thứ " + (i+1) + ": ");
            gach[i].hienThi();
        }
        //Hiển thị loại gạch có chi phí lót thấp nhất
        //Tham chiếu đến loại gạch đầu tiên
        Gach g = gach[0]; //tham chiếu đến loại thấp nhất
        //Sử dụng getter để lấy giá tiền đã khai báo thuộc tính ra
        //Giá bán / diện tích nền tối đa
        double min_cp = (double)gach[0].getGiaBan() / gach[0].dienTichNenToiDa();
        //Tính chi phí
        for(int i = 1; i < n; i++){
            if((double)gach[i].getGiaBan() / gach[i].dienTichNenToiDa() < min_cp){
                min_cp = (double)gach[i].getGiaBan() / gach[i].dienTichNenToiDa();
                //Giống con trỏ ở C, trỏ vào chi phí thấp
                g = gach[i];
            }
        }
        System.out.println("Loại gạch có chi phí lót thấp nhất là: ");
        g.hienThi();
        //Chi phí mua gạch
        for(int i = 0; i < n; i++){
            //đổi qua cm
            double cp = gach[i].soLuongHop(2000, 500)* gach[i].getGiaBan();
            System.out.println("Chi phí lót của loại gạch thứ " + (i+1) + ":" + cp);
        }
    }
}
