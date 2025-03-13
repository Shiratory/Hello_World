package classes;

public class MethodExe1 {



//리턴타입 메소드이름(매개변수.,.){

// }
void printString(int times, String STR) {
	for(int i=1; i<=times;i++) {
		System.out.println("*");
	}
}
// 두 점수의 합
int sum(int n1, int n2) {
	int result = 0;
	result = n1 + n2;
	return result;
}
// 두 실수의 합
double sum(double n1, double n2) {
	return (n1 + n2);
}
// 배열의 합
int sum(int[] array) {
	int result = 0;
	for(int i=0; i<array.length; i++) {
		result = result + array[i];
	}
	return result;
}

// 배열의 합(double[]을 매개값, 반환값도 double)
double sum(double[] array) {
	double result = 0;
	for(int i=0; i<array.length; i++) {
		result += array[i];
	}
	return result;
	}
}
