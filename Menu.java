import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(Singleton.largura * Singleton.tile_tamanho / 2, Singleton.altura * Singleton.tile_tamanho, 1);

        
        prepare();
    }

    private void prepare()
    {
        showText("Batalha naval!", Singleton.largura * Singleton.tile_tamanho / 4, Singleton.tile_tamanho * 2);
        
        Botao start = new Botao();
        start.setImage(new GreenfootImage("Iniciar", 50, Color.RED, Color.WHITE));
        
        Botao sobre = new Botao();
        sobre.setImage(new GreenfootImage("Sobre", 50, Color.RED, Color.WHITE));
        
        addObject(start, Singleton.tile_tamanho * 15, Singleton.tile_tamanho * 5);
        addObject(sobre, Singleton.tile_tamanho * 15, Singleton.tile_tamanho * 7);


        //setWorld(World world)
    }

}