/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiemMau;

/**
 *
 * @author Admin
 */
public class SDDiemMau {
    public static void main(String[] args){
       DiemMau A = new DiemMau(5, 10, "Trắng");
       //hiển thị thông tin
       System.out.print("A: ");
       A.hienThi();
       System.out.println();
       DiemMau B = new DiemMau();
       B.nhapDiem();
       
       B.doiDiem(10, 8);
       B.ganMau("Vàng");
        System.out.print("B: ");
       B.hienThi();
        
    }
    
}
