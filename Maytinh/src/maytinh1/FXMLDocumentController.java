package maytinh1;

import static java.lang.StrictMath.sqrt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author My PC
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private RadioButton draw = new RadioButton();
    @FXML
    private RadioButton two = new RadioButton();
    @FXML
    private RadioButton eight = new RadioButton();
    @FXML
    private RadioButton sixteen = new RadioButton();
    @FXML
    private RadioButton ten = new RadioButton();
    @FXML
    private TextArea n = new TextArea();

    @FXML
    private TextField n2 = new TextField();
    @FXML
    private Button bang = new Button();

    @FXML
    private MenuItem flag1;
    @FXML
    private MenuItem flag2;
    @FXML
    private MenuItem flag3;
    @FXML
    private MenuItem flag4;

    public String p = n.getText();

    @FXML
    public void handleButtonAction(ActionEvent e) {
        String c = n.getText();
        String d = ((Button) e.getSource()).getText();
        n.setText(c + d);
    }

    @FXML
    public void vedothi(ActionEvent e) {
//PlotFunctionPanel p1=new PlotFunctionPanel();
        String k1 = n.getText();
        int m = k1.length();
        char name[] = k1.toCharArray();
        k1 = String.copyValueOf(name, 2, m - 2);
        int size = 500;
        double value = 10;
        JFrame frame = new JFrame("MATH FUNCTION");
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PlotFunctionPanel panel = new PlotFunctionPanel(size, value, k1);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

    }

    @FXML
    public void xoabo(ActionEvent e) {
        n.setText("");
        n2.setText("");
    }

    @FXML
    public void del(ActionEvent e) {
        String c = n.getText();
        int k = c.length();
        c = c.substring(0, k - 1);
        n.setText(c);
    }

    @FXML
    private int flag;

    @FXML
    public void pt(ActionEvent e) {
        n.setText("a= ");
        if (e.getSource() == flag1) {
            flag = 1;
        }
        if (e.getSource() == flag2) {
            flag = 2;
        }
        if (e.getSource() == flag3) {
            flag = 3;
        }
        if (e.getSource() == flag4) {
            flag = 4;
        }
    }

    @FXML
    public void doi2(ActionEvent e) {
        if (e.getSource() == two) {
            String show = n.getText();

        }
    }
    @FXML
    private float a, b, c, d;
    private boolean cho;

    @FXML
    public void giaipt(ActionEvent e) {
        String k = n.getText();
        if (k.charAt(0) == 'a') {
            int m = k.length();
            char name[] = k.toCharArray();
            k = String.copyValueOf(name, 3, m - 3);
            a = Float.parseFloat(k);
            if (flag >= 1) {
                n.setText("b= ");
            }
            return;

        }
        if (k.charAt(0) == 'b') {
            int m = k.length();
            char name[] = k.toCharArray();
            k = String.copyValueOf(name, 3, m - 3);
            b = Float.parseFloat(k);
            if (flag >= 2) {
                n.setText("c= ");
                return;
            } else {
                cho = true;
            }

        }
        if (k.charAt(0) == 'c') {
            int m = k.length();
            char name[] = k.toCharArray();
            k = String.copyValueOf(name, 3, m - 3);
            c = Float.parseFloat(k);
            if (flag == 3) {
                n.setText("d= ");
                return;
            } else {
                cho = true;
            }

        }
        if (k.charAt(0) == 'd') {
            int m = k.length();
            char name[] = k.toCharArray();
            k = String.copyValueOf(name, 3, m - 3);
            d = Float.parseFloat(k);
            cho = true;

        }
        if (cho == true) {
            if (flag == 1) {
                float x = (float) (-b / a);
                n2.setText("x= " + x);
            }
            if (flag == 2) {
                float de = b * b - 4 * a * c;
                if (de < 0) {
                    n2.setText("error");
                }
                if (de == 0) {
                    float x = -b / (2 * a);
                    n2.setText("x1 = x2 = " + x);
                }
                if (de > 0) {
                    float x1, x2;
                    x1 = (float) ((-b + sqrt(de)) / (2 * a));
                    x2 = (float) ((-b - sqrt(de)) / (2 * a));
                    n2.setText("x1= " + x1 + " x2= " + x2);
                }
            }

        }
    }

    @FXML
    public void ketqua(ActionEvent e) {
        Coso coso = new Coso();
        Hauto hauto = new Hauto();
        String exp = n.getText();
        if (ten.isSelected()) {
            calculate c1 = new calculate();
            String result = c1.tinhtoan(exp);
            n2.setText(result);
        }
        if (two.isSelected()) {
            int i = 0;
            while (i < exp.length()) {
                if (exp.charAt(i) <= 57 && exp.charAt(i) >= 50) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == exp.length()) {
                String[] chuan = hauto.processString(exp);

                for (int j = 0; j < chuan.length; j++) {
                    if (chuan[j].charAt(0) == 48 || chuan[j].charAt(0) == 49) {
                        int x = Integer.parseInt(chuan[j]);
                        chuan[j] = coso.haisang10(x);
                    }
                }
                String[] chuan1 = hauto.postfix(chuan);
                String result = hauto.valueMath(chuan1);
                String r = coso.doitu10((int) Double.parseDouble(result), 2);
                n2.setText(r);
            } else {
                n2.setText("Syntax Error");
            }
        }
        if (sixteen.isSelected()) {
            String[] chuan = hauto.processString(exp);

            for (int j = 0; j < chuan.length; j++) {
                if ((chuan[j].charAt(0) >= 65 && chuan[j].charAt(0) <= 70) || (chuan[j].charAt(0) >= 48 && chuan[j].charAt(0) <= 57)) {
                    chuan[j] = coso.muoisausang10(chuan[j]);
                }
            }
            String[] chuan1 = hauto.postfix(chuan);
            String result = hauto.valueMath(chuan1);
            String r = coso.doitu10((int) Double.parseDouble(result), 16);
            n2.setText(r);
        }
        if (eight.isSelected()) {
            int i = 0;
            while (i < exp.length()) {
                if (exp.charAt(i) <= 57 && exp.charAt(i) >= 56) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == exp.length()) {
                String[] chuan = hauto.processString(exp);

                for (int j = 0; j < chuan.length; j++) {
                    if (chuan[j].charAt(0) >= 48 && chuan[j].charAt(0) <= 55) {
                        int x = Integer.parseInt(chuan[j]);
                        chuan[j] = coso.tamsang10(x);
                    }
                }
                String[] chuan1 = hauto.postfix(chuan);
                String result = hauto.valueMath(chuan1);
                String r = coso.doitu10((int) Double.parseDouble(result), 8);
                n2.setText(r);
            } else {
                n2.setText("Syntax Error");
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
