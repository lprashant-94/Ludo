package com.lprashant.ludo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Game g = new Game(new Dice());
        g.start();
    }
}
