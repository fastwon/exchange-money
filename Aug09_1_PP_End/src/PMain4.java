import java.nio.channels.AsynchronousChannelGroup;
import java.util.Scanner;

// �Ž����� ȯ�� ���α׷�
// �Լ� ��� (��)

// < �Է� >
//	������ ���� ���� : 35000
//	�� �� : 41530
// ----------------------------------
//	�Ž����� : 6530 ��
//		50000 : 0
//		10000 : 0
//		5000 : 1
//		1000 : 1
//		500 : 1
//		100 : 0
//		50 : 0
//		10 : 3

public class PMain4 {
//	// ����
//	public static void start() {
//		System.out.println("===========================================");
//		System.out.println("������ �����ϰ� ���� ������ �ּ���");
//		System.out.println("===========================================");
//	}
//	// ���� ���� �Է�
//	public static int getPrice() {
//		Scanner k = new Scanner(System.in);
//		System.out.print("������ ���� : ");
//		int price = k.nextInt();
//		return price;
//	}
//	// �� �� �Է�
//	public static int getPay() {
//		Scanner k = new Scanner(System.in);
//		System.out.print("������ �ݾ� : ");
//		int pay = k.nextInt();
//		return pay;
//	}
//	// �Ž����� ���
//	public static int calChange(int price, int pay) {
//		int change = pay - price;
//		return change;
//	}
//	// �Ž����� ȯ�� ���
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
//	// �Ž����� �� ȯ�� ��� ���
//	public static void printResult(int price, int pay, int change, int[] changeList) {
//		int[] coin = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
//		System.out.println("===========================================");
//		System.out.printf("���� ������ %d�� �Դϴ�.\n", price);
//		System.out.println("===========================================");
//		System.out.printf("�����Ͻ� �ݾ��� %d�� �Դϴ�.\n", pay);
//		System.out.println("===========================================");
//		System.out.printf("�Ž������� %d�� �Դϴ�.\n", change);
//		System.out.println("===========================================");
//		for (int i = 0; i < changeList.length; i++) {
//			System.out.printf("%d�� : %d��\n", coin[i], changeList[i]);
//		}
//	}
	
	// ����
	// ���� ����
	public static int getPrice() {
		Scanner k = new Scanner(System.in);
		System.out.print("���� ���� : ");
		int price = k.nextInt();
		return price;
	}
	// �� ��
	public static int payMoney(int price) {
		Scanner k = new Scanner(System.in);
		System.out.print("�� �� : ");
		int money = k.nextInt();
		if (money < price) {
			System.out.println("���� �����մϴ�. �ٽ� �Է��մϴ�.");
		}
		return (money >= price) ? money : payMoney(price);
	}
	// �Ž����� ���
	public static int getChange(int price, int money) {
		return money - price;
	}
	// ���� 3�� ���
	public static void printResult(int price, int money, int change) {
		System.out.println("===================================");
		System.out.printf("���� ���� : %d��\n", price);
		System.out.printf("�� �� : %d��\n", money);
		System.out.printf("�Ž����� : %d��\n", change);
		System.out.println("===================================");
	}
	// �Ž������� ȭ�� ���� ��� �� ������
	public static void printChange(int change) {
		// 2���� ���...
		// 1.
//		int[] currency = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
//		for (int i = 0; i < currency.length; i++) {
//			if (change >= currency[i]) {
//				System.out.printf("%d�� �� : %d��\n", currency[i], change/currency[i]);
//				change %= currency[i];
//			}
//		}
		// 2.
		int currency2 = 100000;
		while (true) {
			currency2 /= 2;
			if (change >= currency2) {
				System.out.printf("%d�� �� : %d��\n", currency2, (change/currency2));
				change %= currency2;
			}
			
			currency2 /= 5;
			if (change >= currency2) {
				System.out.printf("%d�� �� : %d��\n", currency2, (change/currency2));
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
