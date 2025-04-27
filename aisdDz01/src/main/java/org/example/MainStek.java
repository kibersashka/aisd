package org.example;



public class MainStek {
    StekImpl<Character> stek = new Stek<>();
    public static void main(String[] args) {

        StekImpl<Character> stek = new Stek<>();
        String str = "()()((()))";
        //stek.add(str.charAt(0));
        String[] validCases = {
                "",     // пустая строка
                "()",   // простые валидные
                "{}",
                "[]",
                "({[]})",  // вложенные валидные
                "[{()}]",
                "({})[]",//
                "(){}[]",  // сложные валидные
                "({[]})[{}]",
                "{[()]}"
        };

        String[] invalidCases = {
                "(",   // незакрытые
                ")",//
                "[",
                "]",//
                "{",
                "}",//
                "(]",   // несоответствующие типы
                "{)",
                "[}",
                "{(})",  // неправильная вложенность
                "({[}])",
                "([)]",
                "{[}]",
                ")(",   // неправильный порядок
                "][",
                "}{",
                "()[]{)",  // смешанные невалидные
                "({[}])",
                "{([]})"
        };
        getCheking(validCases, stek);
        getCheking(invalidCases, stek);



    }
    public static boolean chek(Character ch1, char ch2){
        if (ch1 != null && (ch1 + ch2 == '(' + ')' || ch1 + ch2 == '{' + '}' || ch1 + ch2 == '[' + ']')){
            return true;
        }

        return false;
    }
    public static void getCheking(String[] arr, StekImpl<Character> stek){
        for(int j = 0; j < arr.length; j++) {
            if (arr[j].length() == 0){
                System.out.println(true);
                continue;
            }
            stek.add(arr[j].charAt(0));
            for(int i = 1; i < arr[j].length(); i++){
                char step = arr[j].charAt(i);
                if(chek(stek.get(), step)) {
                    stek.remove();
                } else{
                    stek.add(step);
                }
            }
            System.out.println(stek.size() == 0);
        }
    }
}
