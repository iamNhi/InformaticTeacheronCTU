/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Date;

import java.util.Scanner;

/**
 *
 * @author student
 */
public class Date {
    private int ngay;
    private int thang;
    private int nam;
    //Hàm xây dựng mặc nhiên, khởi tạo
    Date(){
        ngay = 1;
        thang = 1;
        nam = 1900;   
    }
    //Hàm xây dựng 3 tham số
    Date(int d, int m, int y){
        ngay = d;
        thang = m;
        nam = y;
    }
    public void hienThi(){
        System.out.println(ngay + "/" + thang + "/" + nam);
    }
    public boolean hopLe(){
        //Mảng lưu ngày tối đa của các tháng
        //Giá trị 0 là a[0], giá trị a[1] la 31 ngày
        int ngayTrongThang[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //Kiểm tra năm nhuận
        if(nam%400 == 0 || nam %4 == 0 && nam % 100 != 0 )
            ngayTrongThang[2] = 29;
        //Kiểm tra tháng
        if(thang<1 || thang >12)
            return false;
        return(ngay >= 1 || ngay <= ngayTrongThang[thang]);
    }
    //Hàm nhập ngày
    public void nhapNgay(){
        Scanner s = new Scanner(System.in);
    do {
        System.out.println("Nhập ngày: ");
        ngay = s.nextInt();
        System.out.println("Nhập tháng: ");
        thang = s.nextInt();
        System.out.println("Nhập năm: ");
        nam = s.nextInt();
        if(!this.hopLe())
            System.out.println("Nhập lại ngày tháng năm!!!");
    }
    while(!this.hopLe());
}
    //Hàm tính ngày hôm sau là ngày nào?
    public Date ngayHomSau(){
        Date tomorrow = new Date();
         int ngayTrongThang[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //Kiểm tra năm nhuận
        if(nam%400 == 0 || nam %4 == 0 && nam % 100 != 0 )
            ngayTrongThang[2] = 29;
        if (ngay >= 1 && ngay < ngayTrongThang[thang]){
            tomorrow.ngay = ngay + 1;
            tomorrow.thang = thang;
            tomorrow.nam = nam;
        }
        else {
            tomorrow.ngay = 1;
            tomorrow.thang = thang + 1;
            tomorrow.nam = nam;
        }
        if(tomorrow.thang == 13){
            tomorrow.thang = 1;
            tomorrow.nam++;
        }
        return tomorrow;
    }
    public Date congNgay(int n){
        Date d = new Date(ngay,thang, nam);
        for(int i = 0; i< n; i++)
            d = d.ngayHomSau();
        return d;
        
    }
    
}
