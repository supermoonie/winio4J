package com.github.supermoonie;

import com.github.supermoonie.winio.VirtualKeyBoard;

/**
 * Hello world!
 *aB
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        VirtualKeyBoard.press(new String[]{"a", "B", "&", "Backspace"}, 0, 60);
    }
}
