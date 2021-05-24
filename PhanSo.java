/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhanSo;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class PhanSo {
    private int tuSo;
    private int mauSo;
    //Hàm xây dựng mặc nhiên
    PhanSo(){
        tuSo = 0;
        mauSo = 1; 
    }
    //Hàm xây dựng 2 phân số
    PhanSo(int tuSo, int mauSo){
        this.mauSo = mauSo;
        this.tuSo = tuSo;
    }

    public int getTuSo() {
        return tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public void setMauSo(int mauSo) {
        this.mauSo = mauSo;
    }
    
    //Hàm sao chép sâu, dùng cho việc hoán vị 
    public void deepCopy(PhanSo a){
        tuSo = a.tuSo;
        mauSo = a.mauSo;
    }
  
    PhanSo(InputStream in) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //Hàm nhập giá trị cho một phân số 
    public void nhapPhanSo(){
        Scanner s = new Scanner(System.in); 
        do {
            System.out.print("Nhập vào tử số: ");
            tuSo = s.nextInt();
            System.out.print("Nhâp vào mẫu số: ");
            mauSo = s.nextInt();
            
            if(mauSo == 0)
                System.out.println("Mẫu số không hợp lệ, mẫu số phải khác 0.");
        }
        while (mauSo == 0);
    }
    //Hàm hiển thị phân số
    public void hienThiPhanSo(){
        if(tuSo == 0)
            System.out.println("0");
        else if(mauSo == 1)
            System.out.println(tuSo);
        else if(mauSo < 0)
            System.out.print("-" + tuSo + "/" + (-mauSo));
            else 
            System.out.print(tuSo + "/" + mauSo);
    }
    //Hàm nghịch đảo phân số, làm thay đổi giá trị phân số
    public void nghichDao(){
        int tmp;
        tmp = tuSo;
        tuSo = mauSo;
        mauSo = tmp; 
    }
    //Hàm tính ra giá trị của phân số
    public PhanSo giaTriNghichDao(){
      PhanSo ps = new PhanSo();
      ps.tuSo = mauSo; 
      ps.mauSo = tuSo;
      return ps;
    }
    //Hàm tính giá trị thực
    public double giaTriThuc(){
        return (double)tuSo / mauSo;
    }
    public boolean lonHon(PhanSo a){
        return this.giaTriThuc() > a.giaTriThuc();
    }
    //Hàm cộng phân số 
    //Hàm sẽ được gọi thông qua một đối tượng nào đó 
    public PhanSo cong(PhanSo a){
        //nhân chéo
        PhanSo kq = new PhanSo();
        kq.mauSo = this.mauSo * a.mauSo;
        kq.tuSo = this.tuSo * a.mauSo + this.mauSo * a.tuSo;
        return kq;
    }
    //Hàm trừ phân số
    public PhanSo tru(PhanSo a){
        //nhân chéo
        PhanSo kq = new PhanSo();
        kq.mauSo = this.mauSo * a.mauSo;
        kq.tuSo = this.tuSo * a.mauSo - this.mauSo * a.tuSo;
        return kq;
    }
    //Nhân phân số
    public PhanSo nhan(PhanSo a){
        //nhân chéo
        PhanSo kq = new PhanSo();
        kq.mauSo = this.mauSo * a.mauSo;
        kq.tuSo = this.tuSo * a.tuSo;
        return kq;
    }
    //Hàm chia phân số
    public PhanSo chia(PhanSo a){
        //nhân chéo
        return this.nhan(a.giaTriNghichDao());
    }
    
    //Viết các hàm cộng, trừ,... với 1 số nguyên
    public PhanSo cong(int a){
        //Tạo ra một phân số có mẫu là 1, tử là a
        return this.cong(new PhanSo(a, 1));
    }
    
    public PhanSo tru(int a){
        //Tạo ra một phân số có mẫu là 1, tử là a
        return this.tru(new PhanSo(a, 1));
    }
    public PhanSo nhan(int a){
        //Tạo ra một phân số có mẫu là 1, tử là a
        return this.nhan(new PhanSo(a, 1));
    }
    public PhanSo chia(int a){
        //Tạo ra một phân số có mẫu là 1, tử là a
        return this.chia(new PhanSo(a, 1));
    }
    
}
