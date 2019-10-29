/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WheresPikachu;

import CharacterApi.ICharacter;
import GUI.Controller;
import GUI.GamePanel;
import GUI.Model;
import GUI.StartPanel;
import Loader.CharacterJsonLoader;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Pumkin
 */
public class WheresPikachu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame fStart = new JFrame();
        fStart.setSize(new Dimension(320, 220));
        JFrame fGame = new JFrame();
        fGame.setSize(new Dimension(1000, 600));
        StartPanel startPanel = new StartPanel();
        GamePanel gamePanel = new GamePanel();
        Model model = new Model();
        fStart.add(startPanel);
        fGame.add(gamePanel);
        
        
        Controller controller = new Controller(startPanel, gamePanel, fStart, fGame, model);
        fStart.setVisible(true);
        fGame.setVisible(false);
    }
    
}
