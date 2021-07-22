import java.util.Scanner;

public class Calculator {

    private String[] strList;
    private int first;
    private int second;
    private int rez;
    private boolean f = true;

    public static void main(String[] args) {
        Calculator calcul = new Calculator();
        calcul.consoleOutputGreeting();
        calcul.reformInProblem();
        calcul.calc();
        calcul.consoleRezOutput();
    }

    public void consoleOutputGreeting() {
        String greeting = "Привет, введи пример, чтобы я решил его!";
        System.out.println(greeting);
    }

    public String consoleInputExpression() {
        Scanner in = new Scanner(System.in);
        String str;
        str = in.nextLine();
        return str;
    }

    public void reformInProblem() {
        this.strList = this.consoleInputExpression().split(" ");
        try {
            this.first = Integer.parseInt(this.strList[0]);
        } catch (NumberFormatException e) {
            System.out.println("Ожидалось число, а введена строка");
        }
        try {
            this.second = Integer.parseInt(this.strList[2]);
        } catch (NumberFormatException e) {
            System.out.println("Ожидалось число, а введена строка: ");
        }
    }

    public void calc() {
        int first;
        int second;
        switch (this.strList[1]) {
            case "+": this.rez = this.first + this.second; break;
            case "-": this.rez = this.first - this.second; break;
            case "/":  try {
                            this.rez = this.first / this.second;
                        } catch (ArithmeticException e) {
                            System.out.println("На ноль делить нельзя");
                            this.f = false;
                        } break;
            case "*": this.rez = this.first * this.second; break;
        }
    }

    public void consoleRezOutput() {
        if(this.f) {
            System.out.println("= " + rez);
        }
    }


}
