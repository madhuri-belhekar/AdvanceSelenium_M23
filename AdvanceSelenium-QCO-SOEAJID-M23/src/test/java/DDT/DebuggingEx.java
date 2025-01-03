package DDT;

public class DebuggingEx {
	
public static void main(String[] args) {
	//this is pull comment
	//this is push comment
	int a = 10;
	int b = 20;
	System.out.println(a);
	System.out.println(b);
	
	int temp;
	temp = a;
	a = b;
	b = temp;
	
	System.out.println(a);
	System.out.println(b);


}
}
