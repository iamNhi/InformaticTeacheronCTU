/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Date;

/**
 *
 * @author student
 */
public class SDDate {
    public static void main(String[] args){
        Date d = new Date();
        System.out.println("Nhập ngày tháng năm: ");
        d.nhapNgay();
        System.out.println("Ngày đã nhập: ");
        d.hienThi();
        System.out.println("Ngày hôm sau: ");
        d.ngayHomSau().hienThi();
        System.out.println("Ngày đã cộng thêm: ");
        d.congNgay(5).hienThi();
    }
}
