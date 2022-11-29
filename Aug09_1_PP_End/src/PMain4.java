import java.nio.channels.AsynchronousChannelGroup;
import java.util.Scanner;

// 거스름돈 환전 프로그램
// 함수 사용 (ㅇ)

// < 입력 >
//	구매한 물건 가격 : 35000
//	낸 돈 : 41530
// ----------------------------------
//	거스름돈 : 6530 을
//		50000 : 0
//		10000 : 0
//		5000 : 1
//		1000 : 1
//		500 : 1
//		100 : 0
//		50 : 0
//		10 : 3

public class PMain4 {
//	// 시작
//	public static void start() {
//		System.out.println("===========================================");
//		System.out.println("물건을 구매하고 돈을 지불해 주세요");
//		System.out.println("===========================================");
//	}
//	// 물건 가격 입력
//	public static int getPrice() {
//		Scanner k = new Scanner(System.in);
//		System.out.print("물건의 가격 : ");
//		int price = k.nextInt();
//		return price;
//	}
//	// 낸 돈 입력
//	public static int getPay() {
//		Scanner k = new Scanner(System.in);
//		System.out.print("지불한 금액 : ");
//		int pay = k.nextInt();
//		return pay;
//	}
//	// 거스름돈 계산
//	public static int calChange(int price, int pay) {
//		int change = pay - price;
//		return change;
//	}
//	// 거스름돈 환전 기능
//	public static int[] exchange(int change) {
//		int[] changeList = new int[8];
//		int sum = change;
//		if (sum >= 50000) {
//			changeList[0] = sum / 50000;
//			sum %= 50000;
//		} if (sum >= 10000) {
//			changeList[1] = sum / 10000;
//			sum %= 10000;
//		} if (sum >= 5000) {
//			changeList[2] = sum / 5000;
//			sum %= 5000;
//		} if (sum >= 1000) {
//			changeList[3] = sum / 1000;
//			sum %= 1000;
//		} if (sum >= 500) {
//			changeList[4] = sum / 500;
//			sum %= 500;
//		} if (sum >= 100) {
//			changeList[5] = sum / 100;
//			sum %= 100;
//		} if (sum >= 50) {
//			changeList[6] = sum / 50;
//			sum %= 50;
//		} if (sum >=10) {
//			changeList[7] = sum / 10;
//		}
//		return changeList;
//	}
//	// 거스름돈 및 환전 결과 출력
//	public static void printResult(int price, int pay, int change, int[] changeList) {
//		int[] coin = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
//		System.out.println("===========================================");
//		System.out.printf("물건 가격은 %d원 입니다.\n", price);
//		System.out.println("===========================================");
//		System.out.printf("지불하신 금액은 %d원 입니다.\n", pay);
//		System.out.println("===========================================");
//		System.out.printf("거스름돈은 %d원 입니다.\n", change);
//		System.out.println("===========================================");
//		for (int i = 0; i < changeList.length; i++) {
//			System.out.printf("%d원 : %d개\n", coin[i], changeList[i]);
//		}
//	}
	
	// 정답
	// 물건 가격
	public static int getPrice() {
		Scanner k = new Scanner(System.in);
		System.out.print("물건 가격 : ");
		int price = k.nextInt();
		return price;
	}
	// 낸 돈
	public static int payMoney(int price) {
		Scanner k = new Scanner(System.in);
		System.out.print("낸 돈 : ");
		int money = k.nextInt();
		if (money < price) {
			System.out.println("돈이 부족합니다. 다시 입력합니다.");
		}
		return (money >= price) ? money : payMoney(price);
	}
	// 거스름돈 계산
	public static int getChange(int price, int money) {
		return money - price;
	}
	// 위에 3개 출력
	public static void printResult(int price, int money, int change) {
		System.out.println("===================================");
		System.out.printf("물건 가격 : %d원\n", price);
		System.out.printf("낸 돈 : %d원\n", money);
		System.out.printf("거스름돈 : %d원\n", change);
		System.out.println("===================================");
	}
	// 거스름돈을 화폐에 따라 어떻게 줄 것인지
	public static void printChange(int change) {
		// 2가지 방법...
		// 1.
//		int[] currency = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
//		for (int i = 0; i < currency.length; i++) {
//			if (change >= currency[i]) {
//				System.out.printf("%d원 권 : %d개\n", currency[i], change/currency[i]);
//				change %= currency[i];
//			}
//		}
		// 2.
		int currency2 = 100000;
		while (true) {
			currency2 /= 2;
			if (change >= currency2) {
				System.out.printf("%d원 권 : %d개\n", currency2, (change/currency2));
				change %= currency2;
			}
			
			currency2 /= 5;
			if (change >= currency2) {
				System.out.printf("%d원 권 : %d개\n", currency2, (change/currency2));
				change %= currency2;
			}
			if (currency2 == 10) {
				break;
			}
		}
	}

	
	
	
	
	public static void main(String[] args) {
//		start();
//		int price = getPrice();
//		int pay = getPay();
//		int change = calChange(price, pay);
//		int[] changeList = exchange(change);
//		printResult(price, pay, change, changeList);
		
		int price = getPrice();
		int money = payMoney(price);
		int change = getChange(price, money);
		printResult(price, money, change);
		printChange(change);
	}
}
