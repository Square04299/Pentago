/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package G45502.Pentago.alert;

import javafx.scene.control.Alert;

/**
 *
 * @author G45502
 */
public class AddMarbleSame extends Alert{
    /**
     * Builder of diaolog box
     */
    public AddMarbleSame() {
        super(Alert.AlertType.INFORMATION);
        this.setTitle("Wrong State");
        this.setHeaderText(null);
        this.setHeaderText("You are trying to add your mable to your marble");
        this.setContentText("Why would you change your mable with another one of your marble");
    }
}
