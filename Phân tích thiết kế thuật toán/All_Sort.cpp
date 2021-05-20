#include <stdio.h>
#include <malloc.h>
typedef int keytype;
typedef float othertype;
typedef struct {
	keytype key;
	othertype otherfields;
}recordtype;

//Hàm d?i v? trí
void Swap(recordtype *x, recordtype *y){
	recordtype temp;
	temp = *x;
	*x = *y;
	*y = temp;
}
//Hàm s?p x?p ch?n
void SelectionSort(recordtype arr[], int n) { 
    int i, j,lowindex; 
    keytype lowkey;
    for (i = 0; i <= n-2; i++) 
    { 
       lowkey = arr[i].key;
	   lowindex=i; 
        for (j = i+1; j <= n-1; j++) 
          if(arr[j].key<lowkey){
				lowkey=arr[j].key;
				lowindex=j;
				}

        Swap(&arr[i],&arr[lowindex]);
    } 
} 
//Hàm s?p x?p xen (chèn)
void InsertionSort(recordtype a[], int n){
	int i,j;
	for(i=1 ; i<=n-1; i++){
		for (j=i; (j>=1 && a[j].key < a[j-1].key); j-- )
			Swap(&a[j], &a[j-1]);
	}
	}

//Hàm s?p x?p n?i b?t
void BubbleSort(recordtype a[], int n){
	int i, j;
	for (i = 0; i <= n-2; i++){
		for(j= n-1; j>= i+1; j-- ){
			if(a[j].key < a[j-1].key)
			Swap(&a[j], &a[j-1]);
	}}
	}

//Hàm tìm Pivot, b? tr? cho hàm s?p x?p QuickSort
int FindPivot(recordtype a[], int i, int j){
	keytype firstkey;
	int k;
	k= i + 1;
	firstkey = a[i].key;
	while ( k <= j && a[k].key == firstkey) k++;
		if(k>j) return -1;
		if(a[k].key > firstkey) return k;
		return i;
		}

//Hàm vách ngan, c?a hàm QuickSort
int Partition(recordtype a[], int i, int j, keytype pivot ){
	int L, R;
	L = i;
	R = j;
	while( L <= R){
		while (a[L].key < pivot) L++;
		while (a[R].key >= pivot) R--;
		if(L<R) Swap(&a[L], &a[R]);
		}
		return L;
		}

//Hàm s?p x?p QuickSort
void QuickSort(recordtype a[], int i, int j ){
	keytype pivot;
	int pivotindex, k;
	pivotindex = FindPivot(a, i ,j);
	if (pivotindex != -1){
		pivot = a[pivotindex].key;
		k = Partition(a, i ,j , pivot);
		QuickSort (a, i, k-1);
		QuickSort (a, k, j);
		}
}

//Hàm PushDown, h? tr? cho hàm HeapSort
void PushDown(recordtype a[], int first, int last ){
	int r = first;
	while (r <= (last -1)/2){
		if(last == 2*r +1){
			if(a[r].key > a[last].key) Swap(&a[r], &a[last]);
			r = last;
			}else
			if((a[r].key > a[2*r + 1].key) && (a[2*r+1].key <= a[2*r + 2].key))
			{
				Swap(&a[r], &a[2*r+1]);
				r = 2 * r +1;
				}else
				if((a[r].key > a[2*r + 2].key) && (a[2 * r + 2].key < a[2*r+1].key))
				{
					Swap(&a[r],&a[2*r+2]);
					r= 2*r+2;
					}
					else
					r= last;
					}
	}
//Hàm s?p x?p HeapSort
void HeapSort(recordtype a[], int n){
	int i;
	for (i = (n/2)/2; i>= 0; i--)	
		PushDown(a,i,n-1);
	for(i = n-1; i>=2; i--){
		Swap(&a[0], &a[i]);
		PushDown(a, 0, i-1);
		}
		Swap(&a[0], &a[1]);
}	


//void BinSort(recordtype a[], listtype b[], int n, int m){
//	int i;
//	keytype j;
//	for(i=0; i<=n; i++)
//		Insert(a[i], End(b[a[i].key]), b[a[i].key]);
//		for(j=1; j<m; i++)
//			Concatenate(b[0],b[j]);
//}
	
//Hàm d?c data t? t?p txt
void Read_Data(recordtype arr[],int *n){
	FILE *f;
	f=fopen("data.txt","r");
	int i=0;
	if(f!=NULL)
	while (!feof(f)){
		fscanf(f,"%d%f",&arr[i].key,&arr[i].otherfields);
		i++;
	}else printf("Loi mo file\n");
	fclose(f);
	*n=i;
}

/*In m?t m?ng ra*/
void printArray(recordtype a[],int n){
	int i;
	for(i=0;i<n;i++)
	printf("%3d%5d%8.2f\n",i+1,a[i].key,a[i].otherfields);
}
  

int main() 
{ 
	recordtype a[100];
	int n;
	Read_Data(a,&n);
	printf("Du lieu ban dau\n");
	printArray(a,n);

    InsertionSort(a,n); 
   // BubbleSort(a,n);
    
	
    printf("Du lieu sau khi sap xep: \n"); 
    printArray(a,n); 
    return 0; 
} 
