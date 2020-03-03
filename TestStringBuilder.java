package cn.zorro.test;

/**
 * 将一个给定字符串根据给定的行数，从上往下，从左到右进行Z字排列。 LEETCODEISHIRING
 * 
 * @author Zorro
 *
 */

public class TestConvert {
	public static void main(String[] args) {
		String str = convert("LEETCODEISHIRING", 4);
		System.out.println(str);
	}

	public static String convert(String s, int numRows) {
		int j = (s.length() / (numRows + numRows - 2)) * (numRows -1);  // 计算多少列 
		int x = s.length() % (numRows + numRows - 2); 
		if (x > 0 && x <= numRows) {  // 计算多余的列
			j++;
		}else if (x > numRows) {
			j = j + (x - numRows);
		}
		int i = numRows;  // 行
		char[] in = s.toCharArray();  // 输入的Srting转数组
		char[][] out = new char[i][j];  // 输出的数组
//		int[][] test = new int[i][j]; 
		int flag = 0;  // 换行用
		int y = 0; 
		
		char[] charStr = new char[s.length()];  // 需要返回的字符串
		
		System.out.println(in);
		System.out.println(i);
		System.out.println(j);
		System.out.println("#######");
		for (int m = 0; m < i; m++) {
			for (int n = 0; n < j; n++) {
				int lie = n / (numRows - 1);  // 计算这是第几循环列
				if((n % (numRows - 1)) == 0) {  // 给满的列写入
					out[m][n] = in[lie * (2 * numRows - 2) + m]; 
					charStr[y++] = out[m][n]; 
				} else if (((m + n + 1 + lie) % numRows) == 0) {  // 写不规则的地方
					out[m][n] = in[(n - 1 - lie) + (numRows * (lie + 1))]; 
					charStr[y++] = out[m][n]; 
				}
				System.out.print(out[m][n]+" ");
				flag++;
				if (flag % j == 0) {
					System.out.println();
				}
			}
		}
		// 测试用
//		flag = 0; 
//		for (int m = 0; m < i; m++) {
//			for (int n = 0; n < j; n++) {
//				test[m][n] = y++; 
//				System.out.print(test[m][n]+" ");
//				flag++;
//				if (flag % j == 0) {
//					System.out.println();
//				}
//			}
//		}
		// 转换成String
//		char temp;
//		char none; 
//		int len = 0;
		StringBuilder sb = new StringBuilder(); 
		for (int m = 0; m < y; m ++) {
			sb.append(charStr[m]);
		}
//		for (int m = 0; m < i; m++) {
//			for (int n = 0; n < j; n++) {
//				temp = out[m][n]; 
//				
//				if (out[m][n] == none) {
//					
//				}
//			}
//		}
		
		return sb.toString();
	}
}
