/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinhVienforThay;

/**
 *
 * @author Admin
 */
public class SDSinhVien {
    public static void main(String[] args){
        SinhVien a = new SinhVien();
        a.nhapThongTin();
        a.themHocPhan("LTHDT");
        a.nhapDiem();
        System.out.println(a.toString());
        System.out.println("Điểm TB: " + a.diemTB());
        
    }
}
