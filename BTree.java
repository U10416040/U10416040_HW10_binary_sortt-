import java.awt.*;
import java.security.SecureRandom;
//import java.lang.Math;;



public class BTree {
	public static void main(String[] args){
		//System.out.printf("ss");
		int i;
		double test;
		double p;
		Tree bs=new Tree();
		
		bs.CreateNumberList();		
		
		for(i=0;i<20;i++){		
			System.out.println(bs.numbers[i]);
		}
		
		System.out.println();
		System.out.println("bstree value");
					
		bs.BuildBSTree();
				
		p=Math.pow(2,10);
		for(i=0;i<p;i++){
			System.out.printf("%5d=%5d", i,bs.BSTree[i]);
			if(i%10==0)
				System.out.println();
		}
	}

	
}

class Tree{
	SecureRandom srandom = new SecureRandom();;
	int numbers[] = new int[20];
	int count;
	int BSTree[]=new int[1024*1024];
	
	int CreateNumberList(){
		int temp;
				
		count=0;
		do{
			temp=srandom.nextInt(100)+1;			
			if(IsExist(temp)==0){
				numbers[count++]=temp;				
			}
			
		}while(count<20);
		
		return 0;
	}
	
	int IsExist(int number){
		int i;
		
		//compare if the array has the number
		for(i=0;i<count;i++){
			if(numbers[i]==number){
				return 1;//exist
			}
		}
		
		return 0;//not exist
	}
	
	int BuildBSTree(){
		int i;				
						
		for(i=0;i<10;i++){
			AddNode(0, numbers[i]);
		}				
		
		return 0;
	}
	
	int AddNode(int pidx, int val){
		int p;
		
		if(pidx==0){
			if(BSTree[0]==0){
				BSTree[0]=val;
				return 0;
			}			
		}
		
		p=BSTree[pidx];
		
		if(val>p){			
			if(BSTree[pidx*2+1+1]!=0){
				AddNode(pidx*2+1+1, val);
			}
			else{				
				BSTree[pidx*2+1+1]=val;				
			}					
		}
		else{
			if(BSTree[pidx*2+1]!=0){
				AddNode(pidx*2+1, val);
			}
			else{				
				BSTree[pidx*2+1]=val;				
			}
		}
		
		return 0;
	}
	
}