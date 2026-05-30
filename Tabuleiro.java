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
        GreenfootImage fundo = new GreenfootImage(largura, altura);
        fundo.drawRect(0,0, largura, altura);
        fundo.setColor(new greenfoot.Color(25,40,0));
        fundo.fill();
        fundo.drawImage(new GreenfootImage("grama.png"), 1, 1);
    }
    


    void drawWorld(){

        int coluna_offset = 0;
        for (int i = largura / 2 + borda; i < largura + borda; i++) {

            int linha_offset = 0;
            for (int j = borda; j < altura + borda; j++) {
                linha_offset += 2;
                Tile novo_tile = new Tile();
                int rng = Greenfoot.getRandomNumber(100);
                if (rng < 10){
                    novo_tile.setImage("grama.png");
                }
                if (rng > 95){
                    novo_tile.setImage("montanha.png");
                }

                getWorld().addObject(novo_tile, i * 2 - linha_offset, j + coluna_offset);
            }
            coluna_offset++;
        }


    }

    public void act()
    {
    }
}
