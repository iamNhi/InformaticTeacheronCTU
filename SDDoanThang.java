/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoanThang;

/**
 *
 * @author Admin
 */
public class SDDoanThang {
    public static void main(String []args){
        Diem A = new Diem(2, 5);
        Diem B = new Diem(20, 35);
        //Tạo đoạn thẳng AB
        DoanThang AB = new DoanThang(A, B);
        AB.tinhTuyen(5, 3);
        
        //Tạo đoạn thẳng CD nhập giá trị cho đoạn thẳng đó
        DoanThang CD = new DoanThang();
        CD.nhapDoanThang();
        System.out.println("Độ dài của đoạn thẳng CD: " + CD.tinhDoDai());
        System.out.println("Gốc của CD với trục hoành: " + CD.tinhGoc());
        
        
    }
}
