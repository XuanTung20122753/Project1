package com.example.calculatorxt;
import static java.lang.StrictMath.*;
import java.util.Arrays;
import java.util.Stack;
public class Hauto {
	public int priority(char c) {        // thiet lap thu tu uu tien
        if (c == '+' || c == '-') {
            return 1;
        }
        if (c == 's' || c == 'c' || c == 't' || c == '^') {
            return 3;
        } else if (c == '*' || c == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    public boolean isOperator(char c) {  // kiem tra xem co phai toan tu
        char operator[] = {'+', '-', '*', '/', ')', '('};
        Arrays.sort(operator);
        if (Arrays.binarySearch(operator, c) > -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean luonggiac(char c) {
        char operator1[] = {'s', 'c', 't','C'};
        Arrays.sort(operator1);
        if (Arrays.binarySearch(operator1, c) > -1) {
            return true;
        } else {
            return false;
        }
    }

    public String[] processString(String sMath) { // xu ly bieu thuc nhap vao thanh cac phan tu
        String s1 = "", elementMath[] = null;
        Hauto IFP = new Hauto();
        
        int p = sMath.length();
        int dau = 1;
        int ngoac = 0;
        for (int i = 0; i < p; i++) {
            if (ngoac == 0) {
                if (dau == 0 && IFP.isOperator(sMath.charAt(i))) {
                    dau = 1;
                }
             
               else if (dau == 1 && sMath.charAt(i)!='-') {
                    dau = 0;
                }
             
               else if (dau == 1 && sMath.charAt(i)=='-') {
                    char[] k = sMath.toCharArray();
                    sMath = String.copyValueOf(k, 0, i) + "(0" + String.copyValueOf(k, i, p - i);
                    ngoac = 1;
                    p = sMath.length();
                    i=i+2;
                    continue;
                }
            }
            if(ngoac==1){
                if(i==p-1){
                   
                    char[] v=sMath.toCharArray();
                    sMath=String.copyValueOf(v, 0, i+1)+")";
                    ngoac=0;
                }
                if(IFP.isOperator(sMath.charAt(i))){
               
                    char[] v=sMath.toCharArray();
                    sMath=String.copyValueOf(v, 0, i)+")"+String.copyValueOf(v, i, p-i);
                    ngoac=0;
                    i=i+1;
                    p=sMath.length();
                    continue;
                }
            }
        }
        sMath = sMath.trim();
        sMath = sMath.replaceAll("\\s+", " "); //    chuan hoa sMath

        for (int i = 0; i < sMath.length(); i++) {
            
            char c = sMath.charAt(i);
            if (c == 'e') {
                s1 = s1 + "2.71828";
            } else if (!IFP.isOperator(c)) {
                s1 = s1 + c;
            } else {
                s1 = s1 + " " + c + " ";
            }
        }
        s1 = s1.trim();
        s1 = s1.replaceAll("\\s+", " ");

        elementMath = s1.split(" "); //tach s1 thanh cac phan tu
        //System.out.println(s1);
        return elementMath;
    }

    public String[] postfix(String[] elementMath) {
        Hauto IFP = new Hauto();
        String s1 = "", E[];
        Stack<String> S = new Stack<String>();
        for (int i = 0; i < elementMath.length; i++) {    // duyet cac phan tu
            char c = elementMath[i].charAt(0);  // c la ky tu dau tien cua moi phan tu

            if (!IFP.isOperator(c) && !IFP.luonggiac(c)) // neu c khong la toan tu
            {
                s1 = s1 + " " + elementMath[i];     // xuat elem vao s1
            } else {                       // c la toan tu
                if (c == '(') {
                    S.push(elementMath[i]);   // c la "(" -> day phan tu vao Stack
                } else {
                    if (c == ')') {          // c la ")"
                        char c1;        //duyet lai cac phan tu trong Stack
                        do {
                            c1 = S.peek().charAt(0);    // c1 la ky tu dau tien cua phan tu
                            if (c1 != '(') {
                                s1 = s1 + " " + S.peek();    // trong khi c1 != "("
                            }
                            S.pop();
                        } while (c1 != '(');
                    } else {
                        while (!S.isEmpty() && IFP.priority(S.peek().charAt(0)) >= IFP.priority(c)) {
                            // Stack khong rong va trong khi phan tu trong Stack co do uu tien >= phan tu hien tai
                            s1 = s1 + " " + S.peek();   // xuat phan tu trong Stack ra s1
                            S.pop();
                        }
                        S.push(elementMath[i]); //  dua phan tu hien tai vao Stack
                    }
                }
            }
        }
        while (!S.isEmpty()) {   // Neu Stack con phan tu thi day het vao s1
            s1 = s1 + " " + S.peek();
            S.pop();
        }
        s1 = s1.substring(1);
        E = s1.split(" ");  //  tach s1 thanh cac phan tu
        return E;
    }

    private int giaithua(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * (n - 1);
        }
    }

    public String valueMath(String[] elementMath) {
        Stack<String> S = new Stack<String>();
        Hauto IFP = new Hauto();
        for (int i = 0; i < elementMath.length; i++) {
            char c = elementMath[i].charAt(0);
            if (!IFP.isOperator(c) && !IFP.luonggiac(c)) {
                S.push(elementMath[i]);
            } else {
                if (IFP.isOperator(c) && !IFP.luonggiac(c)) {
                    double num = 0f;
                    double num1 = Float.parseFloat(S.pop());
                    double num2 = Float.parseFloat(S.pop());
                    switch (c) {
                        case '+':
                            num = num2 + num1;
                            break;
                        case '-':
                            num = num2 - num1;
                            break;
                        case '*':
                            num = num2 * num1;
                            break;
                        case '/':
                            num = num2 / num1;
                            break;
                        case '^':
                            num = pow(num2, num1);
                            break;
                        case '%':
                            num = (double) ((int) num2 % (int) num1);
                            break;
                        default:
                            break;
                    }
                    S.push(Double.toString(num));
                }
                if (!IFP.isOperator(c) && IFP.luonggiac(c)) {
                    double num = 0f;
                    double num1 = Float.parseFloat(S.pop());
                    switch (c) {
                        case 's':
                            num = sin(num1);
                            break;
                        case 'c':
                            num = cos(num1);
                            break;
                        case 't':
                            num = tan(num1);
                            break;
                        case 'C':
                            num=1/tan(num1);
                        case '!':
                            num = IFP.giaithua((int) num1);
                            break;
                        default:
                            break;
                    }
                    S.push(Double.toString(num));
                }
            }
        }
        String u = S.pop();
        double q = Double.parseDouble(u);
        q = Math.round(q * 100000000.0) / 100000000.0;
        u = Double.toString(q);
        return u;
    }

}
