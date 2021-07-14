package spark;

public class Main {

	public static void main(String[] args) {
		
		String mobileNum = "0926222729";
		checkMobileNum(mobileNum);
		
		String emailStr = "1_@1-1.cc";
		checkEmail(emailStr);
		
		String phoneNum = "0-1#2";
		checkPhone(phoneNum);
		
		String addressStr = "基隆市中正區中正路１號";
		checkAddress(addressStr);
	}
	
	//中文或全形阿拉伯數字
	//不可以有英文或符號，不包含全形的括號
	//地址至少要寫到「號」
	//括號內不檢核
	private static void checkAddress(String address) {
		
		String regex = "\\D+[縣市]\\D+(市區|鎮區|鎮市|[鄉鎮市區])(\\D+?[村里])?(\\D+[鄰])?\\D+?(村路|[路街道段])?(\\D?段)?(\\D+巷)?(\\D+弄)?(\\D+號?)?(-?\\D+)+(號)";
		
		boolean checkState = address.matches(regex);

		System.out.println(String.format("地址：%s，校驗結果：%b", address, checkState));
	}
	
	//區碼必填
	//必須有「-」
	//「-」的前後都要有數字
	//分機號碼非必填，如果有，要有「#」符號
	private static void checkPhone(String phoneNum) {
		
		String regex = "\\d+-\\d+(#\\d+)?";
		
		boolean checkState = phoneNum.matches(regex);

		System.out.println(String.format("電話號碼：%s，校驗結果：%b", phoneNum, checkState));
		
	}

	//數字、英文、符號
	//需要有＠，前後都要有文字
	//不可以有全形
	private static void checkEmail(String email) {
		
		String regex = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";
		
		boolean checkState = email.matches(regex);

		System.out.println(String.format("E-Mail：%s，校驗結果：%b", email, checkState));
	}
	
	//只能數字
	//只能10位數
	private static void checkMobileNum(String mobileNum) {
		
		String regex = "[0-9]{10}";
		
		boolean checkState = mobileNum.matches(regex);

		System.out.println(String.format("手機號碼：%s，校驗結果：%b", mobileNum, checkState));
	}

}
