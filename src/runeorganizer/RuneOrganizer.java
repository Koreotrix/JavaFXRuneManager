/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runeorganizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import runeorganizer.model.Monster;
import runeorganizer.model.Rune;
import runeorganizer.model.RunePreset;

/**
 *
 * @author trist
 */
public class RuneOrganizer extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        
        Rune rune = new Rune();
        RunePreset preset = new RunePreset(new Rune[]{rune});
        
        Monster mon = new Monster();
        
        mon.setAllRunes(preset);
        
        System.out.println(mon.calculateAddedStats());
        System.out.println(mon.calculateStatsTotal());
    }
    
}
