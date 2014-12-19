package com.example.calculatorxt;

import android.R.color;
import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	float k;
	boolean hai, tam, muoi, muoisau;
	//RadioGroup rad=(RadioGroup) findViewById(R.id.radioGroup1);
	//RadioButton ten, sixteen, two1, eight1;
	//int check=rad.getCheckedRadioButtonId();
	Button one ,two, three,four, five, six, seven, eight, nine, sin,cos,tan,cotg,result, summation, 
	subtract, multi, dvision,a1,b1,c1,d1,e,f, draw,ac,del,gt,mu,muoimu, k1,k2,k3,k4;
	TextView n2;
	TextView n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
    }
public void Init(){
//	ten=(RadioButton)findViewById(R.id.ten);
//	two1=(RadioButton)findViewById(R.id.two);
//	sixteen=(RadioButton)findViewById(R.id.sixteen);
//	eight1=(RadioButton)findViewById(R.id.editText1);
	one=(Button)findViewById(R.id.button23);
	two=(Button)findViewById(R.id.button24);
	three=(Button)findViewById(R.id.button25);
	four=(Button)findViewById(R.id.button16);
	five=(Button)findViewById(R.id.button17);
	six=(Button)findViewById(R.id.button18);
	seven=(Button)findViewById(R.id.button9);
	eight=(Button)findViewById(R.id.button10);
	nine=(Button)findViewById(R.id.button11);
	sin=(Button)findViewById(R.id.button7);
	cos=(Button)findViewById(R.id.button14);
	tan=(Button)findViewById(R.id.button21);
	cotg=(Button)findViewById(R.id.button28);
	summation=(Button)findViewById(R.id.button22);
	subtract=(Button)findViewById(R.id.button29);
	multi=(Button)findViewById(R.id.button8);
	dvision=(Button)findViewById(R.id.button15);
	a1=(Button)findViewById(R.id.button1);
	b1=(Button)findViewById(R.id.button2);
	c1=(Button)findViewById(R.id.button3);
	d1=(Button)findViewById(R.id.button4);
	e=(Button)findViewById(R.id.button5);
	f=(Button)findViewById(R.id.button6);
	n=(TextView) findViewById(R.id.editText1);
	n2=(TextView) findViewById(R.id.textView4);
	 k1=(Button)findViewById(R.id.button35);
	 k2=(Button)findViewById(R.id.button36);
	 k3=(Button)findViewById(R.id.button37);
	 k4=(Button)findViewById(R.id.button38);
}
String l;




public void choncoso1(View v){
	muoi=true;
	
		l=k1.getText().toString();
	k1.setTextColor(Color.RED);
	k2.setTextColor(Color.GRAY);
	k3.setTextColor(Color.GRAY);
	k4.setTextColor(Color.GRAY);
}
public void choncoso2(View v){
	
	hai=true;
	
	l=k2.getText().toString();
	k1.setTextColor(Color.GRAY);
	k2.setTextColor(Color.RED);
	k3.setTextColor(Color.GRAY);
	k4.setTextColor(Color.GRAY);
}
public void choncoso3(View v){
	
	
	
	l=k3.getText().toString();
	k1.setTextColor(Color.GRAY);
	k2.setTextColor(Color.GRAY);
	k3.setTextColor(Color.RED);
	k4.setTextColor(Color.GRAY);
}
public void choncoso4(View v){
	
	
	l=k4.getText().toString();
	k1.setTextColor(Color.GRAY);
	k2.setTextColor(Color.GRAY);
	k3.setTextColor(Color.GRAY);
	k4.setTextColor(Color.RED);
}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void ans(View v) {
        String c = n.getText().toString();
        String d = Float.toString(k);
        n.setText(c + d);
    }
    
	public void cal(View v){  
    Hauto hauto = new Hauto();
    Coso coso = new Coso();
    String exp = n.getText().toString();
    if (l.charAt(0)=='d') {
        try {
       
      String[] chuan = hauto.processString(exp);
        chuan = hauto.postfix(chuan);
        String result = hauto.valueMath(chuan);
            n2.setText(result);
            k = Float.parseFloat( n2.getText().toString());
        } catch (Exception q) {
            n2.setText("import error - press AC and import again");
        }
    }
    if (l.charAt(0)=='b') {
    	 try{
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
             }catch(Exception q){
                 n2.setText("false, check aquation again");
             }
   }
    if (l.charAt(0)=='h') {
        try{
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
        }catch(Exception q){
            n2.setText("false, check aquation again");
        }
    }
    if (l.charAt(0)=='o') {
        try{
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
    
    }catch(Exception q){
            n2.setText("false, check equation again");
        }
    }
	}
	public void show(View v){
		String c=n.getText().toString();
		Button b=(Button)v;
		String k=b.getText().toString();
		n.setText(c+k);
	}
	public void reset(View v) {
		n.setText("");
        n2.setText("");
	}
	public void del(View v) {
		String c = n.getText().toString();
        int k = c.length();
        c = c.substring(0, k - 1);
        n.setText(c);
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
