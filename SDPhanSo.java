/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhanSo;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class SDPhanSo {
    public static void main(String[] args){
       /*
        PhanSo a = new PhanSo(3,7);
        PhanSo b = new PhanSo(4,9);
        a.hienThiPhanSo();
        b.hienThiPhanSo();
        
        PhanSo x = new PhanSo();
        PhanSo y = new PhanSo();
        System.out.print("Nhập phân số x: \n");
        x.nhapPhanSo();
        System.out.println("Nhập vào phân số y: ");
        y.nhapPhanSo();
        //Hiển thị giá trị nghịch đảo của x ra, không làm thay đổi giá trị
        System.out.print("Giá trị nghịch đảo của x là: ");
        x.giaTriNghichDao().hienThiPhanSo();
        System.out.print("\nx + y = ");
        x.cong(y).hienThiPhanSo();
        //Nhập vào 1 ds gồm n phân số 
        */
       int n;
       Scanner s = new Scanner(System.in);
       
        System.out.print("Nhập vào n: ");
        
        n = s.nextInt();
        //Tạo ra 1 mảng gồm có n tham chiếu
        PhanSo ps[]= new PhanSo[n];
        PhanSo sum = new PhanSo();
        //Tạo ra đối tượng để tham chiếu chiếu vào đối tượng
        for(int i= 0; i< n; i++){
            ps[i] = new PhanSo();
            System.out.println("Nhập vào phân số thứ " + (i +1) + ":");
            ps[i].nhapPhanSo();
            sum = sum.cong(ps[i]);
        }
        System.out.print("Tổng của " + n + " phân số là: ");
        sum.hienThiPhanSo();
        
        System.out.println("Tìm phân số lớn nhất trong danh sách số trên");
        //Tạo thêm các get bên các hàm
        //Khởi tạo phân số max = giá trị đầu tiên
        PhanSo max = new PhanSo(ps[0].getTuSo(), ps[0].getMauSo());
        for(int i = 1; i < n; i++){
            //Nếu sử dụng giá trị thực thì không cần setter
            //if(max.giaTriThuc() < ps[i].giaTriThuc())
            //Tạo ra các setter d
            if(ps[i].lonHon(max)){
                max.setTuSo(ps[i].getTuSo());
                max.setMauSo(ps[i].getMauSo());
            }
        }
        System.out.print("\nPhân số lớn nhất là: ");
        max.hienThiPhanSo();
        //Sắp xếp ds phân số theo thứ tự tăng dần
        PhanSo tmp = new PhanSo();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(ps[i].lonHon(ps[j])){
                    //Thực hiện hoán đổi hai giá trị i và j bằng cách
                    //Viết hàm sao chép sâu, sao chép giá trị của i, j
                    //Rồi hoán đổi như các hàm Swap bình thường
                    tmp.deepCopy(ps[i]);
                    ps[i].deepCopy(ps[j]);
                    ps[j].deepCopy(tmp);
              }
          }
        }
        System.out.println("\n Dãy phân số có thứ tự là: ");
        for(int i = 0; i < n; i++){
            ps[i].hienThiPhanSo();
            System.out.print(" ");
        }
    }
}