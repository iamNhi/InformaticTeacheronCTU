//Bài toán cái balo1 - Kỹ thuật tham ăn
/* Trọng lượng balo, n dòng
- Trọng lượng đồ vật lớn nhất hoặc bằng trọng lượng đã cho
- Giá trị đồ vật in ra giá trị đồ vật 
- Tên đồ vật 
=====> Số lượng đồ vật KHÔNG hạn chế
=========> Tìm đồ vật tổng trọng lượng không vượt quá trọng lượng balo
& Tổng giá trị lớn nhất
Gồm các hàm: 
- Đọc file
- In file
- Hoán đổi
- Sắp xếp
- Tham ăn
- main
*/ 

#include<stdio.h>
//Hàm cấp phát bộ nhớ
#include<malloc.h>
#include<string.h>

typedef struct{
	char TenDV[20];
	//Trọng lượng*đơn giá = giá trị
	float TL, GT, DG;
	int So_DV_duoc_chon;
}doVat;

//Đọc dữ liệu từ File, xác định trọng lượng balo *W, số lượng đồ vật *n
//Xác định được danh sách đồ vật
doVat *ReadFromFile(float *W, int *n){
	FILE *f;
	f = fopen("Balo1.txt", "r");
	fscanf(f, "%f", W); //Xác định trọng lượng Balo
	//Mảng động của các đồ vật
	doVat *dsdv;
	//Cấp phát đúng một đồ vật
	dsdv = (doVat*)malloc(sizeof(doVat));
	int i=0;
	//Sử dụng bộ nhớ một cách tối ưu
	//Có bao nhiêu đồ vật thì cấp phát bấy nhiêu ô
	while(!feof(f)){
		//Nếu như gặp xuống dòng thì thay
		fscanf(f, "%f%f%[^\n]", &dsdv[i].TL, &dsdv[i].GT, &dsdv[i].TenDV);
		dsdv[i].DG = dsdv[i].GT / dsdv[i].TL;
		dsdv[i].So_DV_duoc_chon = 0;
		i++;
		//Cấp phát thêm ô cho danh sách đồ vật
		dsdv = realloc(dsdv, sizeof(doVat)*(i+1));
		// Dùng C++ => realloc
	}
		*n=i;
		fclose(f);
		return dsdv;
}

void Swap(doVat *x, doVat *y){
	doVat temp;
	temp = *x;
	*x = *y;
	*y = temp;
}

//Sắp xếp các đồ vật giảm dần từ cao đến thấp của đơn giá
void BubbleSort(doVat *dsdv, int n){
	int i, j;
	for(i = 0; i <= n-2; i++){
		for(j = n-1; j>= i+1; j--){
			//Nếu đồ vật j lớn hơn đồ vật đứng trước nó, thì đổi chỗ đồ vật
			if(dsdv[j].DG > dsdv[j-1].DG)
				Swap(&dsdv[j],&dsdv[j-1]);
		}
	}
}

void Print_DSDV(doVat *dsdv, int n, float W){
	int i; 
	float TongTL = 0.0, TongGT = 0.0;
	printf("\n Phuong an thu duoc tu ky thuat Greedy: \n");
	printf("-----------------------------------------------------------------------\n");
	printf("|---|-------------------|---------|---------|---------|-----------------|\n");
	printf("|STT|	Ten do vat      | T.luong | Gia tri | Don gia | So DV duoc chon |\n");
	printf("|---|-------------------|---------|---------|---------|-----------------|\n");
	for(i = 0; i < n; i++){
	printf("|%-3d|%-17s|%9.2f|%9.2f|%9.2f|%8d         |\n",i+1, dsdv[i].TenDV, dsdv[i].TL, dsdv[i].GT, dsdv[i].DG, dsdv[i].So_DV_duoc_chon);
	TongTL = TongTL +  dsdv[i].So_DV_duoc_chon * dsdv[i].TL;
	TongGT = TongGT + dsdv[i].So_DV_duoc_chon * dsdv[i].GT;
	}
	printf("|---|-------------------|---------|---------|---------|-----------------|\n");
	printf("\nTrong luong cua balo = %-9.2f\n",W);
	printf("\nTong trong luong cac vat duoc chon = %-9.2f \n\nTong gia tri = %-9.2f\n", TongTL, TongGT);
}

void Greedy(doVat *dsdv, int n, float W){
	int i;
	for(i = 0; i < n; i++){
		//Xác định đồ vật được chọn 
		dsdv[i].So_DV_duoc_chon = (W/dsdv[i].TL);
		//Xác định lại trọng lượng của balo
		W = W - dsdv[i].So_DV_duoc_chon * dsdv[i].TL;
	}
}

int main(){
	int n;
	float W;
	doVat *dsdv; 
	//Xác định được DSDV
	dsdv = ReadFromFile(&W, &n);
	//Sắp xếp đồ vật giảm dần theo đơn giá
	BubbleSort(dsdv, n);
	//Sử dụng Tham ăn để xác định đồ vật được chọn
	Greedy(dsdv, n, W);
	Print_DSDV(dsdv, n, W);
	//Giải phóng bộ nhớ, khi trước đó sử dụng Malloc (realloc)
	free(dsdv);
	return 0;
}

