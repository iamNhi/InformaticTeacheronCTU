// Chương trình C để thực hiện Tìm kiếm nhị phân đệ quy
#include <stdio.h> 

/* Hàm tìm kiếm nhị phân sử dụng đệ quy
Tìm kiếm một số nguyên có trong mảng hay không
Sử dụng cây tìm kiếm nhị phân với kỹ thuật đệ quy*/
//Hàm tìm kiếm nhị phân 
int binarySearch(int arr[], int l, int r, int x) 
{ 
    if (r >= l) { 
        int mid = l + (r - l) / 2; 
  
        // Nếu phần tử nằm ở giữa thì là nút của cây  
        if (arr[mid] == x) 
            return mid; 
  
        // Nếu phần tử nhỏ hơn phần tử ở giữa
		//Nó sẽ xuất hiện ở mảng con bên trái
        if (arr[mid] > x) 
            return binarySearch(arr, l, mid - 1, x); 
  
        // Ngược lại, nếu nó lớn hơn x 
		//Nó sẽ xuất hiện ở mảng con bên phải
        return binarySearch(arr, mid + 1, r, x); 
    } 
  
    //Và nếu phần tử x không hiện diện trong mảng thì
	//Trả về giá trị -1
    return -1; 
} 
  
int main(void) 
{ 
	int x;
	//Cho một mảng sắp xếp theo thứ tự từ bé đến lớn như đề bài
	//Mảng arr[]
	//Có thể thay đổi giá trị nếu bạn muốn
    int arr[] = { 2, 3, 4, 10, 40 }; 

	//Tính kích thước của mảng
    int n = sizeof(arr) / sizeof(arr[0]); 
	//Bạn có thể thay đổi giá trị phần tử x để tìm kiếm trong mảng 
	printf("Nhap so can tim x = ");
	scanf("%d",&x);
	//Gọi hàm tìm kiếm nhị phân.
	//Sử dụng if else viết tắt để kiểm tra xem x có nằm trong mảng không
	//Nếu có trả về giá trị True và ngược lại là False 
	printf("Kiem tra %d co nam trong mang khong? ", x);
    int result = binarySearch(arr, 0, n - 1, x); 
	//Quay lại hàm trên line 29 ta có nếu khong tìm được trả về -1
	//Ta thấy điều kiện = -1 nên trả về false
    (result == -1) ? printf("\nFalse\n") 
                   : printf("\nTrue"); 
    return 0; 
} 