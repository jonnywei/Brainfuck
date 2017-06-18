package com.yknm.brainfuck;

import java.io.IOException;

/**
 * Created by wjj on 6/17/17.
 */
public class Simple {

    private static byte[] memory = new byte[1024*1024];
    private static int pointer = 0;

    public static void repl(String exp) throws IOException {
        for(int i =0; i < exp.length(); i++){
            char ch = exp.charAt(i);
            switch (ch ){
                case '>':
                    pointer++;
                    break;
                case '<':
                    pointer--;
                    break;
                case '+':
                    memory[pointer]++;
                    break;
                case '-':
                    memory[pointer]--;
                    break;
                case '.':
                    System.out.print((char)memory[pointer]);
                    break;
                case ',':
                    System.in.read(memory,pointer,1);
                    break;
                case '[':
                    if(memory[pointer] == 0){ //jump to ] end
                        char nc = exp.charAt(++i);
                        while (nc !=']'){
                            nc = exp.charAt(++i);
                        }
                    }
                    break;
                case ']':
                    if(memory[pointer] != 0){ //jump to [ end
                        char nc = exp.charAt(--i);
                        while (nc != '['){
                            nc = exp.charAt( --i);
                        }
                    }
                    break;
                default:
                    break;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        String s = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]\n" +
                ">++.>+.+++++++..+++.>++.<<+++++++++++++++.\n" +
                ">.+++.------.--------.>+.>.";
        repl(s);

    }
}
