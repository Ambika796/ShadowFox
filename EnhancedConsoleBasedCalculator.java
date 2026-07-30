import java.util.Scanner;

class Calculator
{
    public double add(double num1, double num2)
    {
        return num1 + num2;
    }

    public double subtract(double num1, double num2)
    {
        return num1 - num2;
    }

    public double multiply(double num1, double num2)
    {
        return num1 * num2;
    }

    public double divide(double num1, double num2)
    {
        if(num2 == 0)
        {
            throw new IllegalArgumentException("Cannot divide by zero");
        }

        return num1 / num2;
    }


    public double power(double base, double exponent)
    {
        return Math.pow(base, exponent);
    }


    public double sqrt(double num)
    {
        return Math.sqrt(num);
    }


    public double celsiusToFahrenheit(double celsius)
    {
        return (celsius * 9 / 5) + 32;
    }


    public double fahrenheitToCelsius(double fahrenheit)
    {
        return (fahrenheit - 32) * 5 / 9;
    }


    public double dollarToRupee(double dollar)
    {
        return dollar * 83;   // Fixed conversion rate
    }
}


public class EnhancedConsoleBasedCalculator
{
    public static void main(String[] args)
    {
        try (Scanner scanner = new Scanner(System.in)) {
            Calculator calculator = new Calculator();
            
            int choice;
            
            do
            {
                System.out.println("\n========== Calculator ==========");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Square Root");
                System.out.println("6. Power");
                System.out.println("7. Celsius to Fahrenheit");
                System.out.println("8. Fahrenheit to Celsius");
                System.out.println("9. Dollar to Rupee");
                System.out.println("10. Exit");
                
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                
                
                try
                {
                    switch(choice)
                    {
                        
                        case 1 -> {
                            System.out.print("Enter first number: ");
                            double a = scanner.nextDouble();
                            
                            System.out.print("Enter second number: ");
                            double b = scanner.nextDouble();
                            
                            System.out.println("Answer = " + calculator.add(a,b));
                        }
                            
                            
                        case 2 -> {
                            System.out.print("Enter first number: ");
                            double a = scanner.nextDouble();
                            System.out.print("Enter second number: ");
                            double b = scanner.nextDouble();
                            System.out.println("Answer = " + calculator.subtract(a,b));
                        }
                            
                            
                        case 3 -> {
                            System.out.print("Enter first number: ");
                            double a = scanner.nextDouble();
                            System.out.print("Enter second number: ");
                            double b = scanner.nextDouble();
                            System.out.println("Answer = " + calculator.multiply(a,b));
                        }
                            
                            
                        case 4 -> {
                            System.out.print("Enter first number: ");
                            double a = scanner.nextDouble();
                            System.out.print("Enter second number: ");
                            double b = scanner.nextDouble();
                            System.out.println("Answer = " + calculator.divide(a,b));
                        }
                            
                            
                        case 5 -> {
                            System.out.print("Enter number: ");
                            double a = scanner.nextDouble();
                            System.out.println("Answer = " + calculator.sqrt(a));
                        }
                            
                            
                        case 6 -> {
                            System.out.print("Enter base: ");
                            double a = scanner.nextDouble();
                            System.out.print("Enter exponent: ");
                            double b = scanner.nextDouble();
                            System.out.println("Answer = " + calculator.power(a,b));
                        }
                            
                            
                        case 7 -> {
                            System.out.print("Enter Celsius value: ");
                            double a = scanner.nextDouble();
                            System.out.println("Answer = " + calculator.celsiusToFahrenheit(a));
                        }
                            
                            
                        case 8 -> {
                            System.out.print("Enter Fahrenheit value: ");
                            double a = scanner.nextDouble();
                            System.out.println("Answer = " + calculator.fahrenheitToCelsius(a));
                        }
                            
                            
                        case 9 -> {
                            System.out.print("Enter Dollar amount: ");
                            double a = scanner.nextDouble();
                            System.out.println("Rupees = " + calculator.dollarToRupee(a));
                        }
                            
                            
                        case 10 -> System.out.println("Thank you for using Calculator.");
                            
                            
                        default -> System.out.println("Invalid choice!");
                    }
                    
                }
                catch(IllegalArgumentException e)
                {
                    System.out.println(e.getMessage());
                }
                
                
            }while(choice != 10);
        }
    }
}