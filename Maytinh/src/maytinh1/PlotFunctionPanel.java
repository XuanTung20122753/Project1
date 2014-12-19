package maytinh1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Arrays;
import javax.swing.JPanel;

/**
 *
 * @author My PC
 */
class PlotFunctionPanel extends JPanel{
    FXMLDocumentController k=new FXMLDocumentController();
    
    int size ;
    static double maxValue ;
    String d;
    public PlotFunctionPanel(int s, double v, String p) {
        size = s;
        maxValue = v;
      d=p;
        setPreferredSize(new Dimension(size, size));
    }

    PlotFunctionPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void paintComponent(Graphics g) {
        
        g.drawLine(size / 2, 0, size / 2, size);
        g.drawLine(0, size / 2, size, size / 2);
        double[] tick = getTicks();
        int x = size / 10, y = size / 2, vA = 8;
        g.setFont(new Font("Sansserif", Font.PLAIN, size / 30));
        for (int i = 0; i < 9; i++) {
            g.drawLine(x, y + 5, x, y - 5);
            if (i != 4 && vA != 4) {
                if (i > 4) {
                    g.drawString(tick[i] + "", x - size / 40, y + size / 21);
                } else {
                    g.drawString(tick[i] + "", x - size / 30, y + size / 21);
                }
                if (vA > 4) {
                    g.drawString(tick[vA] + "", y - size / 13, x + size / 60);
                } else {
                    g.drawString(tick[vA] + "", y - size / 12, x + size / 60);
                }
            }
            g.drawLine(y + 5, x, y - 5, x);
            x += size / 10;
            vA--;
        }
        g.setColor(Color.RED);
        double min = (-maxValue), max = maxValue, ratio = size / (max * 2), fx;
        for (; min <= max; min += 0.001) {
            
               String o="";
            for(int i=0;i<d.length();i++){
                if(d.charAt(i)=='x')
                    o=o+Double.toString(min);
                else o=o+d.charAt(i);
            }
            Hauto hauto=new Hauto();
            String[] chuan = hauto.processString(o);
            chuan = hauto.postfix(chuan);
            String result = hauto.valueMath(chuan);
            fx=Double.parseDouble(result);
            
            min = Math.round(min * 1000.0) / 1000.0;
            fx = Math.round(fx * 1000.0) / 1000.0;
                        g.drawLine((int) (size / 2 + (ratio * min)), (int) (size / 2 - (ratio * fx)),
                    (int) (size / 2 + (ratio * min)), (int) (size / 2 - (ratio * fx)));
        }
    }

    //finds the values of the ticks on the axis e.g. -2.0, -1.5, -1.0, -0.5, 0.0, etc
    private static double[] getTicks() {
        double increment = maxValue / 5, currentTick = -1 * (maxValue);
        double[] tick = new double[9];
        for (int i = 0; i < 9; i++) {
            currentTick += increment;
            tick[i] = Math.round(currentTick * 100.0) / 100.0;
        }
        return tick;
    }
}
