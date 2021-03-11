//Duyet do thi vo huong theo chieu sau ma tran Dinh - Dinh
//DFS su dung ngan xep

/*Kiem tra tat ca da duoc duyet chua
	them dinh vao Graph
	Do thi khong lien thong
	Khong duyet het cac dinh duoc
	Neu mot dinh nao do trong do thi chua duoc duyet qua ham DFS thi duyet lai dinh do
	Khai bao them mot mang trong do thi xem dinh chua duoc duyet
*/

#include<stdio.h>
#define MAX_Vertices 25
#define MAX_Length 25
#define MAX_Element 40  //for Stack
typedef struct
{
    int A[MAX_Vertices][MAX_Vertices];
    int n; //so luong dinh
} Graph;

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
int degree(Graph *G,int x)
{
    int deg=0, i;
    for(i=1; i<= G->n; i++)
        if(G->A[i][x]==1) //co the thay the bang hâm adjacent
            //if(adjacent(G, i ,x))
            deg++;
    return deg;
}
//Kiem tra cac dinh lien ke, can cai dat danh sach
//Khai bao cau truc danh sach List
typedef struct
{
    int data[MAX_Length];
    int size;
} List;

//Ham khoi tao danh sach rong
void make_null(List *list)
{
    list->size = 0;
}

//Them mot phan tu (dinh) vao cuoi danh sach
void push_back(List *list, int x)
{
    list->data[list->size] = x; //cho phan tu dau tien = 0 va tang no len sau
    list->size++;//tang phan tu len
}

//Lay mot phan tu (dinh) trong danh sach tai vi tri i
int element_at(List *list, int i)
{
    return list->data[i-1]; //do mang bat dau tu vi tri khong, cho nen phai -1
}

//Tim lang gieng cua dinh x
List neighbors(Graph *G, int x)  //in ra mot danh sach, nen dung kieu List.
{
    List L; //can khoi tao mot danh sach khi tim
    make_null(&L);
    int i;
    for(i=1; i<=G->n; i++)//giong nhu ham Degree
    {
        //duyet qua tat ca cac dinh, neu dinh nao di toi duoc dinh x thi them vao List
        if(G->A[i][x] == 1)
            //if(adjacent(G, i, x))
            push_back(&L, i); //dua mot dinh vao danh sach
    }
    return L;
}

//Cai dat ngan xep de tinh DFS
//Khai bao cau truc cua ngan xep
typedef struct
{
    int data[MAX_Element];
    int size; //bien de lay phan tu cuoi cung trong ngan xep ra
} Stack;

//Khoi tao ngan xep rong
void make_null_stack(Stack *stack)
{
    stack->size = 0;
}

//Them mot phan tu vao trong ngan xep
void push_stack(Stack *stack, int x)  //x: dinh them vao Stack
{
    stack->data[stack->size] = x; //them x vao data, va chi so cua man tai Ngan xep link excel.
    stack->size ++; //tang size len khi them
}

//Lay mot phan tu trong Stack
int top(Stack *stack)
{
    return stack->data[stack->size-1]; //so sanh vao excel, size & idex, size - 1 = idex

}

//Xoa mot phan tu thuoc Stack
void pop(Stack *stack)
{
    stack->size --;
}

//Kiem tra Stack rong
int empty(Stack *stack)
{
    return stack->size == 0;
}

//Thuat toan DFS duyet theo chieu sau
List depth_first_search(Graph *G, int x)
{
    Stack S;
    make_null_stack(&S); //Khoi tao ham rong
    push_stack(&S, x); //dua dinh x vao
    List list_dfs;
    make_null(&list_dfs);
    int mark[MAX_Vertices]; //mangx danh dau xem mot dinh da duoc duyet chua
    //Khoi tao tat ca cac dinh chua duoc duyet
    int i, j;
    for(i=1; i<=G->n; i++)
        mark[i]= 0; //Khi mark =0 thi dinh chua duoc duyet, nguoc lai
    while(!empty(&S))
    {
        int u = top(&S); //Lay mot dinh ra
        pop(&S); //Xoa dinh do khoi ngan xep khi da lay
        if(mark[u] == 1)
            continue;
        //	printf("Duyet: %d\n", u);
        push_back(&list_dfs, u); //dua u vao danh sach thay vi duyet u

        mark[u]= 1;
        List list = neighbors(G, u); //Ham neighbors su dung kieu du du lieu List nen phai goi List ra
        for(i=1; i<=list.size; i++)  //lay phan tu trong list
        {
            int v = element_at(&list, i);
            if(mark[v] == 0)
                push_stack(&S, v); //Dua v vao ngan xep

        }
    }
    return list_dfs;
}

int main()
{
    Graph G;
    freopen("DFS.txt", "r", stdin);
    int n, m;
    scanf("%d%d", &n, &m);
    init_Graph(&G, n);
    int e, u, v;
    for(e=1; e<=m; e++)
    {
        scanf("%d%d", &u, &v);
        add_edge(&G, u, v); //them cung
    }
    int mark_dfs[MAX_Vertices]; //kiem tra duyet cua tat ca do thi
    int i, j;
    for(i=1; i<=G.n; i++)
    {
        mark_dfs[i] = 0;
    }
    for(i=1; i<=G.n; i++)
    {
        if(mark_dfs[i] == 0)  //neu chua duoc duyet
        {
            List dfs = depth_first_search(&G, i);
            for(j=1; j<=dfs.size; j++)  //tien hanh in danh sach
            {
                int k = element_at(&dfs, j);
                printf("%d\n", k);
                mark_dfs[k] = 1;
            } //2 dong lap for khong su dung cung mot bien lap
        }
    }
    //Duyet do thi chua kiem tra het cac dinh trong do thi
//	printf("Duyet do thi DFS \n");
//	List dfs = depth_first_search(&G, 1);
//	//Su dung List dfs thay cho phan cu o bai 1
//	//in thu tu duyet
//		for(i=1; i<=dfs.size; i++) //tien hanh in danh sach
//		printf("Duyet: %d\n", element_at(&dfs, i));
    return 0;
}


