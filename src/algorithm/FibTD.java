package algorithm;

public class FibTD {
	
	
	public static int fibonacci(int n,int[] result) {
		if(n==0 || n==1) {
			result[n]=n;
			return result[n];
		}
		else if(result[n]!=-1) {
			return result[n];
		}
		else {
			result[n]=fibonacci(n-1, result)+fibonacci(n-2, result);
			return result[n];
		}
		
	}
	public static void main(String[] args) {
		int[] arr= {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		System.out.println(fibonacci(9,arr));
	

} 

}
