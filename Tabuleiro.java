import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

public class Tabuleiro extends World {

    private int altura = Singleton.altura;
    private int largura = Singleton.largura;
    private Tile[][] tiles = new Tile[largura][altura];

    public Tile tile_selecionado;

    GreenfootImage quadro;

    public Tabuleiro() {
        super(
            Singleton.largura * 4 + 4,
            Singleton.altura * 2 + 4,
            Singleton.tile_tamanho / 4
        );
        // Criar imagem para caber um tabuleiro com u
        GreenfootImage mar = new GreenfootImage("images/mar.png");
        GreenfootImage mar_selecionado = new GreenfootImage(
            "images/mar_selecionado.png"
        );

        quadro = new GreenfootImage(
            Singleton.largura * Singleton.tile_tamanho + Singleton.tile_tamanho,
            Singleton.altura * Singleton.tile_tamanho + Singleton.tile_tamanho
        );

        // Criar objetos das casas do tabuleiro
        for (int i = 0; i < largura; i++) {
            for (int j = 0; j < altura; j++) {
                Tile novo_tile = new Tile(mar, mar_selecionado);
                tiles[i][j] = novo_tile;
            }
        }

        prepare();
    }

    private void prepare() {
        renderizar();
    }

    void desenhar_fundo(GreenfootImage imagem) {
        imagem.setColor(new greenfoot.Color(125, 140, 225));
        imagem.fill();
    }

    void desenhar_tabuleiro(GreenfootImage imagem) {
        GreenfootImage grama = new GreenfootImage("images/grama.png");
        //GreenfootImage mar = new GreenfootImage("images/mar.png");
        GreenfootImage montanha = new GreenfootImage("images/montanha.png");
        //GreenfootImage tileatual = mar;

        int coluna_offset = 0;
        for (int i = 0; i < largura; i++) {
            int linha_offset = 0;
            for (int j = 0; j < altura; j++) {
                linha_offset += 2;
                int x = (largura + i + 1) * 16 - linha_offset * 8;
                int y = j * 8 + coluna_offset * 8;
                imagem.drawImage(tiles[i][j].tile_atual, x, y);
            }
            coluna_offset++;
        }
    }

    void renderizar() {
        quadro.clear();
        setBackground(quadro);
        desenhar_fundo(quadro);
        desenhar_tabuleiro(quadro);
        setBackground(quadro);
    }

    int[] quadro_para_tabuleiro(int x, int y) {
        double x_i = (0.5 * 4);
        double x_j = (-0.5 * 4);
        double y_i = (0.25 * 4);
        double y_j = (0.25 * 4);

        double determinante = 1 / (x_i * y_j - y_i * x_j);

        double a = (determinante * y_j);
        double b = (determinante * -x_j);
        double c = (determinante * -y_i);
        double d = (determinante * x_i);

        double quadro_x = a * x + b * y;
        double quadro_y = c * x + d * y;
        int[] posicao_quadro = {
            (int) Math.floor(quadro_x) - largura / 2 - 1,
            (int) Math.floor(quadro_y) + altura / 2,
        };
        return posicao_quadro;
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            greenfoot.MouseInfo click_mouse = Greenfoot.getMouseInfo();
            int mouse_x = click_mouse.getX();
            int mouse_y = click_mouse.getY();
            System.out.println((mouse_x) + " mouse " + mouse_y);
            int[] tile_clicado = quadro_para_tabuleiro(mouse_x, mouse_y);
            System.out.println(
                Math.ceil(tile_clicado[0]) +
                    " tabuleiro" +
                    Math.ceil(tile_clicado[1])
            );
            if (
                tile_clicado[0] >= 0 &&
                tile_clicado[0] < largura &&
                tile_clicado[1] >= 0 &&
                tile_clicado[1] < largura
            ) {
                // tile_selecionado.deselecionar();
                tile_selecionado = tiles[tile_clicado[0]][tile_clicado[1]];
                tiles[tile_clicado[0]][tile_clicado[1]].selecionar();
            }
        }
        renderizar();
        // tiles[1][0].selecionar();
    }
}
