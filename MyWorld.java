import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.Vector;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
//    public Vector

    public MyWorld()
    {

        super(Singleton.largura * 2 + 4, Singleton.altura *  2 + 4, Singleton.tile_tamanho / 4);
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //GreenfootImage fundo = new GreenfootImage(Singleton.largura * Singleton.tile_tamanho / 2, Singleton.altura * Singleton.tile_tamanho);
        GreenfootImage fundo = new GreenfootImage(Singleton.largura, Singleton.altura);
        fundo.setColor(new greenfoot.Color(125,140,225));
        fundo.fillRect(0,0, Singleton.largura, Singleton.altura);
//        fundo.drawImage(new GreenfootImage("grama.png"), 1, 1);
        setBackground(fundo);

        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Tabuleiro tabuleiro = new Tabuleiro();
        addObject(tabuleiro, Singleton.largura * 2 - 2, Singleton.altura *  2 - 2);
        tabuleiro.drawWorld();
    
    }
}
