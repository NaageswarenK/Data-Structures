/**
 * 
 */
package algorithm;

/**
 * @author ParvadhaVarthini
 *
 */
public class Testing {
	private static void reverse_words(char[] str)
	{
	    //write your code
	    for(int i=0,j=0;i<str.length;i++){
	        if(str[i]==' ' || i==str.length-1){
	            int temp;
	            if(i!=str.length-1)
	            	temp=i-1;
	            else
	            	temp=i;
	            while( j<temp){
	                char tempChar=str[j];
	                str[j]=str[temp];
	                str[temp]=tempChar;
	                j++;
	                temp--;
	            }
	            j=i+1;
	        }
	    }
	    
	}
	public static void main(String[] args) {
		char[] arr="Programming is an Art".toCharArray();
		Testing.reverse_words(arr);
		System.out.println(arr);
	}

}
