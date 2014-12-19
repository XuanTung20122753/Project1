/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maytinh1;

import static java.lang.StrictMath.pow;

/**
 *
 * @author My PC
 */
public class Coso {
     
        public String doitu10(int nguon, int base) {
           String s = "";
            char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            char[] out=new char[100];
            int i=0;
            while(nguon>0){
                out[i++]=digit[nguon%base];
                nguon=nguon/base;}
            i--;
            for(;i>=0;i--){
            s = s + out[i];}
            return s;
        }
         public String haisang10(int n) {
             String s="";
            int i=0;
            int t=0;
           while(n>0){
               int k=n%10;
               t=  (int) (t+k*pow(2,i));
               n=n/10;
               i+=1;
           }
           s=Integer.toString(t);
            return s;
        }
       public String tamsang10(int n){
            String s="";
            int i=0;
            int t=0;
           while(n>0){
               int k=n%10;
               t=  (int) (t+k*pow(8,i));
               n=n/10;
               i+=1;
           }
           s=Integer.toString(t);
            return s;
       }
       public String muoisausang10(String n){
            String p="0123456789ABCDEF";
            int S=0;
            for(int i=0;i<n.length();i++){
                char c=n.charAt(i);
                int h=p.indexOf(c);
                S=(int) (S+h*pow(16,(n.length()-(i+1))));
            }
            String k=Integer.toString(S);
            return k;
       }
         
}
