/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maytinh1;

/**
 *
 * @author My PC
 */
public class calculate {
    public String tinhtoan(String e){
        Hauto hauto=new Hauto();
          String[] chuan = hauto.processString(e);
            chuan = hauto.postfix(chuan);
            String result = hauto.valueMath(chuan);
            return result;
    }
    
}
