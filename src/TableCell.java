
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author satranga
 */
public class TableCell {
    private java.awt.Color color;
    private String text;
    private boolean visible;

    
    public TableCell(java.awt.Color color,String text) {
        this.color = color;
        this.text = text;
        this.visible = false;
    }
    
    public void setColor(java.awt.Color color) {
        this.color = color;
    }
    
    public java.awt.Color getColor() {
        return color;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getText() {
        return text;
    }
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public boolean getVisible() {
        return visible;
    }
}

