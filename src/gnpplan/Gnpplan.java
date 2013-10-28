/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gnpplan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author test
 */
public class Gnpplan {
    static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    static final Date date = new Date();
    static final String testdate = dateFormat.format(date);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println(konversiwaktu(3700));
        ArrayList<int[][]> data = new ArrayList<>();
        int amount = 300;
        int[][] stuck = new int[2][2];
        stuck[0][0] = 50;
        stuck[0][1] = 100;
        stuck[1][0] = 212;
        stuck[1][1] = 280;
        int[][] data1 = functionlist.makerandomdataset(amount,stuck,10,12);
        int[][] data2 = functionlist.makerandomdataset(amount,stuck,20,30);
        data.add(data1);
        data.add(data2);
        String[] label = {"rule","coverage"};
        plot.makeplot(data,label,"rule coverage","iteration","rule/data");
        
        data = new ArrayList<>();
        int[][] stuck1 = new int[2][2];
        stuck1[0][0] = 100;
        stuck1[0][1] = 101;
        stuck1[1][0] = 280;
        stuck1[1][1] = 281;
        data1 = functionlist.makerandomdataset1(amount,stuck1,60,20);
        data.add(data1);
        String[] label1 = {"rule"};
        plot.makeplot(data,label1,"support","iteration","support(%)");
        
        data = new ArrayList<>();
        int[][] stuck2 = new int[47][2];
        for(int i=0;i<47;i++){
            stuck2[i][0] = i;
            stuck2[1][1] = i-1;
        }
        data1 = functionlist.makerandomdataset1(amount,stuck2,50,1);
        data.add(data1);
        String[] label2 = {"node"};
        plot.makeplot(data,label2,"node amount","iteration","node");
    }
    public static String konversiwaktu(int sec){
        int hours = sec / 3600;
        int remainder = sec - hours * 3600;
        int mins = remainder / 60;
        remainder = remainder - mins * 60;
        int secs = remainder;
        String out = hours+" "+mins+" "+secs;
        return out;
    }
}
