package classes;

public class MethodExe3 {
	
	String gugudan(int num, int num2) {
	//99단 출력
		String str = "";
		for(int i=num; i<=num2; i++) {
			int dan = i;
			for(int j=1; j<=9; j++) {
				str += dan + "*" + j + "=" + (dan * j) + "\n";
			}
		}
		return str;
	}
	
	void printStar(int cnt, String str) {
		for(int i=1; i<=cnt; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(str);
			}
			System.out.println("");
		}
	}
	
	//카드번호보여주기 (중복없음)

	void printCard() {
		
		int[] intArray = new int[16];
		for(int i=0; i < intArray.length; i++) {
			int idx = -1;
			int random = (int) (Math.random() * 16)  + 1;
			for(int j=0; j < intArray.length; j++) {
				if(intArray[j] == random) {
					idx = j;
					break;
				}
			}
			if(idx == -1) {
				intArray[i] = random;
			}else {
				i--;
			}
		}
		// 출력
		for(int i=0; i < intArray.length; i++) {
			System.out.printf("%3d", intArray[i]);
			if (i % 4 == 3) {
				System.out.println();
			}
		}
	}
}
