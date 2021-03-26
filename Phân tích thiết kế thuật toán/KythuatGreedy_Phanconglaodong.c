//Nguoi chon viec

#include <stdio.h>
#include <malloc.h>
#define size 100
typedef int keytype;
typedef float othertype;
 
typedef struct {
	int CN, CV, TG;
}Phancong;

typedef struct {
	int TG, STT;
}Data;

void Read_Data(Data a[][size],int *n){
	FILE *f;
	f=fopen("PC lao dong.txt","r");
	if(f==NULL){
		printf("!!!!!!!ERORR!!!!!!!");
		return;
	}
	fscanf(f, "%d", n);
	
	int j,i;
	for( i =0; i<*n; i++){
		for( j =0; j<*n; j++){
			fscanf(f, "%d", &a[i][j].TG);
			a[i][j].STT = 0;
		}
	}
	fclose(f);
}

void PrintData(Data a[size][size], int n){
	int i, j;
	printf("Ma tran thoi gian da cho ...\n");
	for(i= 0; i< n; i++){
		for(j=0; j<n; j++){
			printf("%3d", a[i][j].TG);
		}
		printf("\n");
	}
}

void CapNhatCongViec(Data a[][size], int n, int j){
	int i;
	for(i=0; i<n; i++){
		a[i][j].STT = 1;
	}
}

int MinOfRow(Data a[][size], int n, int i, int *j){
	int TGmin = 32767, k;
	for(k = 0; k<n; k++){
		if(a[i][k].STT == 0 && a[i][k].TG == TGmin){
			TGmin = a[i][k].TG;
			*j=k;
		}
		return TGmin;
	}
	
}

void Greedy(Data a[][size], int n, Phancong PA[]){
	int j,i;
	for(i = 0; i<n; i++){
		PA[i].CN = i+1;
		PA[i].TG = MinOfRow(a, n, i, &j);
		PA[i].CV = j + 1; 
		CapNhatCongViec(a, n, j);
	}
}

void PrintPA(Phancong PA[], int n){
	int i;
	 int sum = 0;
	printf("\n Ky thuat tham an: Nguoi chon viec \n Phuong an phan cong nhu sau: \n");
	
	printf("Cong nhan	Cong viec	Thoi gian thuc hien\n");
	for(i=0; i<n; i++){
		printf("%4d		%4d %15d\n", PA[i].CN, PA[i].CV, PA[i].TG);
		sum += PA[i].TG;
	}
	printf("Tong thoi gian thuc hien la: %d\n", sum);
	
}

// Driver program to test above functions int main() 
int main(){
	Data a[size][size];
	int n;
	Read_Data(a, &n);
	Phancong PA[n];
	PrintData(a, n);
	Greedy(a, n, PA);
	PrintPA(PA, n);
    return 0; 
} 


