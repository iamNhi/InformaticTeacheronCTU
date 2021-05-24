/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiemMau;

import java.util.Scanner;

/**
 *
 * @author student
 */
public class DiemMau extends Diem {

    //Không cần khai báo thêm các thuộc tính của điểm x, y
    private String mau;
    //Hàm xây dựng măc nhiên
    DiemMau(){
        super();
        this.mau = null;
    }
    //Hàm xây dựng
    DiemMau(int x, int y, String mau) {
        //Gọi lại hàm, sử dụng super
        super(x, y);
        this.mau = mau;
    }

    //Hàm gán giá trị màu cho điểm
    //Sử dụng Setter
    public void ganMau(String mau) {
        this.mau = mau;
    }

    //Hàm nhập
    @Override
    public void nhapDiem() {
        Scanner s = new Scanner(System.in);
        super.nhapDiem();
        System.out.print("Nhập màu: ");
        mau = s.nextLine();
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.print(", " + mau);
    }

}
