/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Pumkin
 */
public class Controller implements ActionListener{

    private StartPanel startPanel;
    private GamePanel gamePanel;
    private JFrame fStart;
    private JFrame fGame;
    private Model model;

    public Controller(StartPanel startPanel, GamePanel gamePanel, JFrame fStart, JFrame fGame, Model model) {
        this.startPanel = startPanel;
        this.gamePanel = gamePanel;
        this.fStart = fStart;
        this.fGame = fGame;
        this.model = model;
        _init_();
    }
    
    
    
    public void _init_(){
        startPanel.startBtn.addActionListener(this);
        gamePanel.finishBtn.addActionListener(this);
        
        gamePanel.pikachu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pikachu1Clicked(evt);
            }
        });
        gamePanel.pikachu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pikachu2Clicked(evt);
            }
        });
        gamePanel.pikachu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pikachu3Clicked(evt);
            }
        });
        gamePanel.pikachu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pikachu4Clicked(evt);
            }
        });
        gamePanel.pikachu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pikachu5Clicked(evt);
            }
        });
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(startPanel.startBtn)){
            model.setNumPokemon(Integer.valueOf(startPanel.numExtrasComboBox.getSelectedItem().toString()));
            model.setNumPikachu(Integer.valueOf(startPanel.numPikComboBox.getSelectedItem().toString()));
            
            gamePanel.numPikachuLabel.setText(String.valueOf(model.getNumPikachu()));
            try {
                gamePanel.setPokemon(model.getPokemonImgsList(), model.getNumPokemon());
                gamePanel.setPikachu(model.getPikachuImgsList(), model.getNumPikachu());
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            fStart.setVisible(false);
            fGame.setVisible(true);
            
        }else if(e.getSource().equals(gamePanel.finishBtn)){
            gamePanel.numFoundLabel.setText(String.valueOf(countPikachu()));
            if(model.finish(countPikachu())){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Congrats!");
                System.exit(0);
            }else{
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Not all Pikachu are selected.\nKeep trying!");
            }
            
        }
        
        
    }
    
    public int countPikachu(){
        int num = 0;
        for(JLabel l : gamePanel.pikachuLabels){
            if(l.getBorder() != null){
               num = num + 1; 
            }
        }
        return num;
    }
 
    private void pikachu1Clicked(java.awt.event.MouseEvent evt){
        gamePanel.pikachu1.setBorder(gamePanel.pikachuBorder);
    }
    
    private void pikachu2Clicked(java.awt.event.MouseEvent evt){
        gamePanel.pikachu2.setBorder(gamePanel.pikachuBorder);
    }
    
    private void pikachu3Clicked(java.awt.event.MouseEvent evt){
        gamePanel.pikachu3.setBorder(gamePanel.pikachuBorder);
    }
    
    private void pikachu4Clicked(java.awt.event.MouseEvent evt){
        gamePanel.pikachu4.setBorder(gamePanel.pikachuBorder);
    }
    
    private void pikachu5Clicked(java.awt.event.MouseEvent evt){
        gamePanel.pikachu5.setBorder(gamePanel.pikachuBorder);
    }
    
}
