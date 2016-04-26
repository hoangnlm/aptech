package java2;

public class ngay0204 {

	public static void main(String[] args) {
		Integer[] intValue = { 1, 7, 9, 15 };
		NumberList<Integer> listObj = new NumberList<>();
//		listObj.display(intValue);
//		listObj.test("hehe");
//		Integer t1= 5;
//		Double t2 = 5.0;
//		System.out.println(t1==t2);
	}
}

 class NumberList<T> {
	public <A extends ngay0204> void display(T[] val) {
		for (T element : val) {
			System.out.printf("Values are: %s ", element);
		}
	}
	
	public  <M> void test(M hehe){
		
	}
}

class NumberList2 extends NumberList<MyException>{
	@Override
	public <MyException2 extends ngay0204> void display(MyException[] val) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <A> void test(A hehe) {
		// TODO Auto-generated method stub
		
	}
}

class MyException extends Exception {

	public MyException() { // Can override method toString() de tao message
							// mac
							// dinh
	}

	public MyException(String message) {
		super(message); // Gan message khi khoi tao
	}

	@Override
	public String toString() { // Dinh nghia message khi khong gan message
		return "This is my exception";
	}
}
