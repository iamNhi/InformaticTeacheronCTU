/* Cái balo3 - Sử dụng kỹ thuật Tham ăn (Greedy)
Trọng lượng W, n loại đồ vật
- Trọng lượng Gi
- Giá trị Vi	
- Số lượng Fi
- Tên đồ 
===> Mỗi loại đồ vật có một số lượng đồ vật đã cho là Fi
=========> Tìm đồ vật tổng trọng lượng không vượt quá trọng lượng balo
& Tổng giá trị lớn nhất
*/

/* B1: 
- Tổng giá trị TGT = 0
- Cận trên của nút gốc CT = W * Đơn giá lớn nhất
B2: 
TGT = TGT (của nút cha) + số đồ vật được chọn * giá trị mỗi vật;
+ W = W (của nút cha) - số đồ vật được chọn * trọng lượng mỗi vật;
+ CT = TGT + W * Đơn giá của vật sẽ được XÉT KẾ TIẾP
*/
#include<stdio.h>
//Cấp phát bộ nhớ 
#include<malloc.h>
#include<string.h>

typedef struct{
	
}

