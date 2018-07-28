package xyz.supermoonie;

import xyz.supermoonie.winio.VirtualKeyBoard;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        VirtualKeyBoard.press(new String[]{"a", "B", "&", "Backspace"}, 0, 60);
    }
}
