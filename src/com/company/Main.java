package com.company;

import java.util.Scanner;



public class Main {

    //public static final Logger logger = Logger.getLogger(Main.class.getName());

    //проверка строки на арабские числа
    static int arab_prov(String a){
        //logger.info("получено: " + a + " arab_prov");
        try {
            if (Integer.valueOf(a) > 0 && Integer.valueOf(a) < 11){
                return Integer.valueOf(a);
            } else {
                return -1;
            }
        } catch (Exception e){
            return -1;
        }
    }

    //перевод римских в арабские
    static int rim_arab(String rimskie){
//logger.info("получено: " + rimskie + " rim_arab");
        switch(rimskie){
            case "X":
                return 10;
            case "IX":
                return 9;
            case "VIII":
                return 8;
            case "VII":
                return 7;
            case "VI":
                return 6;
            case "V":
                return 5;
            case "IV":
                return 4;
            case "III":
                return 3;
            case "II":
                return 2;
            case "I":
                return 1;

        }
        return -1;
    }

    //функция результата операции
    public static int result(int a,int b, char op){

        assert a != 0;
        assert b != 0;
        assert op != ' ';

        //logger.info("получено: " + String.valueOf(a) + " a " + String.valueOf(b) + " b " + op + " op " + "result");

        if(a >= 0 && b >= 0){
            if(op == '+') {
                return a + b;
            } else
            if(op == '-'){
                return a - b;
            } else
            if(op == '/'){
                return a / b;
            } else
            if(op == '*'){
                return a * b;
            }
            else {
                return -1;
            }
        }
        return -1;
    }

    //перевод арабских в римские
    static String arab_rim(int a){

        String S = "";
        int E = 0;//еденици
        int D = 0;//десятки

        if (a > 0 && a < 100) {
            if (a % 10 > 0) {
                E = a % 10;
            }

            if (a % 100 > 0) {
                D = (a % 100 - E) / 10;
            }

            //logger.info("получено число: " + a + ", десятки: " + D + ", еденици: " + E + ", функция arab_rim");

            if (D > 0 && D < 10) {

                if (D == 1)
                    S = "X";
                else if (D == 2)
                    S = "XX";
                else if (D == 3)
                    S = "XXX";
                else if (D == 4)
                    S = "XL";
                else if (D == 5)
                    S = "L";
                else if (D == 6)
                    S = "LX";
                else if (D == 7)
                    S = "LXX";
                else if (D == 8)
                    S = "LXXX";
                else
                    S = "XC";
            }
            //System.out.println(S);

            if (E < 10 && E > 0) {
                if (E == 1)
                    S += "I";
                else if (E == 2)
                    S += "II";
                else if (E == 3)
                    S += "III";
                else if (E == 4)
                    S += "IV";
                else if (E == 5)
                    S += "V";
                else if (E == 6)
                    S += "VI";
                else if (E == 7)
                    S += "VII";
                else if (E == 8)
                    S += "VIII";
                else
                    S += "IX";

            }
        } else if (a == 100) {
            return "C";
        } else {
            return S;
        }
        return S;
    }


    public static void main(String[] args) throws Exception{


        System.out.println("введите выражение");
        Scanner keyboard = new Scanner(System.in);
        String stroka = keyboard.nextLine();
        //String stroka = "V * V";
        String st_a = "";
        String st_b = "";
        char op = ' ';//оператор

//разбираем строку на переменные и оператор
        for (int i = 0; i < stroka.length(); i++) {
            if (stroka.charAt(i) == '+' || stroka.charAt(i) == '-' || stroka.charAt(i) == '*' || stroka.charAt(i) == '/') {
                op = stroka.charAt(i);
            } else if (stroka.charAt(i) != ' ' && op == ' ') {
                st_a += stroka.charAt(i);
            } else if (stroka.charAt(i) != ' ' && op != ' ') {
                st_b += stroka.charAt(i);
            } else if (stroka.charAt(i) == ' ') {
                continue;
            } else {
                System.out.println("введено неправильное выражение ");
                break;
            }
        }

        if (arab_prov(st_a) != -1 && arab_prov(st_b) != -1) {
            System.out.println("output: " + result(arab_prov(st_a), arab_prov(st_b), op));
        } else
        if (rim_arab(st_a) != -1 && rim_arab(st_b) != -1){
            System.out.println("output: " + arab_rim(result(rim_arab(st_a),rim_arab(st_b),op)));
        }
        else {
            System.out.println("введено неправильное выражение ");
        }

    }
}


