import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.*;

/**
 * Write a description of class Tabuleiro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tabuleiro extends Actor
{
    /**
     * Act - do whatever the Tabuleiro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int altura = Singleton.altura;
    private int largura = Singleton.largura;
    private int borda = 2;

    public Tabuleiro(){

    }
    


    void drawWorld(){
        GreenfootImage img = new GreenfootImage(Singleton.largura * 32, Singleton.altura * 32);
        GreenfootImage grama = new GreenfootImage("images/grama.png");
        GreenfootImage mar = new GreenfootImage("images/mar.png");
        GreenfootImage montanha = new GreenfootImage("images/montanha.png");
        GreenfootImage tileatual = mar;
        int coluna_offset = 0;
        for (int i = largura / 2 + borda; i < largura + borda; i++) {

            int linha_offset = 0;
            for (int j = borda; j < altura + borda; j++) {
                linha_offset += 2;
                Tile novo_tile = new Tile();
                int rng = Greenfoot.getRandomNumber(100);
                if (rng < 10){
                    novo_tile.setImage("grama.png");
                    //tileatual = grama;
                }
                else if (rng > 95){
                    novo_tile.setImage("montanha.png");
                   //tileatual = montanha;
                } else {
                    //tileatual = mar;
                }
                //img.drawImage(tileatual, i * 16 - linha_offset * 8, j * 8 + coluna_offset * 8);
                getWorld().addObject(novo_tile, i * 2 - linha_offset, j + coluna_offset);
            }
            coluna_offset++;
        }

        setImage(img);
    }

    public void act()
    {
    }
}
