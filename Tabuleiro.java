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
    private Tile[][] tiles = new Tile[largura][altura];

    public Tabuleiro(){

    }
    


    void drawWorld(){
        GreenfootImage img = new GreenfootImage(largura * Singleton.tile_tamanho * 2 - 4, altura * Singleton.tile_tamanho - 4);
        GreenfootImage grama = new GreenfootImage("images/grama.png");
        GreenfootImage mar = new GreenfootImage("images/mar.png");
        GreenfootImage montanha = new GreenfootImage("images/montanha.png");
        GreenfootImage tileatual = mar;
        
        int coluna_offset = 0;
        for (int i = 0; i < largura; i++) {
            int linha_offset = 0;
            for (int j = 0; j < altura; j++) {
                linha_offset += 2;
                Tile novo_tile = new Tile();
                img.drawImage(tileatual, (largura + i + borda) * 16 - linha_offset * 8, (j + borda) * 8 + coluna_offset * 8);
                tiles[i][j] = novo_tile;
            }
            coluna_offset++;
        }

        setImage(img);
    }

    public void act()
    {

    }
}
