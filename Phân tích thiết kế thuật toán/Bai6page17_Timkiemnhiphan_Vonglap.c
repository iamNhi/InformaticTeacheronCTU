// Chương trình tìm kiếm nhị phân bằng kỹ thuật vòng lặp
#include <stdio.h> 
  
// Cây tìm kiếm nhị phân bằng các sử dụng vòng lặp While
int binarySearch(int arr[], int l, int r, int x) 
{ 
    while (l <= r) { 
        int m = l + (r - l) / 2; 
  
        // Kiểm tra x có nằm ở giữa không, nếu có nó là nút gốc
        if (arr[m] == x) 
            return m; 
  
        // Kiểm tra có nhỏ hơn x không
		//Nếu đúng nó nằm bên trái x
        if (arr[m] < x) 
            l = m + 1; 
  
        // Nếu x nhỏ hơn, thì nó nằm bên phải x
        else
            r = m - 1; 
    } 
  
    // Nếu không tìm thấy trả về -1
    return -1; 
} 
  
int main(void) 
{ 
	int x;
	//Mảng được sắp xếp theo thứ tự từ bé đến lớn
    int arr[] = { 2, 3, 4, 10, 40 }; 
    int n = sizeof(arr) / sizeof(arr[0]); 
    printf("Nhap so can tim x = ");
	scanf("%d",&x);
    int result = binarySearch(arr, 0, n - 1, x); 
    (result == -1) ? printf("False") 
                   : printf("True", 
                            result); 
    return 0; 
} 