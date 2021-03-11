//Duyet do thi theo chieu sau - De quy - Tree
//	TREE
// Do thi khong lien thong
#include<stdio.h>
#define MAX_Vertices 25 //Cap phat so luong dinh
#define MAX_Length 25

typedef struct
{
    int A[MAX_Vertices][MAX_Vertices];
    int n; //so luong dinh
} Graph; //cai dat cau truc

//Ham khoi tao do thi Dinh-Dinh
void init_Graph(Graph *G, int n)
{
    int i, j;
    G->n = n; //so luong dinh =6, nhap vao;
    for(i=1; i<=n; i++)//co the su sung n hoac G->n
        for(j=1; j<=n; j++)//Nhu tren
            G->A[i][j]=0;
}

//Ham them cung vao do thi Dinh-dinh
void add_edge(Graph *G, int x, int y)
{
    G->A[x][y]=1;
    G->A[y][x]=1;
}

//Ham kiem tra dinh ke nhau (lang gieng) lien thuoc
int adjacent(Graph *G, int x, int y)  //Kieu du lieu tra loi Yes No
{
    return (G->A[x][y]!=0);
}

//Ham tinh bac cua mot dinh
int degree(Graph *G,int x){
	int deg=0, i;
	for(i=1; i<= G->n; i++)
		if(G->A[i][x]==1) //co the thay the bang hâm adjacent
	//if(adjacent(G, i ,x))
		deg++;
	return deg;
}
//Kiem tra cac dinh lien ke, can cai dat danh sach
//Khai bao cau truc danh sach List lang gieng cua dinh x
typedef struct{
	int data[MAX_Length];
	int size;
}List;

//Ham khoi tao danh sach rong
void make_null(List *list){
	list->size = 0;
}

//Them mot phan tu (dinh) vao cuoi danh sach
void push_back(List *list, int x){
	list->data[list->size] = x; //cho phan tu dau tien = 0 va tang no len sau
	list->size++;//tang phan tu len
}

//Lay mot phan tu (dinh) trong danh sach tai vi tri i
int element_at(List *list, int i){
return list->data[i-1]; //do mang bat dau tu vi tri khong, cho nen phai -1
}	

//Tim lang gieng cua dinh x
List neighbors(Graph *G, int x){ 
	List L; 
	 make_null(&L);
	 int i;
	 for(i=1; i<=G->n; i++)
	 {
	 	if(G->A[i][x] == 1)
	 		push_back(&L, i); 
	}
	return L;
}

//Khai bao mang de su dung De Quy
int mark[MAX_Vertices];
//Ho tro dung cay
int parent[MAX_Vertices];


//Duyet do thi theo chieu sau - De Quy
void DFS_Recursion(Graph *G, int u, int p){ // p : parent
	if(mark[u] == 1)
		return;
	//Duyet u
//	printf("Duyet: %d\n", u);
	parent[u] = p; //truyen vao cha cua u se la p
	mark[u] = 1; 
	List list = neighbors(G, u);
	int i;
	for(i=1; i<=list.size; i++){
		int v = element_at(&list, i);
		DFS_Recursion(G, v, u);
	}	
}

int main()
{
    Graph G;   
    freopen("DFS_DeQuy.txt", "r", stdin); 
	int n, m; 
	scanf("%d%d",&n ,&m);
	init_Graph(&G, n);
	int u, v, i; 
	//Doc cung tu tap tin
	for(i=1; i<=m; i++){
		scanf("%d%d",&u ,&v);
		add_edge(&G, u, v);
	}
	for(i=1; i<=n; i++){
		mark[i]= 0; //danh dau tat ca cac dinh chua duoc duyet
		parent[i] = -1 ; //tat ca cac dinh ban dau deu khong co CHA
	}
//Do thi khong lien thong
	for(i=1; i<=n; i++)
	if(mark[i] == 0)
		DFS_Recursion(&G, i, 0);
		
	//DFS_Recursion(&G, 1, 0); //cha cua dinh 1 - dinh bat dau = 0
	//in cha cua cac dinh ra
	for(i=1; i<=n; i++)
		printf("%d %d\n", i, parent[i]);	
    return 0;
}
