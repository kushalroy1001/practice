import java.util.HashMap;

public class FinancialForecasting {

    static HashMap<Integer, Double> memo = new HashMap<>();

    public static double calculateFutureValue(double currentAmount, double annualGrowthRate, int yearsRemaining) {
        if (yearsRemaining == 0) {
            return currentAmount;
        }

        if (memo.containsKey(yearsRemaining)) {
            return memo.get(yearsRemaining);
        }

        double previousYearValue = calculateFutureValue(currentAmount, annualGrowthRate, yearsRemaining - 1);
        double thisYearValue = previousYearValue * (1 + annualGrowthRate);
        memo.put(yearsRemaining, thisYearValue);

        return thisYearValue;
    }

    public static void main(String[] args) {
        double startingAmount = 1000.0;
        double growthRate = 0.10;
        int numberOfYears = 5;

        System.out.println(" Financial Forecast Tool");
        System.out.println("Starting Amount: Rs." + startingAmount);
        System.out.println("Annual Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Forecast Duration: " + numberOfYears + " years\n");

        double predictedValue = calculateFutureValue(startingAmount, growthRate, numberOfYears);

        System.out.printf(" After %d years, your amount will grow to: Rs.%.2f%n",
                          numberOfYears, predictedValue);
    }
}
