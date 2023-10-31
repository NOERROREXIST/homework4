package main;
public class IncomeTaxCalculator {
    public double calculateIncomeTax(double income) {
        // 在这里编写个人所得税计算逻辑
        // 这只是一个示例，实际计算逻辑应根据你的需求进行编写
        if (income <= 50000) {
            return income * 0.1;
        } else {
            return income * 0.2;
        }
    }
}

