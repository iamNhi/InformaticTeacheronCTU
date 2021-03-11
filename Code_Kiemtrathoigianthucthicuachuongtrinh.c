#include <time.h>
#include <stdio.h>
//Kiểm tra thời gian thực hiện chương trình
int main(){
    clock_t start = clock();
	
    // Nhập đoạn mã kiểm tra thời gian vào đây
	//Enter your code test time here
	
    clock_t stop = clock();
    double elapsed = (double)(stop - start) * 1000.0 / CLOCKS_PER_SEC;
    printf("Time elapsed in ms: %f s", elapsed);
}