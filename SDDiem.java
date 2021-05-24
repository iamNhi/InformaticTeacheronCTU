/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Diem;

/**
 *
 * @author student
 */
public class SDDiem {
    public static void main(String[] args){
        Diem A = new Diem(3, 4);
        System.out.print("Diem A");
        A.hienThi();
        
        Diem B = new Diem();
        System.out.println("\nNhap B: ");
        B.nhapDiem();
        System.out.print("\nDiem B");
        B.hienThi();
        //Tạo ra điểm C đối xứng với B  
        Diem C = new Diem(-B.giaTriX(), -B.giaTriY());
        System.out.print("\nDiem C");
        C.hienThi();
        System.out.print("Khoang cach tu diem B den tam O: " + B.khoangCach());
        System.out.println("\nKhoang cach tu diem A den B: " + A.khoangCach(B));
        
    }
    
}
