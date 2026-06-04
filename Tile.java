import greenfoot.GreenfootImage;

/**
 * Write a description of class Tile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tile {

    public GreenfootImage tile_normal;
    public GreenfootImage tile_selecionado;
    public GreenfootImage tile_atual;
    public Boolean selecionado = false;

    public Tile(GreenfootImage normal, GreenfootImage selecionado) {
        tile_normal = normal;
        tile_selecionado = selecionado;
        tile_atual = tile_normal;
    }

    public void selecionar() {
        tile_atual = tile_selecionado;
    }

    public void deselecionar() {
        tile_atual = tile_normal;
    }
}
