package com.sarues.statck;

/**
 * 解决括号匹配问题
 */
public class ParenthesesMatching {

    public static void main(String[] args) {
        String s = "()";
        System.out.println(method(s));
    }

    public static  boolean method(String s){
        ArrayStack<Character> stack  = new ArrayStack<>();
        if(s == "")
            throw new IllegalArgumentException("输入的有效括号字符串不能为空");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if('(' == c || '{'==c || '[' == c)
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                char c2 = stack.pop();
                switch (c){
                    case ')':
                        if(c2 != '(')
                            return false;
                        break;
                    case '}':
                        if(c2 != '{')
                            return false;
                        break;
                    case ']':
                        if(c2 != '[')
                            return false;
                        break;
                }

            }

        }
        return stack.isEmpty();
    }
}
