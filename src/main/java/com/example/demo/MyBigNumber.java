package com.example.demo;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class MyBigNumber {
	
	private static final Logger logger = Logger.getLogger(MyBigNumber.class.getName());
    private StringBuilder log = new StringBuilder();
    public String sum(String stn1, String stn2) {
        // Đảm bảo stn1 luôn là chuỗi dài hơn hoặc bằng stn2
        if (stn1.length() < stn2.length()) {
            String temp = stn1;
            stn1 = stn2;
            stn2 = temp;
        }
        // Đảo ngược các chuỗi để duyệt từ phải sang trái
        stn1 = new StringBuilder(stn1).reverse().toString();
        stn2 = new StringBuilder(stn2).reverse().toString();
        StringBuilder result = new StringBuilder();
        int carry = 0;
        // Duyệt từng ký tự của cả hai chuỗi
        for (int i = 0; i < stn1.length(); i++) {
            int digit1 = stn1.charAt(i) - '0';
            int digit2 = (i < stn2.length()) ? stn2.charAt(i) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
            String logStep=String.format("Bước " + (i + 1) + ": Lấy " + digit1 + " cộng với " + digit2 + " được " + sum + ". Lưu " + (sum % 10) + " vào kết quả và nhớ " + carry + ".");
            logger.info(logStep);
            log.append(logStep);
            
        }
        if (carry > 0) {
            result.append(carry);
            logger.info("Thêm phần nhớ cuối cùng: " + carry);
        }
        // Đảo ngược lại kết quả để có số đúng
        return result.reverse().toString();
}
    public String getLog() {
        return log.toString();
    }
}
