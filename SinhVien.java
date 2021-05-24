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
public class SinhVien {
    private String MSSV;
    private String hoTen;
    private MyDate ngaySinh;
    private int soluongHP;
    private String tenHP[];
    private String diemHP[];
    
    //Hàm xây dựng
    public SinhVien(){
        MSSV = new String();
        hoTen = new String();
        ngaySinh = new MyDate();
        soluongHP = 0;
        tenHP = new String[20];
        diemHP = new String[20];
        for(int i=0; i < soluongHP; i++){
            tenHP[i] = new String();
            diemHP[i] = new String();
        }
    }
    
    public SinhVien(SinhVien s){
        MSSV = new String(s.MSSV);
        hoTen = new String(s.hoTen);
        ngaySinh = new MyDate(s.ngaySinh);
        soluongHP = s.soluongHP;
        tenHP = new String[20];
        diemHP = new String[20];
        for(int i = 0; i < soluongHP; i++){
            tenHP[i] = new String();
            diemHP[i] = new String();
        }
        for(int i = soluongHP; i < 20; i++){
            tenHP[i] = new String();
            diemHP[i] = new String();  
        }
    }
    
    //Hàm sao chép sâu
    public void makeCopy(SinhVien s){
        MSSV = s.MSSV;
        hoTen = s.hoTen;
        //Sao chép hàm myDate
        ngaySinh.makeCopy(s.ngaySinh);
        soluongHP = s.soluongHP;
        for(int i = 0; i < soluongHP; i++){
            tenHP[i] = s.tenHP[i];
            diemHP[i] = s.diemHP[i];
        }
    }
    //Hàm nhập
    public void nhapThongTin(){
        Scanner kb = new Scanner(System.in);
        System.out.print("Nhập MSSV: ");
        MSSV = kb.nextLine();
        System.out.print("Nhập Họ Tên SV: ");
        hoTen = kb.nextLine();
        //Sử dụng hàm riêng của lớp My Date
        System.out.print("Nhập ngày sinh: ");
        ngaySinh.nhap();
        System.out.print("Nhập số lượng HP đăng ký: ");
        soluongHP = kb.nextInt();
        //Bỏ qua phím Enter
        kb.nextLine();
        for(int i = 0; i < soluongHP; i++){
            System.out.print("Nhập tên học phần thứ " + (i+1) + ":");
            tenHP[i] = kb.nextLine();
        }
        
    }
    //Nhập điểm
    public void nhapDiem(){
        Scanner kb = new Scanner(System.in);
        for( int i = 0; i < soluongHP; i++){
            System.out.print("Điểm học phần " + tenHP[i] + ":");
            diemHP[i] = kb.nextLine();
            if( diemHopLe(diemHP[i]) == false){
                System.out.println("Điểm nhập không hợp lệ. Nhập lại!!!");
                i--;
            }
        }
    }
    //Hàm kiểm tra điểm có hợp lệ hay không
    //Giá trị trả về có hoặc không sử dụng boolean
    public boolean diemHopLe(String d){
        String diem[] = {"A", "B+", "B", "C+", "C", "D+", "D", "F"};
        //diem.length == n
        for(int i = 0; i < diem.length; i++ )
            if(d.equals(diem[i]))
                return true;
            return false;  
    }
    //Hàm toString: Xuất ra chuỗi là thông tin của sinh viên
    public String toString(){
        String kq = new String();
        kq = "+ MSSV: " + MSSV + "\n";
        kq = kq + "+ Họ tên: " + hoTen + "\n";
        kq = kq + "+ Ngày sinh: " + ngaySinh.toString() + "\n";
        kq = kq + "+ Số lượng học phần: " + soluongHP + "\n";
        for(int i = 0; i < soluongHP; i++)
            kq = kq + tenHP[i] + ": " + diemHP[i] + "\n";
            return kq;   
    }
    
    //Giả sử các môn có tính chỉ như nhau
    public float diemTB(){
        float tongdiem = 0;
        for(int i = 0; i < soluongHP; i++){
            if(diemHP[i].equals("A"))
                tongdiem = tongdiem + 4;
            if(diemHP[i].equals("B+"))
                tongdiem = tongdiem + (float) 3.5;
            if(diemHP[i].equals("B"))
                tongdiem = tongdiem + 3;
            if(diemHP[i].equals("C+"))
                tongdiem = tongdiem + (float) 2.5;
            if(diemHP[i].equals("C"))
                tongdiem = tongdiem + 2;
            if(diemHP[i].equals("D+"))
                tongdiem = tongdiem + (float) 1.5;
            if(diemHP[i].equals("D"))
                tongdiem = tongdiem + 1;
        }
        return (tongdiem/soluongHP);
    }
    //Thêm học phần
    public boolean themHocPhan(String hp){
        for(int i = 0; i < soluongHP ; i++)
            if(tenHP[i].equals(hp)) //Nếu trùng thì không thêm
                return false;
        tenHP[soluongHP] = hp;
        soluongHP ++;
        return true;
    }
    
    //Xóa học phàn
    public boolean xoaHocPhan(String hp){
        for(int i = 0; i < soluongHP; i++)
            if(tenHP[i].equals(hp)){
                //Dời các tên HP phía sau lên
                for(int j = i; j <soluongHP - 1; j++)
                    tenHP[j] = tenHP[j + 1];
                soluongHP --;
                return true;
            }
        return false;
    }
}
