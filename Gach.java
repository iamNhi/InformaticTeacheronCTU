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
public class Gach {
    //Thuộc tính   
    private String maSo;
    private String mauSac;
    private int soLuong;
    private int chieuDai;
    private int chieuNgang;
    private long giaBan;
    //Phương thức
    //Hàm xây dựng mặc nhiên
    Gach(){
        maSo = null;
        mauSac = null;
        soLuong = 0;
        chieuDai = 0;
        chieuNgang = 0;
        giaBan = 0;
    }

    //Hàm xây dựng có các tham số
    Gach(String maSo, String mauSac, int soLuong, int chieuDai, int chieuNgang, long giaBan){
        this.maSo = maSo;
        this.mauSac = mauSac;
        this.soLuong = soLuong;
        this.chieuDai = chieuDai;
        this.chieuNgang = chieuNgang;
        this.giaBan = giaBan;     
    }

    //Getter
    public long getGiaBan() {
        return giaBan;
    }
    
    
    //Hàm nhập thông tin của 1 hôp gạch
    public void nhapThongTin(){
        Scanner s = new Scanner(System.in);
        System.out.print("Nhập vào mã số: ");
        maSo = s.nextLine();
        System.out.print("\nNhập vào màu sắc: ");
        mauSac = s.nextLine();
        System.out.print("\nNhập vào số lượng: ");
        soLuong = s.nextInt();
        System.out.print("\nNhập vào chiều dài: ");
        chieuDai = s.nextInt();
        System.out.print("\nNhập vào chiều ngang: ");
        chieuNgang = s.nextInt();
        System.out.print("\nNhập vào giá bán: ");
        giaBan = s.nextLong();
        
    }
    //Hàm hiển thị thông tin
    public void hienThi(){
        System.out.println("+ Mã số: " + maSo);
        System.out.println("+ Màu sắc: " + mauSac);
        System.out.println("+ Số lượng: " + soLuong);
        System.out.println("+ Chiều dài: "+ chieuDai);
        System.out.println("+ Chiều ngang: " + chieuNgang);
        System.out.println("+ Giá bán: " + giaBan);
    }
    //Hàm tính ra giá bán lẻ 1 viên gạch
    //Giá bán lẻ cao hơn giá bán nguyên hộp 20%
    public float giaBanLe(){
        return (float)giaBan/soLuong;
    }
    //Hàm tính diện tích nền tối đa
    public int dienTichNenToiDa(){
        return (chieuDai * chieuNgang) * soLuong;
    }
    //Hàm tính ra số lượng hộp gạch có thể lót được của hộp gạch
    public int soLuongHop(int D, int N){
        //Số viên gạch theo chiều dài
        //Hàm ceil trong Math -> làm tròn lên
        double svd = Math.ceil((double) D /chieuDai);
        //Số viên gạch theo chiều ngang
        double svn = Math.ceil((double) N /chieuNgang);
        //Số lượng hộp gạch cần sử dụng
        //So sánh kiểu trả về trên hàm
        return (int)Math.ceil((svd*svn)/soLuong);
    }
}
