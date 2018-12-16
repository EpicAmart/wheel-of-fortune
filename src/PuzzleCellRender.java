
import java.awt.*;
import javafx.scene.paint.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author satranga
 */
public class PuzzleCellRender extends DefaultTableCellRenderer {

//    @Override
    
    

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        TableCell cell = (TableCell)value;
        
        JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        
        if (cell.getText() == " "){
            l.setBackground(java.awt.Color.CYAN);
      
        } else if (cell.getText() == "  "){
            l.setBackground(java.awt.Color.LIGHT_GRAY);
        } else if (!cell.getVisible()) {
            l.setBackground(java.awt.Color.WHITE);
            l.setForeground(java.awt.Color.WHITE);
        } else {
            l.setBackground(java.awt.Color.WHITE);
            //l.setForeground(java.awt.Color.BLACK);
        }
        
        l.setText(cell.getText());
                
        

        //Return the JLabel which renders the cell.
        return l;

    }

}
