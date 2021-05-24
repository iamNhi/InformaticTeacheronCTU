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
public class SDSVCNTT {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        
        System.out.print("Nhập vào số sinh viên");
        n = s.nextInt();
        SinhVienCNTT[] SV = new SinhVienCNTT[n];
        for(int i = 0; i < n; i++){
            SV[i] = new SinhVienCNTT();
            System.out.print("Nhập vào thông tin sinh viên thứ "+ (i + 1) + ": ");
            SV[i].nhapThongTin();
        }
        
        String email;
        System.out.print("Nhập vào email cần tìm: ");
        email = s.nextLine();
        for(int i = 0; i < n ; i++){
            if(SV[i].getEmail().compareTo(email) == 0){
                //Hiển thị KQ
                
                break;
            }
        }
    }
}
